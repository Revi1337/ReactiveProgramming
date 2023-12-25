package io.concurrency.chapter03.exam01;

import java.util.stream.IntStream;

public class LoopSleepExample {

    public static void main(String[] args) {
        IntStream.rangeClosed(0, 7).forEach(integer -> {
            try {
                System.out.println("반복 : " + (integer + 1));
                Thread.sleep(1000);     // 다른 스레드가 언제든지 Interrupted 를 걸 수 있기 때문에 catch 를 해주어야 한다.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
