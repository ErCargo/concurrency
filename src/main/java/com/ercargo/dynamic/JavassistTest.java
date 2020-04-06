package com.ercargo.dynamic;

import com.ercargo.asmbase.Base;
import javassist.*;

import java.io.IOException;

/**
 * @author ercargo  on 2019/4/5
 * @DESCRIBE
 */
public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IOException, IllegalAccessException, InstantiationException {
        Base tt = new Base();
        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.ercargo.asmbase.Base");
        CtMethod cm = cc.getDeclaredMethod("process");

        cm.insertBefore("{System.out.println(\"start\");}");
        cm.insertAfter("{System.out.println(\"end\");}");

        Class c = cc.toClass();

        cc.writeFile("/Users/ercargo/Desktop");
        Base b = (Base) c.newInstance();
        b.process();
    }
}
