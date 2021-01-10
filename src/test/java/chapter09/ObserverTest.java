package chapter09;

import chapter09.observer.Feed;
import chapter09.observer.Guardian;
import chapter09.observer.LeMonde;
import chapter09.observer.NyTimes;
import org.junit.jupiter.api.Test;

public class ObserverTest {

    @Test
    public void test(){
        Feed f = new Feed();
        f.registerObserver(new NyTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());
        f.notifyObservers("The queen said her favourite book is Java 8 & 9 in Action!");

        Feed feedLambda = new Feed();

        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        feedLambda.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });

        feedLambda.notifyObservers("Money money money, give me money!");
    }
}
