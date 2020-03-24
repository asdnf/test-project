package org.test.sample;

import java.util.HashMap;
import java.util.Map;

public class Example6 {

    public static void main(String... args) {
        new C2();
    }

    static class C1 {
        static {
            System.out.println(2);
        }

        private Map map = new HashMap() {
            {
                System.out.println(8);
            }
        };

        public C1() {
            System.out.println(3);
        }
    }

    static class C2 extends C1 {

        static {
            System.out.println(5);
        }

        private Map map = new HashMap() {
            {
                System.out.println(7);
            }
        };

        public C2() {
            super();
            System.out.println(6);
        }
    }

}
