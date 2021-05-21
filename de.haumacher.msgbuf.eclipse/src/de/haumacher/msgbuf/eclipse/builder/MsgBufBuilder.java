package de.haumacher.msgbuf.eclipse.builder;

import java.io.File;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import de.haumacher.msgbuf.generator.Generator;
import de.haumacher.msgbuf.generator.ast.DefinitionFile;
import de.haumacher.msgbuf.generator.ast.QName;
import de.haumacher.msgbuf.generator.parser.ParseException;
import de.haumacher.msgbuf.generator.parser.Token;

public class MsgBufBuilder extends IncrementalProjectBuilder {

	class DeltaBuild implements IResourceDeltaVisitor {
		@Override
		public boolean visit(IResourceDelta delta) throws CoreException {
			IResource resource = delta.getResource();
			switch (delta.getKind()) {
			case IResourceDelta.ADDED:
				// handle added resource
				compileProto(resource);
				break;
			case IResourceDelta.REMOVED:
				// handle removed resource
				break;
			case IResourceDelta.CHANGED:
				// handle changed resource
				compileProto(resource);
				break;
			}
			//return true to continue visiting children.
			return true;
		}
	}

	class FullBuild implements IResourceVisitor {
		@Override
		public boolean visit(IResource resource) {
			compileProto(resource);
			//return true to continue visiting children.
			return true;
		}
	}

	public static final String BUILDER_ID = "de.haumacher.msgbuf.builder";

	private static final String MARKER_TYPE = "de.haumacher.msgbuf.eclipse.parseProblem";

	private void addMarker(IFile file, String message, int lineNumber,
			int severity) {
		try {
			IMarker marker = file.createMarker(MARKER_TYPE);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.SEVERITY, severity);
			if (lineNumber == -1) {
				lineNumber = 1;
			}
			marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
		} catch (CoreException e) {
		}
	}

	@Override
	protected IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor)
			throws CoreException {
		if (kind == FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		return null;
	}

	private void fullBuild(final IProgressMonitor monitor) throws CoreException {
		try {
			getProject().accept(new FullBuild());
		} catch (CoreException e) {
		}
	}

	private void incrementalBuild(IResourceDelta delta, IProgressMonitor monitor) throws CoreException {
		// the visitor does the work.
		delta.accept(new DeltaBuild());
	}

	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		// delete markers set and files created
		getProject().deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_INFINITE);
	}

	void compileProto(IResource resource) {
		if (resource instanceof IFile && resource.getName().endsWith(".proto")) {
			IFile file = (IFile) resource;
			deleteMarkers(file);
			
			DefinitionFile definitionFile;
			try {
				definitionFile = Generator.parse(file.getContents());
			} catch (ParseException ex) {
				Token currentToken = ex.currentToken;
				if (currentToken == null) {
					addMarker(file, ex.getMessage(), 1, IMarker.SEVERITY_ERROR);
				} else {
					addMarker(file, ex.getMessage(), currentToken.beginLine, IMarker.SEVERITY_ERROR);
				}
				return;
			} catch (CoreException ex) {
				addMarker(file, "Cannot read: " + ex.getMessage(), 1, IMarker.SEVERITY_ERROR);
				return;
			}
			
			File dir = file.getLocation().toFile().getParentFile();
			QName pkgName = definitionFile.getPackage();
			if (pkgName != null) {
				for (int n = 0, cnt = pkgName.getNames().size(); n < cnt; n++) {
					dir = dir.getParentFile();
				}
			}
			Generator generator = new Generator();
			generator.setOut(dir);
			generator.load(definitionFile);
			generator.generate();
			
			try {
				file.getParent().refreshLocal(IContainer.DEPTH_ONE, null);
			} catch (CoreException ex) {
			}
		}
	}

	private void deleteMarkers(IFile file) {
		try {
			file.deleteMarkers(MARKER_TYPE, false, IResource.DEPTH_ZERO);
		} catch (CoreException ce) {
		}
	}

}
