package io.concurrency.chapter03.exam01;


public class BasicSleepExample {

    public static void main(String[] args) {
        try {
            System.out.println("2초 후에 메시지가 출력됩니다");
            Thread.sleep(2000); // 다른 스레드가 언제든지 Interrupted 를 걸 수 있기 때문에 catch 를 해주어야 한다.
            System.out.println("Hello World");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
