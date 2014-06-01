package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

import org.apache.tools.ant.DirectoryScanner;
import org.drools.RuntimeDroolsException;

public class FolderArtifact extends Artifact {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8835493644023653506L;
	
	private DirectoryScanner scanner = new DirectoryScanner();

	public FolderArtifact() {
		super();
	}

	public FolderArtifact(Activity activity, String baseDir,
			String fileName) {
		super(activity, baseDir, fileName);
		validate(_getFile());
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	public String[] getFileNamesForPattern(String... patterns){
		scanner.setIncludes(patterns);
		scanner.scan();
		return scanner.getIncludedFiles();
	}

	public String[] getFileNamesForPattern2(String[] patterns){
		return getFileNamesForPattern(patterns);
	}
	
	public String[] getDirNamesForPattern(String pattern){
		scanner.setIncludes(new String[]{pattern});
		scanner.scan();
		return scanner.getIncludedDirectories();
	}
	
	public FileArtifactList getFileArtifactListForPattern(String pattern){
		return getFileArtifactListForPattern(FileArtifact.class, pattern);
	}

	public FileArtifactList getFileArtifactListForPattern(String... patterns){
		return getFileArtifactListForPattern(FileArtifact.class, patterns);
	}
	
	public FileArtifactList getFileArtifactListForPattern(Class<? extends FileArtifact> c, String... patterns){
		String fileNames[] = getFileNamesForPattern(patterns);
		return new FileArtifactList(getActivity(), patterns.toString(), _getFile(), fileNames, c);
	}
	
	@Override
	public final void validate(File file) throws RuntimeDroolsException {
		if (file != null){
			if (!file.exists()){
				file.mkdir();
			} else if (file.isDirectory() == false){
				throw new RuntimeDroolsException("Artifact must be a directory!");
			}
		}

		scanner.setCaseSensitive(false);
		scanner.setBasedir(file);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [getAbsolutePath()=" + getAbsolutePath() + "]";
	}
}
