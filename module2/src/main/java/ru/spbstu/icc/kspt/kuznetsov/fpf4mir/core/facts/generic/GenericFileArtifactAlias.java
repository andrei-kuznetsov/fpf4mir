package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class GenericFileArtifactAlias extends FileArtifactAliasBase implements FileArtifactAlias {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1751154782136734217L;

	public GenericFileArtifactAlias(RequestFact request, String name,
			FileArtifact file) {
		super(request, name, file);
	}

	public GenericFileArtifactAlias(RequestFact request, FileArtifact file) {
		super(request, file.getName(), file);
	}
}
