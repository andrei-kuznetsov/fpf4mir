package dslr;

import org.drools.KnowledgeBase;
import org.drools.RuntimeDroolsException;
import org.drools.definition.type.FactType;
import org.drools.factmodel.traits.Alias;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl.GenericAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl.GenericDownstreamAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;

public class DbgDeploymentSession extends DeploymentSession {
	
	public KnowledgeBase getKbase() {
		return super.getKbase();
	}
	
	public Object createNewFact(String pkg, String nm){
		FactType ftype = getKbase().getFactType(pkg, nm);
		if (ftype == null) throw new RuntimeDroolsException("No fact type found: " + pkg + "::" + nm);
			
		try {
			return ftype.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeDroolsException("Could not create new instance of type " + pkg + "::" + nm, e);
		}
	}

	public void attach(Request r, ActivityRelatedFact f) {
		GenericDownstreamAlias alias = new GenericDownstreamAlias();
		alias.reset(r, f);
		assertFact(alias);
	}
}
