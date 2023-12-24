package io.concurrency.chapter02.exam03;

/**
 * 1. Thread 객체만 만들어진 상태.
 *
 * Kernel 모드로 들어가서 Kernel 스레드를 생성하고 User 스레드와 Kernel 스레드를 1:1 매핑하기 전단계라고 볼 수 있음.
 */
public class NewStateThreadExample {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("스레드 실행 중"));
        System.out.println("Thread Status : " + thread.getState());
    }
}
