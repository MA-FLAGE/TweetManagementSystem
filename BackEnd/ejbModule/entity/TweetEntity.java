package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tweet_tbl")
public class TweetEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String tweetBody;
	private String timeStamp = new SimpleDateFormat("yyyy-MM-DD'T'ddHH:mm:ss").format(new Date());
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
