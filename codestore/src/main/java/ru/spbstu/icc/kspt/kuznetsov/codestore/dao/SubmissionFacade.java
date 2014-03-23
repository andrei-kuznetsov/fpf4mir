package ru.spbstu.icc.kspt.kuznetsov.codestore.dao;

import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.codestore.entities.Submission;

public interface SubmissionFacade {
	public void addSubmission(String submissionId, String submissionName);
	public List<Submission> getAllSubmissions();
}
