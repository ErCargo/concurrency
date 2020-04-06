package com.ercargo.agent;

import com.ercargo.asmbase.Base;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 */
public class TestAgent {
    public static void agentmain(String args, Instrumentation inst) {
        // 指定自定义的 Transformer, 在其中利用 Javassist 作字节替换
        inst.addTransformer(new TestTransformer(),true);
        try {
            // 重定义类并载入新的字节码
            inst.retransformClasses(Base.class);

            System.out.println("Agent Load Done. ");

        } catch (UnmodifiableClassException e) {
            System.out.println("Ageng load failed. ");
        }

    }
}
