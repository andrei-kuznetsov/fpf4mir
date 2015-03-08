package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.ArtifactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.GenericRequest;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.GenericRequestSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;
import utils.PathUtils;

public class AliasBaseTest {
	private static final String FACT_TEST_NAME = "fact_test_name";
	private static final String ALIAS_TEST_NAME = "alias_test_name";

	@Test
	public void resetTest001() throws URISyntaxException{
		GenericFileArtifact f = new GenericFileArtifact(ActivityBase.USER, "", PathUtils.getTestResourceFile("/c1.zip").getAbsolutePath());
		f.setName(FACT_TEST_NAME);
		AliasBase a = new AliasBase<>();
		a.reset(f.getActivity(), f);
		Assert.assertEquals(FACT_TEST_NAME, ((GenericFileArtifact)a.getRefObject()).getName());
		
		GenericUpstreamAlias gua = new GenericUpstreamAlias();
		gua.reset(f.getActivity(), f);
		Assert.assertEquals(FACT_TEST_NAME, ((GenericFileArtifact)gua.getRefObject()).getName());
	}
	
	@Test
	public void resetTest002() throws URISyntaxException{
		GenericFileArtifact f = new GenericFileArtifact(ActivityBase.USER, "", PathUtils.getTestResourceFile("/c1.zip").getAbsolutePath());
		f.setName(FACT_TEST_NAME);

		GenericUpstreamAlias gua = new GenericUpstreamAlias();
		gua.reset(f.getActivity(), ALIAS_TEST_NAME, f);
		Assert.assertEquals(ALIAS_TEST_NAME, gua.getName());

		GenericUpstreamAlias rrf = new GenericUpstreamAlias();
		rrf.reset(new GenericRequest(), gua);
		Assert.assertEquals(ALIAS_TEST_NAME, rrf.getName());
		
		GenericUpstreamAlias rsrf = new GenericUpstreamAlias();
		rsrf.reset(new GenericRequestSucceeded(), ALIAS_TEST_NAME, rrf.getRefObject());
		Assert.assertEquals(ALIAS_TEST_NAME, rsrf.getName());
	}
	
	@Test
	public void cloneTest001() throws URISyntaxException{
		GenericFileArtifact f = new GenericFileArtifact(ActivityBase.USER, "", PathUtils.getTestResourceFile("/c1.zip").getAbsolutePath());
		f.setName(FACT_TEST_NAME);
		AliasBase a = new AliasBase<>();
		a.reset(f.getActivity(), f);
		ActivityRelatedFact cloned = a.cloneRefObject(null);
		Assert.assertEquals(FACT_TEST_NAME, ((GenericFileArtifact)cloned).getName());
		
		GenericUpstreamAlias gua = new GenericUpstreamAlias();
		gua.reset(f.getActivity(), f);
		cloned = gua.cloneRefObject(null);
		Assert.assertEquals(FACT_TEST_NAME, ((GenericFileArtifact)cloned).getName());
	}
	
	@Test
	public void testAliasIsFactWithName(){
		Assert.assertTrue(new AliasBase() instanceof FactWithName);
		Assert.assertTrue(new GenericUpstreamAlias() instanceof FactWithName);
	}
}
