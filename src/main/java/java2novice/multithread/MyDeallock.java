package java2novice.multithread;

/*
Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
Deadlocks can occur in Java when the synchronized keyword causes
the executing thread to block while waiting to get the lock,
associated with the specified object.
Since the thread might already hold locks associated with other objects,
two threads could each be waiting for the other to release a lock.
In such case, they will end up waiting forever.
 */

public class MyDeallock {
    String java = "JAVA";
    String unix = "UNIX";

    Thread trd1 = new Thread("My Thread 1") {
        @Override
        public void run() {
            System.out.println("run trd1");
            while (true) {
                System.out.println("in trd1 while loop");
                synchronized (java) {
                    System.out.println("lock java in trd1");
                    synchronized (unix) {
                        System.out.println("lock unix in trd1");
                        System.out.println(java + unix);
                    }
                }
            }
        }
    };

    Thread trd2 = new Thread("My Thread 2") {
        public void run() {
            System.out.println("run trd2");
            while (true) {
                System.out.println("in trd2 while loop");
                synchronized (unix) {
                    System.out.println("lock unix in trd2");
                    synchronized (java) {
                        System.out.println("lock java in trd2");
                        System.out.println(unix + java);
                    }
                }
            }
        }
    };

    public static void main(String a[]){
        MyDeallock mdl = new MyDeallock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}
