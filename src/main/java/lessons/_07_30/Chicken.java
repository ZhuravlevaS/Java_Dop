package lessons._07_30;

import java.util.concurrent.ThreadLocalRandom;

public class Chicken extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000));
            System.out.println(this.getClass().getSimpleName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
