
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class Twitter {
	public static twitter4j.Twitter twitter;
	public static TwitterFactory tf;
	public static String accessToken = "782015924685697025-mbMyz4hkNKltIMVpo2uSt58AMQ1SyzL";
	public static String accessTokenSecret = "zl5L6cqLdn3tSmuO6CKRT1W7W6pR6KmPUGF9geU9lPb4r";
	public static String consumerkey = "A4j8W467hMU0TL9tNRMjWjxCg";
	public static String consumersecret = "fzoVTiVNH2KRlDRoEk7tkmgNcsooJRIZOEYRqrFpj2qFo4Iu7Z";

	public static ConfigurationBuilder getNewConfigurationBuilder() {
		return new ConfigurationBuilder();
	}

	public static void getCredentials() {
		ConfigurationBuilder cb = getNewConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerkey).setOAuthConsumerSecret(consumersecret)
				.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
		tf = new TwitterFactory(cb.build());
	}

	public static void getTweets() {
		try {
			twitter = tf.getInstance();
			List<Status> tweets = twitter.getHomeTimeline();
			PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			int i = 0;
			for (Status tweet : tweets) {
				i++;
				writer.println(tweet.getText());
				if (i == 10)
					break;
			}
			writer.close();
		} catch (TwitterException | FileNotFoundException | UnsupportedEncodingException te) {
			te.printStackTrace();
		}
	}

	public static void main(String args[]) {
		getCredentials();
		getTweets();
	}

}