package majors.MQInAction.ProducterAndConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: Neng Qi
 * @email: neng.qi@nuance.com
 * @date: 2018/04/27 14:35
 **/
public class CachedThreadPoolTest {
    //创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。示例代码如下：
    //线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    System.out.println(index);
                    System.out.println(Thread.currentThread().getId());
                }
            });
        }
        cachedThreadPool.shutdown();
    }
}
