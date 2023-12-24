package io.concurrency.chapter01.exam01;

import java.util.List;
import java.util.stream.IntStream;

public class ConcurrencyExample {

    /**
     * CPU 코어의 개수보다 작업이 한개가됬든 두개가 됬든 더 많으면 그땐, 병럴처리의 이점을 가져갈 수는 있지만, 결과적으로 동시성이 되버린다.
     * --> 그 이유는 하나의 CPU 가 동시에 2 개의 Thread 를 할당할 수 없기 때문임.
     *
     * 병렬성은 성능의 극대화를 위해 CPU 를 최대한 활용하는것이고,
     * 동시성은 CPU 가 최대한 많은 작업을 처리하기위해 많은 Thread 들을 사용하는것이다.
     *
     * @param args
     */
    public static void main(String[] args) {

        int cpuCores = Runtime.getRuntime().availableProcessors();                  // CPU 코어 개수 확인 (4 개)
        List<Integer> data = IntStream.range(0, cpuCores * 2).boxed().toList();     // CPU 개수만큼 * 2 만큼 데이터를 생성 (8 개) --> 2 초 걸림
//        List<Integer> data = IntStream.range(0, 5).boxed().toList();                // 5 개의 데이터를 생성 --> 2 초 걸림

        long startTime2 = System.currentTimeMillis();                               // CPU 개수를 초과하는 데이터를 병렬로 처리

        long sum2 = data.parallelStream()
                .mapToLong(i -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return i * i;
                })
                .sum();

        long endTime2 = System.currentTimeMillis();

        System.out.println("CPU 개수를 초과하는 데이터를 병렬로 처리하는 데 걸린 시간: " + (endTime2 - startTime2) + "ms");
        System.out.println("결과2: " + sum2);
    }
}
