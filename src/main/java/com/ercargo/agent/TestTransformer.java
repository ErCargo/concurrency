package com.ercargo.agent;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 */
public class TestTransformer implements ClassFileTransformer {
    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("Transforming --- " + className);
        try {
            ClassPool cp = ClassPool.getDefault();

            CtClass ct = cp.get("com.ercargo.asmbase.Base");
            CtMethod cm = ct.getDeclaredMethod("process");

            cm.insertBefore("{System.out.println(\"start\");}");
            cm.insertAfter("{System.out.println(\"end\");}");

            return ct.toBytecode();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
