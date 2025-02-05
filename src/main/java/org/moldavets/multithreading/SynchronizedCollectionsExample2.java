package org.moldavets.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchronizedCollectionsExample2 {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        List<Integer> synchronizedList = Collections.synchronizedList(list);

        Runnable runnable1 = () -> {
            synchronized (synchronizedList) {
                Iterator<Integer> iterator = synchronizedList.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronizedList.remove(10);
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchronizedList);

    }

}
