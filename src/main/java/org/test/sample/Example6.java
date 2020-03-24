package org.test.sample;

public class Example6 {

    public static void main(String... args) {
        new C2();
    }

    static class C1 {
        static {
            System.out.println(2);
        }

        {
            System.out.println(1);
        }

        public C1() {
            System.out.println(3);
        }
    }

    static class C2 extends C1 {

        static {
            System.out.println(5);
        }

        {
            System.out.println(4);
        }

        public C2() {
            super();
            System.out.println(6);
        }
    }

}
