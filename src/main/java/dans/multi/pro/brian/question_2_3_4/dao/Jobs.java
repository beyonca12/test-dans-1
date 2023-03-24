package dans.multi.pro.brian.question_2_3_4.dao;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Jobs {
	private String id;
	private String type;
	private String url;
	private Date createdAt;
	private String companyUrl;
	private String location;
	private String title;
	private String description;
}
