package org.test.sample;

public class Example5 {
    private String brand;
    private boolean empty;

    public static void main(String... args) {
        Example5 bottle = new Example5();
        if (!bottle.empty) {
            System.out.println("brand = " + bottle.brand);
        }
    }
}
