package dslr;

import java.io.IOException;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.drools.compiler.DrlParser;
import org.drools.compiler.DroolsParserException;

public class DrlParserTest extends TestCase {

    public void testExpandDRL_deploy_artifact() throws Exception {
    	String dslr = "/deploy_artifact.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_deploy_executable_artifact() throws Exception {
    	String dslr = "/deploy_executable.dslr";
		printExpandedRule(dslr);
    }
    
    public void testExpandDRL_extract_unzip() throws Exception {
    	String dslr = "/extract_unzip.dslr";
		printExpandedRule(dslr);
    }
    
    public void testExpandDRL_guess_run_executable() throws Exception {
    	String dslr = "/guess_run_executable.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_build() throws Exception {
    	String dslr = "/build.dslr";
		printExpandedRule(dslr);
    }
    
    public void testExpandDRL_subrequests_support() throws Exception {
    	String dslr = "/subrequests_support.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_guessmvncommand() throws Exception {
    	String dslr = "/guessmvncommand.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_fix_maven_goldin_copy_plugin() throws Exception {
    	String dslr = "/fix_maven_goldin_copy_plugin.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_guess_run_command() throws Exception {
    	String dslr = "/guess_run_command.dslr";
		printExpandedRule(dslr);
    }
    
	private void printExpandedRule(String dslr) throws IOException,
			DroolsParserException {
		String drl = IOUtils.toString(getClass().getResourceAsStream(dslr));
        DrlParser parser = new DrlParser();
        String result = parser.getExpandedDRL( drl , new InputStreamReader(getClass().getResourceAsStream("/dsl.dsl")));
        System.out.println(result);
	}
}