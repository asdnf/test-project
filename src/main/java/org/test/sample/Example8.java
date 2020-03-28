package org.test.sample;

import sun.misc.IOUtils;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Example8 {

    public static int STATIC_ONE = 1;
    public int DYNAMIC_ONE = 1;

    public static void main(String... args) throws ClassNotFoundException, IOException,
            NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException {
        InputStream classStream = Example8.class.getResourceAsStream("/Example8Runtime.class");

        Path src = Paths.get("C:\\Users\\44586\\YandexDisk\\test-project\\src\\main\\resources\\Example8Runtime.class.bin");
        Path dest = (Paths.get("C:\\Users\\44586\\YandexDisk\\test-project\\target\\classes\\org\\test\\sample\\Example8Runtime.class"));

//        if (Files.exists(dest)) {
//            Files.delete(dest);
//        }

        Files.copy(src, dest);

        Class clz = Example8.class.getClassLoader().loadClass("org.test.sample.Example8Runtime");
        Object inst = clz.newInstance();

        Integer one = (Integer) clz.getMethod("staticOne").invoke(null);
        System.out.println(one);
        one = (Integer) clz.getMethod("dynamicOne").invoke(inst);
        System.out.println(one);
        one = (Integer) clz.getField("STATIC_ONE").get(null);
        System.out.println(one);
        one = (Integer) clz.getField("DYNAMIC_ONE").get(inst);
        System.out.println(one);
    }

    public static int staticOne() {
        return 1;
    }

    public int dynamicOne() {
        return 1;
    }

}
