package io.concurrency.chapter01.exam01;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelismExample {

    /**
     * CPU 코어개수와 작업의 개수가 같으면, CPU 하나당 Thread 가 하나씩 붙어 완벽한 병렬처리를 이룬다.
     * 병렬성은 동시성의 하위 개념으로 작업을 여러 Thread 로 분리하고 OS 는 그 Thread 여러 CPU 에 적절히 분배하여 동시적으로 실행되도록 하는 것이다.
     *
     * @param args
     */
    public static void main(String[] args) {
        int cpuCores = Runtime.getRuntime().availableProcessors();              // CPU 코어 개수 확인 (4 개)
        List<Integer> data = IntStream.range(0, cpuCores).boxed().toList();     // CPU 코어 개수만큼 데이터를 생성 (4 개)

        long startTime1 = System.currentTimeMillis();

        long sum1 = data.parallelStream()                                       // CPU 개수만큼 데이터를 병렬로 처리 (코어와 작업의 개수가 같기때문에 완벽한 병렬성, 즉 모든 작업이 1 초가 걸림)
                .mapToLong(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i * i;
                })
                .sum();

//        long sum1 = data.stream()                                             // 순차적으로 처리하기때문에 작업의 개수만큼. 즉, 4 초가 걸림
//                .mapToLong(i -> {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                    return i * i;
//                })
//                .sum();

        long endTime1 = System.currentTimeMillis();

        System.out.println("CPU 개수만큼 데이터를 병렬로 처리하는 데 걸린 시간: " + (endTime1 - startTime1) + "ms");
        System.out.println("결과1: " + sum1);
    }
}
