package com.ercargo.learn.concurrency.example.atomic;

import com.ercargo.learn.concurrency.annotation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    /**
     * 原子性的去更新
     * 某个类的实例的指定的某个字段
     * 改字段必须用volatile 修饰 不要static 修饰
     */
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success,{}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)) {
            log.info("update success 2,{}", example5.getCount());
        } else {
            log.info("update failed:{}", example5.getCount());
        }


    }

}
