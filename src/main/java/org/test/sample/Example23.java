package org.test.sample;

public class Example23 {

    public static void main(String... args) {
        Integer value = 42;
        methObj(value);
        // Что выведется в следующей строке?
        System.out.println(value);
    }

    public static void methObj(Integer instance) {
        instance = 100500;
    }
}
