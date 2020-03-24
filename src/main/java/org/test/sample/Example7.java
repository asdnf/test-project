package org.test.sample;

import java.util.BitSet;

public class Example7 {

    // Что делает эта программа?
    public static void main(String... args) {
        int valueLength = 5;

        BitSet bits1 = new BitSet(valueLength); // 1010
        bits1.set(1);
        bits1.set(3);

        BitSet bits2 = new BitSet(valueLength); // 111
        bits2.set(0);
        bits2.set(1);
        bits2.set(2);

        BitSet res = new BitSet(valueLength + 1);

        boolean c = false;
        for (int i = 0; i < valueLength; i++) {
            boolean result = bits1.get(i) ^ bits2.get(i) ^ c;
            if (result) {
                res.set(i);
            } else {
                res.clear(i);
            }
            c = bits1.get(i) && bits2.get(i) ||
                    c && (bits1.get(i) ^ bits2.get(i));
        }

        System.out.println(bitsToNumber(res));
    }

    public static int bitsToNumber(BitSet bits) {
        int result = 0;
        for (int i = bits.length() - 1; i >= 0; i--) {
            result = result << 1;
            if (bits.get(i)) {
                result++;
            }
        }
        return result;
    }

}
