package com.ercargo.restart;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author ercargo  on 2020/4/6
 * @DESCRIBE
 */
public class Finalization {
    public static Finalization finalization;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finilized");
        finalization = this;
    }

    public static void main(String[] args) {
        Finalization finalization1 = new Finalization();
        System.out.println("1:--- " + finalization1);

        finalization1 = null;
        System.gc();

        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("2:--- " + finalization1);
        System.out.println("3:--- " + finalization1.finalization);

        String str = new String("aaa");
        SoftReference<String> soft = new SoftReference<String>(str);

        // 弱引用
        WeakReference<String> weak = new WeakReference<String>(str);

        // 虚引用
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(str, queue);

    }
}
