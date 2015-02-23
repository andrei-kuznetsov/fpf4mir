package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.UpstreamAliasRSK;

/*
 *  We found it's very difficult to define a fact at runtime in such a way that it's being RequestScopedKnowledge 
 *  and ActivityRelatedFactBase-derived class at the same time. For instance, for rule "Relocate mvn repository"
 *  we want a fact MavenRepoLocation to be RequestScopedKnowledge fact derived from FolderArtifactBase.
 *  
 *  So we changed generic type from "RequestScopedKnowledge" to "ActivityRelatedFact"
 */
public class GenericUpstreamAliasRSK extends AliasBase<ActivityRelatedFact> implements UpstreamAliasRSK<ActivityRelatedFact>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3613463350791865786L;


}
