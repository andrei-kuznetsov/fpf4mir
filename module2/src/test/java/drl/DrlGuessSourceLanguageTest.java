package drl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.SourceLanguage;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.SourceLanguage.SOURCE_LANGUAGES;
import utils.DrlObjectsUtils;
import utils.PathUtils;

public class DrlGuessSourceLanguageTest {

	private static final String GUESSSOURCELANGUAGE_DRL = "guesssourcelanguage.drl";

	@Test
	public void guessJavaRuleTest() throws URISyntaxException {
		guessSourceLanguageRule(SOURCE_LANGUAGES.JAVA, "/guess_language/java");
	}

	@Test
	public void guessPythonRuleTest() throws URISyntaxException {
		guessSourceLanguageRule(SOURCE_LANGUAGES.PYTHON, "/guess_language/python");
	}

	@Test
	public void guessCCPPRuleTest() throws URISyntaxException {
		guessSourceLanguageRule(SOURCE_LANGUAGES.C_CPP, "/guess_language/cpp");
	}

	@Test
	public void guessOtherRuleTest() throws URISyntaxException {
		guessSourceLanguageRule(SOURCE_LANGUAGES.OTHER, "/guess_language/other");
	}
	
	@Test
	public void guessCppJavaPyRuleTest() throws URISyntaxException {
		StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSession(GUESSSOURCELANGUAGE_DRL);
		
		File f = PathUtils.getTestResourceDir("/guess_language/cpp_java_py");
		FolderArtifact fc = new FolderArtifact(R.id.OriginalArtifact, f);
        
        ksession.insert(fc);
        ksession.fireAllRules();
        
        Collection<Object> objects = ksession.getObjects();
        
        assertEquals(4, objects.size());
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);

        assertTrue(omap.containsKey(FolderArtifact.class));
        assertTrue(omap.containsKey(SourceLanguage.class));

        List<SourceLanguage> bs = omap.get(SourceLanguage.class);
        Set<SourceLanguage.SOURCE_LANGUAGES> bsset = new HashSet<SourceLanguage.SOURCE_LANGUAGES>();
        for (SourceLanguage i : bs){
        	bsset.add(i.getSourceLanguage());
        }
        
        assertTrue(bsset.contains(SourceLanguage.SOURCE_LANGUAGES.C_CPP));
        assertTrue(bsset.contains(SourceLanguage.SOURCE_LANGUAGES.JAVA));
        assertTrue(bsset.contains(SourceLanguage.SOURCE_LANGUAGES.PYTHON));
        
		ksession.dispose();
	}
	
	private void guessSourceLanguageRule(SourceLanguage.SOURCE_LANGUAGES buildSystem, String filePath) throws URISyntaxException {
        StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSession(GUESSSOURCELANGUAGE_DRL);
        
        File f = PathUtils.getTestResourceDir(filePath);
        
        FolderArtifact fc = new FolderArtifact(R.id.OriginalArtifact, f);
        
        ksession.insert(fc);
        ksession.fireAllRules();
        
        Collection<Object> objects = ksession.getObjects();
        
        assertEquals(2, objects.size());
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);

        assertTrue(omap.containsKey(FolderArtifact.class));
        assertTrue(omap.containsKey(SourceLanguage.class));

        SourceLanguage bs = (SourceLanguage) omap.get(SourceLanguage.class).get(0);
        assertEquals(buildSystem, bs.getSourceLanguage());
        ksession.dispose();
	}

}
