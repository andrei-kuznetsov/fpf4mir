package drl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildSystem;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildSystem.BUILD_SYSTEMS;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import utils.DrlObjectsUtils;
import utils.PathUtils;

public class DrlGuessBuildsystemTest {

	@Test
	public void guessAntRuleTest() throws URISyntaxException {
		guessBuildSystemRule("/guess_buildsystem/ant", BUILD_SYSTEMS.ANT);
	}

	@Test
	public void guessMavenRuleTest() throws URISyntaxException {
		guessBuildSystemRule("/guess_buildsystem/maven", BUILD_SYSTEMS.MAVEN);
	}

	@Test
	public void guessMakeRuleTest() throws URISyntaxException {
		guessBuildSystemRule("/guess_buildsystem/make", BUILD_SYSTEMS.MAKE);
	}

	@Test
	public void guessOtherRuleTest() throws URISyntaxException {
		guessBuildSystemRule("/guess_buildsystem/other", BUILD_SYSTEMS.OTHER);
	}
	
	@Test
	public void guessAntMakeMavenRuleTest() throws URISyntaxException {
		guessBuildSystemRule("/guess_buildsystem/ant_make_maven", BUILD_SYSTEMS.ANT, BUILD_SYSTEMS.MAKE, BUILD_SYSTEMS.MAVEN);
	}
	
	@Test
	public void guessAntMakeMavenNoRootRuleTest() throws URISyntaxException {
		// check when pom.xml, build.xml and so on are not in root directory
		guessBuildSystemRule("/guess_buildsystem", BUILD_SYSTEMS.ANT, BUILD_SYSTEMS.MAKE, BUILD_SYSTEMS.MAVEN);
	}
	
	private void guessBuildSystemRule(String filePath, BuildSystem.BUILD_SYSTEMS ... buildSystems) throws URISyntaxException {
		StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSession("guessbuildsystem.drl");
		
		File f = PathUtils.getTestResourceDir(filePath);
		FolderArtifact fc = new FolderArtifact(null, f);
        
        ksession.insert(fc);
        ksession.fireAllRules();
        
        Collection<Object> objects = ksession.getObjects();
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);

        assertTrue(omap.containsKey(FolderArtifact.class));
        assertTrue(omap.containsKey(BuildSystem.class));
        assertEquals(buildSystems.length, omap.get(BuildSystem.class).size());

        List<BuildSystem> bs = omap.get(BuildSystem.class);
        Set<BuildSystem.BUILD_SYSTEMS> bsset = new HashSet<BuildSystem.BUILD_SYSTEMS>();
        for (BuildSystem i : bs){
        	bsset.add(i.getBuildSystem());
        }
        
        System.out.print("Checking " + bsset.toString() + " vs. " + Arrays.toString(buildSystems));
        
        for (BUILD_SYSTEMS i : buildSystems){
        	assertTrue(i.toString(), bsset.contains(i));
        }
        
        System.out.println("   OK");
        
		ksession.dispose();
	}

}
