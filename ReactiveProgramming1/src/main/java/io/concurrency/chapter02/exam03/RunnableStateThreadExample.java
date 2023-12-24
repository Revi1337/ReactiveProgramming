package io.concurrency.chapter02.exam03;

import java.util.stream.IntStream;

/**
 * 2. Thread 가 실행중인 상태
 *
 * Kernel 모드로 들어가서 Kernel 스레드를 생성하고 User 스레드와 Kernel 스레드를 1:1 매핑을 완료하였고,
 * run() 스레드가 동작중인 상태라고 볼 수 있음.
 */
public class RunnableStateThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                IntStream.range(0, 1000000000).forEach(integer -> {
                    if (integer % 1000000000 == 0) {
                        System.out.println("Thread Status : " + Thread.currentThread().getState());
                    }
                });
            }
        });

        thread.start();
    }
}
