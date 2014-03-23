package ru.spbstu.icc.kspt.kuznetsov.codestore;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import ru.spbstu.icc.kspt.kuznetsov.codestore.dao.SubmissionFacade;
import ru.spbstu.icc.kspt.kuznetsov.codestore.entities.Submission;

@Path("/submission")
public class SubmissionService {
	private static final Logger log = Logger.getLogger(SubmissionService.class);

	@EJB
	private SubmissionFacade submissions;

	@GET
	@Produces("application/json")
	@Path("list")
	public List<Submission> getAllSubmissions(){
		return submissions.getAllSubmissions();
	}
}
