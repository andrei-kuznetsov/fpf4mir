package dslr;

import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.RuntimeDroolsException;
import org.drools.definition.type.FactType;
import org.junit.Assert;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl.GenericDownstreamAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;

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
	
	public Request createNewRequest(String pkg, String nm){
		return createNewRequest(pkg, nm, ActivityBase.USER);
	}
	
	public ActivityRelatedFact createNewARF(String pkg, String nm){
		ActivityRelatedFact f = (ActivityRelatedFact) createNewFact(pkg, nm);
		f.setActivity(ActivityBase.USER);
		return f;
	}
	
	public Request createNewRequest(String pkg, String nm, Activity parent){
		final Request r = (Request) createNewFact(pkg, nm);
		r.setActivity(parent);
		return r;
	}
	
	public void attachDn(Request r, ActivityRelatedFact f) {
		GenericDownstreamAlias alias = new GenericDownstreamAlias();
		alias.reset(r, f);
		assertFact(alias);
	}

	public RequestStatus getRequestMainStatus(Request r) {
		List<QResult> rstatus = getRequestStatus(r.getRefId()); //FIXME: getRequestStatus(r) doesn't work?!
		Assert.assertEquals(1, rstatus.size());
		
		return rstatus.get(0).mainStatus;
	}
	
	@Override
	protected void initActions() {
		// don't add any actions
	}
}
