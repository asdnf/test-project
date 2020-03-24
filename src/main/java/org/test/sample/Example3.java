package org.test.sample;

public class Example3 {
    public static void main(String... args) {
        int num = 0;
        try {
            num = 1;
            throw new Exception();
        } catch (Exception e) {
            num = 2;
        } finally {
            num = 3;
        }
        System.out.println(num);
    }
}
