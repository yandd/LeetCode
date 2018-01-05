package knowledge.multiProcess.chapter3;

public class WaitMethodLockStill {
    public void testMethod(Object lock){
        try {
            synchronized (lock){
                System.out.println("begin wait()");
                lock.wait();
                System.out.println("end wait()");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}