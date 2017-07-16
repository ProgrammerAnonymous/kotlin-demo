package demo.kotlin;

/**
 * Created by gemhuang on 2017/7/16.
 */
public class SAMTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            System.out.println("Hi, I'm in a thread.");
        });

        t.run();
        t.join();
    }
}
