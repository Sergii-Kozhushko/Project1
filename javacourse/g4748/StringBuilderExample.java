package edu.javacourse.g4748;

import java.util.Arrays;
import java.util.Scanner;

public class StringBuilderExample {

    public static void main(String[] args) {
//        stringConcat();
//        stringBuilderExample();
//        stringBufferExample();
//        stringMethodsDemo();

        consoleCapitaliser();

    }

    private static void consoleCapitaliser() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Please enter the line >>>> ");
        String s = scanner.nextLine();
        System.out.printf("You entered: {%s}\n", s);
        s = ultraCapitalise(s);
        System.out.printf("Capitalised string is {%s}\n", s);
    }

    private static String ultraCapitalise(String source) {
        char[] chars = source.trim().toCharArray();
        chars[0] = capitaliseChar(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ' ') {
                chars[i + 1] = capitaliseChar(chars[i + 1]);
            }
        }
        return String.valueOf(chars);

    }

    private static char capitaliseChar(char c) {
        return String.valueOf(c).toUpperCase().charAt(0);
    }

    private static void stringMethodsDemo() {
        //        char c = 'r';
//        char c = 20313;
        char c = '\u4321';
        System.out.println(c);

        String s = "hello world of madness!";
        //ASCII
//        String newString = s.replace("world", "people");
//        String newString = s.substring(6, 11);
        int worldIndex = s.indexOf("world");
        int endIndex = s.indexOf("madness");
        String newString = s.substring(worldIndex, endIndex);
        System.out.println(s);
        System.out.println(newString);
        s = s.substring(0, 1).toUpperCase() + s.substring(1);

        String[] strings = s.split("\\s");
        System.out.println(s);
        System.out.println(Arrays.toString(strings));
    }

    //apache commons
    //Потокобезопасный
    private static void stringBufferExample() {
        System.out.println("START!");
        StringBuffer s = new StringBuffer("Hello");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 500_000; i++) {
            s.append(i);
        }

        long measuredTime = System.currentTimeMillis() - startTime;
        System.out.printf("Time taken: %dms, string length: %d\n", measuredTime, s.length());
    }

    //Позволяет быстро изменять содержимое
    private static void stringBuilderExample() {
        System.out.println("START!");
        StringBuilder s = new StringBuilder("Hello");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 500_000; i++) {
            s.append(i);
        }

        long measuredTime = System.currentTimeMillis() - startTime;
        System.out.printf("Time taken: %dms, string length: %d\n", measuredTime, s.length());
    }

    //Иммутабельный
    private static void stringConcat() {
        System.out.println("START!");
        String s = "Hello";

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 500_000; i++) {
            s += i;
        }

        long measuredTime = System.currentTimeMillis() - startTime;
        System.out.printf("Time taken: %dms, string length: %d\n", measuredTime, s.length());
    }

    private static void stringsComparing() {
        Scanner scanner = new Scanner(System.in);
        String s1 = "Hi";
        String s2 = "Hi";
        String s3 = new String("Hi").intern();
        String s4 = new String(s1).intern();
        String s5 = "H";
        String s6 = "i";
        String s7 = s5 + s6;
        String s71 = "H" + "i";
        char[] chars = {'H', 'i'};
        String s8 = new String(chars);
        String s9 = new String(new byte[]{72, 105});
        String s10 = scanner.next();

//        System.out.println(s1 == s2);
//        System.out.println(s1 == s3);
//        System.out.println(s1 == s4);
//        System.out.println(s1 == s7);
//        System.out.println(s1 == s8);
//        System.out.println(s1 == s9);
//        System.out.println(s1 == s10);

        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.equals(s4));
        System.out.println(s1.equals(s7));
        System.out.println(s1.equals(s8));
        System.out.println(s1.equals(s9));
        System.out.println(s1.equals(s10));

//        System.out.println((int)chars[0]);
//        System.out.println((int)chars[1]);
    }
}
