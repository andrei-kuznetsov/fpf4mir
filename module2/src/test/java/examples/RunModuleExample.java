package examples;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.zip.ZipException;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.Classpath;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.GenericActivitySucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.GenericRequestFailed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.GenericRequestSucceeded;

import static org.junit.Assert.*;

public class RunModuleExample {
	@Test
	public void testRun_module_problem() throws URISyntaxException, Exception {
		runSingleFileWithDeps("rules/examples/run_module_problem.drl");
	}

	@Test
	public void testRun_module_problem_paper() throws URISyntaxException, Exception {
		StatefulKnowledgeSession ksession = runSingleFileWithDeps("rules/examples/run_module_problem_paper.drl");
		int  aSuccess = 0;
		int  rSuccess = 0;
		int  rFailed = 0;
		Collection<Object> objs = ksession.getObjects();
		for (Object i : objs){
			if (i instanceof GenericActivitySucceeded){
				aSuccess++;
			} else if (i instanceof GenericRequestSucceeded){
				rSuccess++;
			} else if (i instanceof GenericRequestFailed){
				rFailed++;
			}
		}
		
		assertEquals(3, aSuccess);
		assertEquals(3, rSuccess);
		assertEquals(0, rFailed);
	}

	private StatefulKnowledgeSession runSingleFileWithDeps(String fname) throws ZipException, IOException {
		String[] definitions = Classpath.getClasspathFileNamesWithExtension("definitions.drl");
		String[] functions = Classpath.getClasspathFileNamesWithExtension("functions.drl");
		String[] lifecycle = Classpath.getClasspathFileNames(new Classpath.FileFilter() {
			@Override
			public boolean accept(String filename) {
				return filename.replace('\\', '/').contains("rules/lifecycle");
			}
		});

		String[] dslFiles = Classpath
				.getClasspathFileNamesWithExtension(".dsl");
		
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		
		Arrays.sort(definitions);
		Arrays.sort(lifecycle);
		Arrays.sort(dslFiles);
		
		addKBEntries(kbuilder, ResourceType.DRL, definitions);
		addKBEntries(kbuilder, ResourceType.DRL, functions);
		addKBEntries(kbuilder, ResourceType.DSL,dslFiles);
		addKBEntries(kbuilder, ResourceType.DSLR,lifecycle);
		addKBEntries(kbuilder, ResourceType.DRL,fname);

		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.fireAllRules();
		return ksession;
	}

	private void addKBEntries(KnowledgeBuilder kbuilder, ResourceType rtype, String... string) {
		for (String resFileName : string)
			DeploymentSession.addClassPathEntry(kbuilder, resFileName, rtype);
	}
}
