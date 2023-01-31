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

}
