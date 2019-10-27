package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entity.TweetEntity;

@Stateless
@LocalBean
public class TweetEJB {

	@PersistenceContext
	private EntityManager em;
	
	public TweetEJB() {
		
	}
	
	public void addNew(TweetEntity tweetEntity) {
		System.out.println("===Adding tweet to database...===");
		em.persist(tweetEntity);
		System.out.println("===================================")	
	}
	public List<TweetEntity> getTweet() {

    	List <TweetEntity> tweets = new ArrayList<>();
    	System.out.println("Tweet "+ tweets );
    	return em.createQuery("SELECT id,timeStamp,tweetBody FROM tweet_tbl").getResultList();    	
    }
}
