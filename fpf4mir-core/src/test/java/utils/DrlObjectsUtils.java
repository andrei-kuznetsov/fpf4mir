package utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

public class DrlObjectsUtils {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Map<Class, List> convertToMap(Collection objects){
		Map<Class, List> map = new HashMap<Class, List>();
		for (Object i : objects){
			Class<? extends Object> c = i.getClass();
			
			List l = map.get(c);
			if (l == null){
				l = new ArrayList();
				map.put(c, l);
			}
			
			l.add(i);
		}
		return map;
	}
	
	public static StatefulKnowledgeSession prepareStatefullSession(String ... filenames){
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		for (String i : filenames){
			kbuilder.add(ResourceFactory.newClassPathResource(i), ResourceType.DRL);
			checkSessionForErrors(kbuilder);
		}
		
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        
        return ksession;
	}

	public static StatefulKnowledgeSession prepareStatefullSessionDslr(
			String ... dslrFilenames) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();

		kbuilder.add(ResourceFactory.newClassPathResource("dsl.dsl"), ResourceType.DSL);
		checkSessionForErrors(kbuilder);
		kbuilder.add(ResourceFactory.newClassPathResource("a_definitions.drl"), ResourceType.DRL);
		checkSessionForErrors(kbuilder);
		kbuilder.add(ResourceFactory.newClassPathResource("a_functions.drl"), ResourceType.DRL);
		checkSessionForErrors(kbuilder);
		
		for (String i : dslrFilenames){
			kbuilder.add(ResourceFactory.newClassPathResource(i), ResourceType.DSLR);
			checkSessionForErrors(kbuilder);
		}
		
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
        StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
        
        return ksession;
	}

	private static void checkSessionForErrors(KnowledgeBuilder kbuilder) {
		if (kbuilder.hasErrors()){
			for (KnowledgeBuilderError err : kbuilder.getErrors()){
				System.out.println(err);
			}
			throw new RuntimeException("Can't compile KB");
		}
	}

	public static Object createObject(StatefulKnowledgeSession ksession,
			String pkg, String name) throws InstantiationException, IllegalAccessException {
		FactType ftype = ksession.getKnowledgeBase().getFactType(pkg, name);
		return ftype.newInstance();
	}

	public static void setField(StatefulKnowledgeSession ksession, Object bean, String field, Object value) {
		String pkg = bean.getClass().getPackage().getName();
		String name = bean.getClass().getSimpleName();
		FactType ftype = ksession.getKnowledgeBase().getFactType(pkg, name);
		ftype.set(bean, field, value);
	}
}
