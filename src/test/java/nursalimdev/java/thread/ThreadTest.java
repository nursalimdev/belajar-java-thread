package nursalimdev.java.thread;

import org.junit.jupiter.api.Test;

public class ThreadTest {
    @Test
    void mainThread() {
        String name = Thread.currentThread().getName();
        System.out.println(name);
    }

    @Test
    void createThread(){
        Runnable runnable = () -> System.out.println("Hello from thread : " + Thread.currentThread().getName());
//        runnable.run(); // running di main thread

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Program selesai");
    }

    @Test
    void threadSleep(){
        Runnable runnable = () -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from thread : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.start();

        System.out.println("Program selesai");

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello from thread : " + Thread.currentThread().getName());
        };

        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Menunggu selesai");
        thread.join();

        System.out.println("Program selesai");
    }

    @Test
    void threadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    return;
                }

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000L);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();

        System.out.println("Program selesai");
    }

    @Test
    void threadInterruptCorrect() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable : " + i);
                if(Thread.interrupted()) {
                    return;
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000L);
        thread.interrupt();
        System.out.println("Menunggu selesai");
        thread.join();

        System.out.println("Program selesai");
    }

    @Test
    void threadName() throws InterruptedException {
        Thread thread = new Thread(()-> System.out.println("Run in thread : " + Thread.currentThread().getName()) );
        thread.setName("Nursalim");
        thread.start();
        System.out.println("selesai");
    }

    @Test
    void threadState() throws InterruptedException {
        Thread thread = new Thread(()-> {
            System.out.println("State 0 : " + Thread.currentThread().getState());
            System.out.println("Run in thread : " + Thread.currentThread().getName());
        } );
        thread.setName("Nursalim");
        System.out.println("State 1  : " + thread.getState());
        thread.start();
        thread.join();
        System.out.println("State 2 : " + thread.getState());
    }

}
