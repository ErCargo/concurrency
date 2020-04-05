package com.ercargo.asmbase;

import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.MethodVisitor;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author ercargo  on 2020/4/5
 * @DESCRIBE
 */
public class MyClassVisitor extends ClassVisitor implements Opcodes {

    public MyClassVisitor(ClassVisitor classVisitor) {
        super(ASM5, classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        cv.visit(version, access, name, signature, superName, interfaces);
    }

    // 判断当前字节码读到什么地方， 跳过 init 方法， 将需要被增强的类交给内部类 MyMethodVisitor 来处理
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = visitMethod(access, name, desc, signature, exceptions);
        // 不对构造方法进行字节码增强（Base Class 中包含 2 个方法， 一个是自定义的 process 方法， 一个是构造方法）
        if (!name.equals("<init>") && mv != null) {
            mv = new MyMethodVisitor(mv);
        }
        return mv;
    }

    /**
     * 重写 MyMethodVisitor 中的两个方法，就可以实现 AOP
     */
    class MyMethodVisitor extends MethodVisitor implements Opcodes {
        public MyMethodVisitor(MethodVisitor mv) {
            super(Opcodes.ASM5, mv);
        }

        // 内部类，visitorCode() 方法， 会在 ASM 开始访问某一个方法的 code 区时被调用，重写 visitCode() 方法， 将 AOP 的前置逻辑放在这里
        @Override
        public void visitCode() {
            super.visitCode();
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream");
            mv.visitLdcInsn("start");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        }

        /**
         * 继续读取 字节码指令， 每当 ASM 访问到「无参数指令」时， 都会调用 MyMethodVisitor 中的 visitInsn() 方法；
         * 判断当前指令是否为无参数的 return 指令， 如果是，就在前面添加一些指令，就是将 AOP 的后置逻辑放在该方法中
         * 通过调用 methodVisitor 的 visitXXXInsn() 方法就可以实现字节码的插入（XXX 对应是 操作码助记符）
         * @param opcode
         */
        @Override
        public void visitInsn(int opcode) {
            if ((opcode >= Opcodes.IRETURN && opcode <= Opcodes.RETURN) || opcode == Opcodes.ATHROW) {
                mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream");
                mv.visitLdcInsn("end");
                mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            }

            mv.visitInsn(opcode);
        }
    }
}
