package com.ercargo.asmbase;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 */
public class Generator {
    public static void main(String[] args) throws IOException {
        ClassReader reader = new ClassReader("/Users/ercargo/ErCargo/concurrency/src/main/java/com/ercargo/asmbase/Base");
        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);

        ClassVisitor visitor = new MyClassVisitor(writer);
        reader.accept(visitor, ClassReader.SKIP_DEBUG);

        byte[] data = writer.toByteArray();

        File file = new File("/Users/ercargo/ErCargo/concurrency/src/main/java/com/ercargo/asmbase/Base.class");

        FileOutputStream out = new FileOutputStream(file);
        out.write(data);
        out.close();
        System.out.println("generate success");
    }
}
