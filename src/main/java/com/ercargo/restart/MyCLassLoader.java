package com.ercargo.restart;

import java.io.*;

/**
 * @author ercargo  on 2020/4/4
 * @DESCRIBE
 */
public class MyCLassLoader extends ClassLoader {
    private String path;
    private String classLoaderName;

    public MyCLassLoader(String path, String classLoaderName) {
        this.path = path;
        this.classLoaderName = classLoaderName;
    }

    // 查找类文件
    @Override
    public Class findClass(String name) {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    // 用于加载类文件
    private byte[] loadClassData(String name) {
        // 路径找到对应的 class 文件
        name = path + name + ".class";

        // 输入流读取文件
        InputStream in = null;
        // byte 作为接收，输出
        ByteArrayOutputStream out = null;

        try {
            in = new FileInputStream(new File(name));
            out = new ByteArrayOutputStream();

            int i = 0;
            // 循环读取文件
            while ((i = in.read()) != -1) {
                out.write(i);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }
}

