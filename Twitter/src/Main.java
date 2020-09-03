import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws TwitterException {
        long interval = 60;
        //^in minutes
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("KR7noHS5nrWDwcsKG9OLD4Siu")
                .setOAuthConsumerSecret("jH7r6EGYcfWxICyaknYug6lIcWuwxUd4xhinpSWUV4jn8AsZYe")
                .setOAuthAccessToken("1088586128188493824-Oc70X9qg8kAsmY8ceUoLEGtvufWGiW")
                .setOAuthAccessTokenSecret("CFOyKQQaNRG86LpOyH9Ix8XuosGaFpeblLjeGi7z6wfb1");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        TreeSet<Integer> visited = new TreeSet<>();
        ArrayList<String> tweets = new ArrayList<>();
        tweets.add("Hello, need help on an essay!");
        tweets.add("Id literally pay someone to write this essay for me");
        tweets.add("Paying for a graphic design logo HMU");
        tweets.add("Need a cool graphic design logo for my website willing to pay");
        tweets.add("Help, I need a physics tutor");
        tweets.add("Need a chemistry tutor, willing to pay");
        tweets.add("Need homework help");
        tweets.add("Need an essay writer please comment");
        tweets.add("Need help designing this logo, Logo design/graphic design expertise needed");
        Collections.shuffle(tweets);
        interval = interval*60000;
        long oldtime = System.currentTimeMillis()-interval;
        long newtime = System.currentTimeMillis();
        while(true){
            if(visited.size()==tweets.size())visited.clear();
            if(newtime - oldtime >= interval){
                int numberrandom = (int) (Math.random()*(tweets.size()-1));
                while(visited.contains(numberrandom))numberrandom = (int) (Math.random()*(tweets.size()-1));
                twitter.updateStatus(tweets.get(numberrandom));
                visited.add(numberrandom);
                oldtime = System.currentTimeMillis();
            }
            newtime = System.currentTimeMillis();
        }
    }
}
