package dans.multi.pro.brian.question_2_3_4.service;

import java.io.IOException;

import dans.multi.pro.brian.question_2_3_4.dao.GetJobsOutput;
import dans.multi.pro.brian.question_2_3_4.dao.Jobs;

public interface JobsService {
	public GetJobsOutput getJobs();
	public Jobs getJobsById(String id);
	public void getJobsAsCSV() throws IOException;
}
