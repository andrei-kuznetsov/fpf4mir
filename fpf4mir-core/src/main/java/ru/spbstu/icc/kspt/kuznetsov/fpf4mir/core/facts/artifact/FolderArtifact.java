package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact;



public interface FolderArtifact extends Artifact {

	@Override public boolean isDirectory();
	
	public String[] getFileNamesForPattern(String... patterns);

	public String[] getFileNamesForPattern2(String[] patterns);
	
	public String[] getDirNamesForPattern(String pattern);

	public FileArtifactList getFileArtifactListForPattern(String... patterns);

	public FileArtifactList getFileArtifactListForPattern2(String[] patterns);
	
	public FileArtifactList getFileArtifactListForPattern(Class<? extends FileArtifact> c, String... patterns);
}
