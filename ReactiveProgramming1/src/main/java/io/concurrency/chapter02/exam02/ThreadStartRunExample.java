package io.concurrency.chapter02.exam02;


/**
 * 일반 스레드는 서브 스레드를 기다리지 않음. Thread 의 실행은 OS 의 스케쥴러에 의해 결정되기때문에, 항상 다름 --> 순서를 보장하지 않음.
 */
public class ThreadStartRunExample {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :스레드 실행중..");
            }
        });

        Thread thread2 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " :스레드 실행중.."));
        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName() + " :스레드 실행중.."));

        thread.start();
        thread2.start();
        thread3.start();
//        thread.run();
//        myRunnable.run();
        System.out.println("메인 메서드 종료");
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": 스레드 실행 중...");
        }
    }
}
