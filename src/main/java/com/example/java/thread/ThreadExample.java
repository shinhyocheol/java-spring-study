package com.example.java.thread;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {

        int numTasks = 60;
        LinkedBlockingQueue blockingQueue = new LinkedBlockingQueue<>();
        CountDownLatch countDownLatch = new CountDownLatch(numTasks);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10,     // corePoolSize: 기본적으로 관리할 쓰레드 숫자
                50,                 // maximumPoolSize: 쓰레드의 수가 corePoolSize를 초과할 경우 최대로 확장할 쓰레드 숫자
                10,                 // keepAliveTime: corePoolSize를 초과하여 생성된 쓰레드가 작업을 대기할 시간. 이 시간을 초과할 경우 corePoolSize를 초과한 수의 쓰레드를 정리한다.
                TimeUnit.SECONDS,   // unit: keepAliveTime의 단위
                blockingQueue       // workQueue: 모든 쓰레드가 작업중인 경우 대기중인 task를 보관할 큐
        );

        for (int i=0; i<numTasks; i++) {
            threadPoolExecutor.submit(() -> {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) { }
                countDownLatch.countDown();
            });
        }

        for (int i=0; i<120; i++) {
            Thread.sleep(500);
            // 현재 실행중인 Thread의 수 출력
            System.out.println("Active : " + threadPoolExecutor.getActiveCount());
            // Queue에서 대기 중인 작업 갯수 출력
            System.out.println("Queue : " + blockingQueue.size());
        }
        // 한 번에 동시에 실행되는 갯수는 ThreadPoolExecutor를 초기화 할 때 설정해주었던 corePoolSize인 10개이다.
        // 그 갯수를 넘어서면 maxPoolSize 만큼 동적으로 확장되어 실행되는 것이 아니라, Queue에서 대기를 하고 있다가 꺼내서 쓰레드에 할당한다.
        // maximumPoolSize 옵션이 발동되게 하기위해서는 큐의 크기를 제한해야한다.
        // maximumPoolSize 보다 workQueue의 순서가 먼저이므로 큐의 길이를 제한하여 큐의 길이를 초과할 시 maximumPoolSize가 활성화 된다.

        threadPoolExecutor.shutdown();
    }

}
