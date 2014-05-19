package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.FileArtifactAliasBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class MvnRootPom extends FileArtifactAliasBase implements FileArtifactAlias {
	
	public MvnRootPom(RequestFact request, String name, FileArtifact file) {
		super(request, name, file);
	}

}
