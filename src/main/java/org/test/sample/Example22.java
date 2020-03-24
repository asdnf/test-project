package org.test.sample;

public class Example22 {

    public static void main(String... args) {
        int value = 42;
        methObj(value);
        // Что выведется в следующей строке?
        System.out.println(value);
    }

    public static void methObj(int instance) {
        instance = 100500;
    }
}
