package dslr;

import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.apache.commons.io.IOUtils;
import org.drools.compiler.DrlParser;

public class DrlParserTest extends TestCase {

    public void testExpandDRL() throws Exception {
    	String drl = IOUtils.toString(getClass().getResourceAsStream("/deploy_artifact.dslr"));
        DrlParser parser = new DrlParser();
        String result = parser.getExpandedDRL( drl , new InputStreamReader(getClass().getResourceAsStream("/dsl.dsl")));
        System.out.println(result);
    }
}