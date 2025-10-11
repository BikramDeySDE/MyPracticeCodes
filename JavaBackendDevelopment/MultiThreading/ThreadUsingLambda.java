/**
 * Create Thread using Lambda Expression as Runnable is a Functional Interface
 */
class ThreadUsingLambda{
    public static void main(String[] args) {
        Thread t1 =  new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("****Thread 1****" + i);
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("----Thread 2----" + i);
            }
        });

        t1.start();
        t2.start();
    }
}