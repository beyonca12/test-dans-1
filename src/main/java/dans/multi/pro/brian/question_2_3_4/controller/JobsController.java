package dans.multi.pro.brian.question_2_3_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dans.multi.pro.brian.question_2_3_4.dao.GetJobsOutput;
import dans.multi.pro.brian.question_2_3_4.dao.Jobs;
import dans.multi.pro.brian.question_2_3_4.service.JobsService;

@RestController
public class JobsController {
	
	@Autowired
	JobsService jobsService;
	
	@GetMapping("/get-jobs")
	public @ResponseBody GetJobsOutput getJobs() {
		GetJobsOutput output = jobsService.getJobs();
		
		return output;
	}
	
	@GetMapping("/get-jobs-by-id")
	public @ResponseBody Jobs getJobs(@RequestParam("ID") String id) {
		Jobs output = jobsService.getJobsById(id);
		
		return output;
	}
	@GetMapping("/get-jobs-as-csv")
	public @ResponseBody String getJobsAsCsv() {
		try {
			jobsService.getJobsAsCSV();
		} catch (Exception e) {
			return "failed";
		}
		
		return "success";
	}
}
