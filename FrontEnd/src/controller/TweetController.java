package controller;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Tweet;
import service.TweetEJB;
import twitter4j.Status;
import twitter4j.TweetEntity;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@ManagedBean(name="tweetcontroller")
@SessionScoped
public class TweetController {

	private static final String API_KEY = "SV7jHOmm4ywRzuPfG3yboBMA8";
	private static final String API_SECRET = "qO51YTvAESlTv3lQpXYv3pzLrRpuisjuV8k8VOW0wym4KwUiOT";
	private static final String ACC_TOKEN = "631502247-P503eDVUFPTJykQjxfJJrFeXHauDY8R5XYljrarW";
	private static final String ACC_SECRET = "3DfJfb1LH7c43IFNxi39jSlIE56VYnRJ4r1DhglJXGsHt";
	private static final String TWITTER_HANDLE = "@AdhLecturer";
	
	@EJB
	private TweetEJB tweetEJB;
	
	@ManagedProperty(value = "#{tweet}")
	private Tweet tweet;

	public Tweet getTweet() {
		return tweet;
	}

	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	
	public String post(String tweetBody) throws TwitterException {
		
		ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();

    	configurationBuilder.setDebugEnabled(true).setOAuthConsumerKey(API_KEY).setOAuthConsumerSecret(API_SECRET).setOAuthAccessToken(ACC_TOKEN).setOAuthAccessTokenSecret(ACC_SECRET);
    	
    	TwitterFactory twitterFactory = new TwitterFactory(configurationBuilder.build());
    	Twitter twitter = twitterFactory.getInstance();
    	
    	if (!tweetBody.startsWith(TWITTER_HANDLE))
    		tweetBody = TWITTER_HANDLE + " " + tweetBody;
    	
    	Status status = twitter.updateStatus(tweetBody);
    	return status.getText();
	}
	
    private List<Tweet> tweets = new ArrayList<>();

	public List<Tweet> getTweets() {
       return tweets;
    }
 
    public String viewTwitter(){
        return "tweets.xhtml";
    }
   
    public String addNewTweet()  {
    	tweetEJB.addNew(tweet.getTweetEntity());
    	return "tweets.xhtml";
    }
    
    public String addNewPost() throws TwitterException  {
    	TweetEntity.postTweet(tweet.getTweetBody());
    	return "tweets.xhtml";   
    }
}
