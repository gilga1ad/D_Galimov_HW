package inno.twitter;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class TweetService {

    private static int ids = 0;

    private List<Tweet> tweets = new ArrayList<Tweet>();

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public boolean add(String message) {
        Tweet tweet = new Tweet();
        tweet.setMessage(message);
        tweet.setCreatedAt(new Date());
        tweet.setId(++ids);
        return tweets.add(tweet);
    }

    public boolean remove(Long id) {
        --ids;
        return tweets.remove(getById(id));
    }

    public Tweet getById(long id) {
        for (Tweet tweet : tweets) {
            if (tweet.getId() == id) {
                return tweet;
            }
        }
        return null;
    }

}
