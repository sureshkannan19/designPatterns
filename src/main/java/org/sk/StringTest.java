package org.sk;

public class StringTest {

    public static void main(String args[]) {
        String str = String.join("^", "You", "are", "Awesome");
        System.out.println(4 << 10); // 10000000000

        System.out.println(2 << 1);  // Left shift the 1 in binary form of 2, one place == 4
        System.out.println(2 << 2);  // Left shift the 1 in binary form of 2, two place == 8
        System.out.println(2 << 3);  // Left shift the 1 in binary form of 2, three place == 16


        System.out.println(5 << 1);  // Left shift the 1 in binary form of 2, one place == 10
        System.out.println(5 << 2);  // Left shift the 1 in binary form of 2, two place == 20
        System.out.println(5 << 3);  // Left shift the 1 in binary form of 2, three place == 40

        System.out.println(10 ^ 2);
        System.out.println(10 >> 2);
        System.out.println(10 >> 3);
        Integer a = null;
        System.out.println(a + "..");
        System.out.println("123".concat("1"));
        System.out.println(str);
    }
}

