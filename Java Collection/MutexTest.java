import java.util.concurrent.Semaphore;

public class MutexTest {
    static Semaphore semaphore = new Semaphore(1);// A mutex is a Semaphore that has just one permit
    public static class MyLockerThread extends Thread {
        String name = "";
        MyLockerThread(String name){
            this.name = name;
        }

        //Each class ie anonymous oir inner class that implements a Thread must implement the defauls function run

        public void run(){

            try
            {
                System.out.println(name + ": acquring lock....");
                System.out.println(name + ": available Mutex permit now is " + semaphore.availablePermits());
                semaphore.acquire();
                System.out.println(name + ": got the permit");

                try
                {
                    //The use of this try is for performing the given operation after acquiring the resource  and sleeping so others can also do so

                    for (int i = 0; i <=5; i++){
                        //the maximum limit is 5 because we have just 4 permits
                        System.out.println(name + ": is Performing operation  " + i + "" +
                                ", available Semaphore permits: " + semaphore.availablePermits() + " " + semaphore.drainPermits());

                        //waiting time after every execution so the others can execute
                        Thread.sleep(10000);
                    }
                }finally {
                    //Calling the release of the resource after successful acquire()
                    System.out.println(name + ": releasing lock....");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permit now: " + semaphore.availablePermits());
                }
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }
        }
    }
    public  static void main(String[] args){
        System.out.println("Total  available Semaphore permits: " + semaphore.availablePermits());
        MyLockerThread t1 = new MyLockerThread("A");//Remember a static class can only be called in a static class
        t1.start();
        MyLockerThread t2 = new MyLockerThread("B");
        t2.start();
        MyLockerThread t3 = new MyLockerThread("C");
        t3.start();
        MyLockerThread t4 = new MyLockerThread("D");
        t4.start();
        MyLockerThread t5 = new MyLockerThread("E");
        t5.start();
        MyLockerThread t6 = new MyLockerThread("F");
        t6.start();
    }
}
