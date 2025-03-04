public class Counter {
    private int count = 0;

    public synchronized int getCount() {
        return count;
    }

    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("Counter value: " + counter.getCount()); // Expected: 20000
    }
}