class MultiThreadingBluePrint{
    public static void main(String[] args) {

        System.out.println("----Main Thread Started----");

        // Instanciate classes which implements the Runnable Interface
        A a = new A();
        B b = new B();

        // Create Thread and Pass the Runnable instance to Thread
        Thread t1 = new Thread(a);
        Thread t2 = new Thread(b);

        // start the threads
        t1.start();
        t2.start();

        try {
            // let both the threads complete
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        
        System.out.println("----Main Thread Completed----");

    }
}

class A implements Runnable{

    @Override
    public void run() {
        // Body
        for (int i = 0; i < 10; i++) {
            System.out.println("A" + i);
        }
    }
    
}

class B implements Runnable{

    @Override
    public void run() {
        // Body
        for (int i = 0; i < 10; i++) {
            System.out.println("B" + i);
        }
    }
    
}