package org.moldavets.multithreading;

public class example3 {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        myThread1.setName("myExampleThread1");
        myThread1.setPriority(9);
        System.out.println("MyThread1 name : " + myThread1.getName() +
                "\nMyThread1 priority: " + myThread1.getPriority());
    }
}

class MyThread extends Thread {
    public void run() {
        System.out.println("Hello");
    }
}
