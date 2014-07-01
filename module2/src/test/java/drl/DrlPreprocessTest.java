package drl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;
import utils.DrlObjectsUtils;

public class DrlPreprocessTest {

	private static final String DRL_FILENAME = "preprocess.drl";

	@Test
	public void downloadArtifactRuleTest() throws URISyntaxException {
        StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSession(DRL_FILENAME);
        
//        URI url = ZipUnzipTest.class.getClassLoader().getResource("c1.zip").toURI();
//        ArtifactRef oa = new ArtifactRef(null, url);
        
//        ksession.insert(oa);
        ksession.fireAllRules();
        
        Collection<Object> objects = ksession.getObjects();
        assertEquals(2, objects.size());
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);

        assertTrue(omap.containsKey(DownloadAction.class));
        assertTrue(omap.containsKey(ArtifactRef.class));

        DownloadAction ea = (DownloadAction) omap.get(DownloadAction.class).get(0);
//        assertEquals(R.id.OriginalArtifact, ea.getId());
//        assertEquals(url, ea.getUri());
        
        ksession.dispose();
	}
	
	/*
	@Test
	@Ignore
	public void extractArtifactRuleTest() throws URISyntaxException {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kbuilder.add(ResourceFactory.newClassPathResource(DRL_FILENAME), ResourceType.DRL);
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        
        URL url = ZipUnzipTest.class.getClassLoader().getResource("c1.zip");
		File f = new File(url.toURI());
		assertTrue(f.isFile());
        Artifact oa = new FileArtifact(null, f.getAbsolutePath(), "");
        
        ksession.insert(oa);
        ksession.fireAllRules();
        
        Collection<Object> objects = ksession.getObjects();
        assertEquals(2, objects.size());
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);

        assertTrue(omap.containsKey(ExtractAction.class));
        assertTrue(omap.containsKey(FileArtifact.class));

        ExtractAction ea = (ExtractAction) omap.get(ExtractAction.class).get(0);
        assertEquals(f, ea.getFile());
	}
	*/
}
