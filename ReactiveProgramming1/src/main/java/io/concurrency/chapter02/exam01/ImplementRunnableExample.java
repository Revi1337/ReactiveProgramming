package io.concurrency.chapter02.exam01;


public class ImplementRunnableExample {

    public static void main(String[] args) {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task);
        thread.start();
    }
}

// Thread 을 생성하는 방법 2 --> Runnable 인터페이스를 구현하는 방법
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ": 스레드 실행 중");
    }
}
