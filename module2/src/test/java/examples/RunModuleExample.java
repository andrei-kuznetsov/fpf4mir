package examples;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.zip.ZipException;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.Classpath;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.Main;
import utils.PathUtils;

public class RunModuleExample {
	@Test
	public void testMain_InvalidOriginalArtifact() throws URISyntaxException, Exception {
		String[] definitions = Classpath.getClasspathFileNamesWithExtension(".drl");
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
		addKBEntries(kbuilder, ResourceType.DSL,dslFiles);
		addKBEntries(kbuilder, ResourceType.DSLR,lifecycle);
		addKBEntries(kbuilder, ResourceType.DRL,"rules/examples/run_module_problem.drl");

		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		
		StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
		ksession.fireAllRules();
	}

	private void addKBEntries(KnowledgeBuilder kbuilder, ResourceType rtype, String... string) {
		for (String resFileName : string)
			DeploymentSession.addClassPathEntry(kbuilder, resFileName, rtype);
	}
}
