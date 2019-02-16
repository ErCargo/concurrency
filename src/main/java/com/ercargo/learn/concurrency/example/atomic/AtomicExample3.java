package com.ercargo.learn.concurrency.example.atomic;

import com.ercargo.learn.concurrency.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
@ThreadSafe
public class AtomicExample3 {
    //请求总数
    public static int clientTotal = 5000;
    //同事并发执行的线程数
    public static int threadTotal = 200;


    /**
     * //核心是： 将热点数据分离
     * CAS 是在一个死循环中不断的尝试修改目标值，知道修改成功，如果竞争不激烈的时候，修改成功的概率很高；竞争激烈的时候修改失败的概率很高；
     * 在大量修改失败的时候，这些原子操作就行进行多次的循环尝试，因此性能会受到一些影响；
     * 对于普通类型的long 和double 变量，jvm 允许将64位的读操作或写操作拆成2个32位的操作；
     * LongAdder 这个类的实现：核心就是将热点数据分离，比如将AtomicValue内部的核心数据分离成一个数组，每个线程访问时，通过hash等算法
     * 映射  到其中一个数字进行计数，而最终的计数结果则为这个数组的求和累加
     * 其中热点数据Value会被分离成多个单元的cell， 每个cell 独自维护内部的值
     * 当前对象的实际值， 由所有的cell 累计合成
     * 这样就把热点进行有效的分离， 并提高了并行度
     * LongAdder将单点的更新压力分散到各个节点上，低并发的时候和Atomic 的性能基本一致
     * 高并发的时候则通过分散提高了性能
     *
     * 缺点：有误差
     *
     */
    public static LongAdder count = new LongAdder();

    public static void main(String[] args) throws InterruptedException {

        //线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量
        final Semaphore semaphore = new Semaphore(threadTotal);
        //计数器闭锁
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);


        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //引入信号量， 判读当前县线程是否允许被执行；达到一定的并发数， add()会阻塞；acquire 能返回值时 ， add()才会执行，执行完后要释放
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (Exception e) {
                    log.error("exception" + e);
                    e.printStackTrace();
                }
                //每执行完一次，计数值减1
                countDownLatch.countDown();

            });
        }
        countDownLatch.await(); //保证之前的线程都运行完了，再计数
        executorService.shutdown();
        //所有线程执行完后打印计数值
        log.info("count{}", count);

    }

    private static void add() {
        //底层compareAndSwapInt()方法就是CAS原理
        //当前对象的值与底层内存中的值进行比较， 一致才进行操作
        count.increment();
    }
}
