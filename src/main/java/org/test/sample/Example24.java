package org.test.sample;

import java.util.concurrent.atomic.AtomicInteger;

public class Example24 {

    public static void main(String... args) {
        AtomicInteger value = new AtomicInteger(42);
        methObj(value);
        // Что выведется в следующей строке?
        System.out.println(value);
    }

    public static void methObj(AtomicInteger instance) {
        instance.set(100500);
    }
}
