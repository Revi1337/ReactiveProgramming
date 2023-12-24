package io.concurrency.chapter01.exam02;

import java.util.stream.IntStream;

/**
 * Thread 의 순서가 랜덤임. 스케줄러에 의해 Cpu 가 할당될 Thread 가 정해지며
 * Thread 가 대기할때마다, 스케불러에 의해 다른 Thread 로 변경되는데, 이때 ContextSwitching 이 일어나게 된다.
 */
public class ContextSwitchExample {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            IntStream.range(0, 5).forEach(integer -> {
                System.out.println("Thread 1: " + integer);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        Thread thread2 = new Thread(() -> {
            IntStream.range(0, 5).forEach(integer -> {
                System.out.println("Thread 2: " + integer);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
    });

        Thread thread3 = new Thread(() -> {
            IntStream.range(0, 5).forEach(integer -> {
                System.out.println("Thread 3: " + integer);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
