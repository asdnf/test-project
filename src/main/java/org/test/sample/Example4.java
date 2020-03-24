package org.test.sample;

public class Example4 {
    public static void main(String... args) {
        System.out.println(method());
    }

    public static int method() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
