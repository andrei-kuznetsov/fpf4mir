package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public class ArtifactBaseTest {
	@Test
	public void testArtifacIsFactWithName(){
		Assert.assertTrue(new ArtifactBase() instanceof FactWithName);
		Assert.assertTrue(new GenericFileArtifact() instanceof FactWithName);
	}
}
