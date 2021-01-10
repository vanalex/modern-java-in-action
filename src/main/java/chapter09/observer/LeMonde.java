package chapter09.observer;

public class LeMonde implements Observer{

    @Override
    public void inform(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}
