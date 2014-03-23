package ru.spbstu.icc.kspt.kuznetsov.codestore.dao;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ru.spbstu.icc.kspt.kuznetsov.codestore.entities.Submission;

@Stateless
@Local(value=SubmissionFacade.class)
@LocalBean
public class SubmissionFacadeImpl implements SubmissionFacade {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addSubmission(String submissionId, String submissionName) {
		Submission e = new Submission();
		
		e.setLocalPath(submissionId);
		e.setSubmissionName(submissionName);
		
		em.persist(e);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Submission> getAllSubmissions() {
		Query query = em.createQuery("SELECT e FROM Submission e");
	    return (List<Submission>) query.getResultList();
	}

}
