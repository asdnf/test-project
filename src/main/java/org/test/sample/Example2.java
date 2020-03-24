package org.test.sample;

public class Example2 {
    String data = "sample data";

    public static void main(String... args) {
        Example2 example2 = new Example2();
        int intValue = 42;
        example2.meth(example2, intValue);

        System.out.println(example2);  // Что выведется здесь?
        System.out.println(intValue); // Что выведется здесь?
    }

    private void meth(Example2 a, int b) {
        a = null;
        b = 100;
    }

    @Override
    public String toString() {
        return "MM{" +
                "data='" + data + '\'' +
                '}';
    }
}
