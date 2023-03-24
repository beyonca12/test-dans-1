package dans.multi.pro.brian.question_2_3_4.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import dans.multi.pro.brian.question_2_3_4.dao.GetJobsOutput;
import dans.multi.pro.brian.question_2_3_4.dao.Jobs;
import dans.multi.pro.brian.question_2_3_4.service.JobsService;

@Service
public class JobsServiceImpl implements JobsService {
	@Override
	public GetJobsOutput getJobs() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Jobs>> jobsResp = restTemplate.exchange(
				"http://dev3.dansmultipro.co.id/api/recruitment/positions.json", HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Jobs>>() {
				});
		List<Jobs> jobsList = jobsResp.getBody();
		GetJobsOutput getJobsOutput = new GetJobsOutput();
		getJobsOutput.setJobsList(jobsList);
		return getJobsOutput;
	}

	@Override
	public Jobs getJobsById(String id) {
		String url = "http://dev3.dansmultipro.co.id/api/recruitment/positions/{ID}";

		Map<String, String> urlParams = new HashMap<>();
		urlParams.put("ID", id);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<?> entity = new HttpEntity<>(headers);
		HttpEntity<Jobs> response = restTemplate.exchange(builder.buildAndExpand(urlParams).toUri(), HttpMethod.GET,
				entity, Jobs.class);
		return response.getBody();
	}

	public void getJobsAsCSV() throws IOException {
		GetJobsOutput getJobsOutput = getJobs();

		CSVPrinter printer = new CSVPrinter(new FileWriter("jobs.csv"), CSVFormat.DEFAULT);
		printer.printRecord("ID", "Type", "URL", "CreatedAt", "Company URL", "Location", "Title", "Description");
		for (Jobs jobs : getJobsOutput.getJobsList()) {
			printer.printRecord(jobs.getId(), jobs.getType(), jobs.getUrl(), jobs.getCreatedAt(), jobs.getCompanyUrl(),
					jobs.getLocation(), jobs.getTitle(), jobs.getDescription());
		}

		printer.flush();
		printer.close();
	}
}
