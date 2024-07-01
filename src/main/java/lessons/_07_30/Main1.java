package lessons._07_30;

import java.util.Arrays;

public class Main1 {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            Thread thread = new Thread(()-> {
                Arrays.stream(new Object[10]).forEach((el)->{
                    System.out.println(finalI);
                });
            });
            System.out.println("Приоритет " + i + " " + thread.getPriority());
            thread.setPriority(i);
            thread.start();
//            Thread.sleep(100);
        }
    }
}
