package io.concurrency.chapter02.exam01;

public class ExtendThreadExample {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
 }

// Thread 을 생성하는 방법 1 --> Thread 클래스를 상속하는 방법
class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " :스레드 실행 중.. ");
    }
}