package dslr;

import java.io.IOException;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.drools.compiler.DrlParser;
import org.drools.compiler.DroolsParserException;
import org.junit.Test;

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
    	String dslr = "/rules/tasks/extract/extract_unzip.dslr";
		printExpandedRule(dslr);
    }
    
    public void testExpandDRL_default_request_status() throws Exception {
    	String dslr = "/rules/lifecycle/default_request_status.dslr";
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
    
    public void testExpandDRL_guess_mvn_command() throws Exception {
    	String dslr = "/rules/maven/guess_mvn_command.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_fix_maven_goldin_copy_plugin() throws Exception {
    	String dslr = "/rules/maven/errors/fix_maven_goldin_copy_plugin.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_download_inet() throws Exception {
    	String dslr = "/rules/tasks/download/download_inet.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_guess_run_command() throws Exception {
    	String dslr = "/guess_run_command.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_guess_run_command_rest() throws Exception {
    	String dslr = "/guess_run_command_rest.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_rest_deploy() throws Exception {
    	String dslr = "/rules//rest/rest_deploy.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_rest_deploy_latex() throws Exception {
    	String dslr = "/rules//rest/rest_deploy_latex.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_rest_exec() throws Exception {
    	String dslr = "/rules//rest/rest_exec.dslr";
		printExpandedRule(dslr);
    }
    
    @Test
    public void testExpandDRL_r_phase_prepare_rstatus() throws Exception {
    	String dslr = "/rules/lifecycle/request/r_phase_prepare_rstatus.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_run_java() throws Exception {
    	String dslr = "/rules/tasks/run/java/run_java.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_fixmavenbuild_unmappablecharacter() throws Exception {
    	String dslr = "/rules/maven/errors/fix_maven_unmappable_character.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_mvn_couldnot_create_local_repository() throws Exception {
    	String dslr = "/rules/maven/errors/fix_maven_couldnot_create_local_repository.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_request_livecycle_support() throws Exception {
    	String dslr = "/rules/lifecycle/request/request_livecycle_support.dslr";
		printExpandedRule(dslr);
    }

    public void testExpandDRL_ut_mirex_audio_ch_est() throws Exception {
    	String dslr = "/rules/unittests/ut_mirex_audio_ch_est.dslr";
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