package com.ercargo.learn.concurrency.example.singletonExample;

import com.ercargo.learn.concurrency.annotation.ThreadSafe;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ercargo  on 2019/2/16
 * @DESCRIBE 饿汉模式 单例的实例在类装载的时候进行实例化创建
 */

/**
 * 不足之处：
 * 饿汉模式， 如果构造方法中存在过多的处理， 会加载的很慢，可能会引起性能问题
 *
 * 1. 私有构造函数实现时 不要有过多的处理
 * 2. 类在实例化后会被使用，不会造成资源浪费
 */
@ThreadSafe
public class SingletonExample5 {
    /**
     * 私有构造函数
     */
    private SingletonExample5() {

    }

    /**
     * 单例对象
     */
    private static SingletonExample5 instance = null;

    static {
        instance = new SingletonExample5();
    }




    /**
     * 静态工厂方法
     * @return
     */
    public static SingletonExample5 getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(getInstance());
        System.out.println(getInstance());


        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("1","2");// 覆盖

        for(Map.Entry entry :map.entrySet()){
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


    }
}
