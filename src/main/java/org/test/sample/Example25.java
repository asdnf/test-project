package org.test.sample;

public class Example25 {

    public static void main(String... args) {
        Integer value = new Integer();
        value.fromValue(42);
        methObj(value);
        // Что выведется в следующей строке?
        System.out.println(value);
    }

    public static void methObj(Integer instance) {
        instance.fromValue(100500);
    }

    static class Integer extends Number {

        int value;

        public int intValue() {
            return value;
        }

        public long longValue() {
            return value;
        }

        public float floatValue() {
            return value;
        }

        public double doubleValue() {
            return value;
        }

        void fromValue(int v) {
            value = v;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }
}
