package org.test.sample;

public class Example21 {

    static Example21 example21 = new Example21();
    public String hello = "Hello";

    public static void main(String... args) {
        example21.methObj(example21);
        // Что выведется в следующей строке?
        System.out.println(example21.hello);
    }

    public void methObj(Example21 instance) {
        instance = null;
    }
}
