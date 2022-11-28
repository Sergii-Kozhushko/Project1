/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 27-Nov-2022 
*/

package edu.javacourse.g5152;
/*
Programmed by Sergii Kozhushko
*/

import java.nio.channels.Pipe;
import java.util.Scanner;

public class StringIO {
    public static void main(String[] args) {
        String str1 = "I love Java Lessons!";
        System.out.println("2. Первый символ строки 'I love Java lessons' такой: " + str1.charAt(0));
        if (str1.contains("love")) System.out.println("4. Строка 'I love Java lessons' содержит подстроку love");
        System.out.println("5. А сейчас мы заменили все символы 'o'  на 'a': " + str1.replace('o','a'));
        System.out.println("6. Преобразование строки к верхнему регистру: " + str1.toUpperCase());
        System.out.println("7. Преобразование строки к нижнему регистру: " + str1.toLowerCase());
        System.out.println("8. Вырезанная подстрока 'Lessons': " + str1.substring(12,19));
        System.out.println("10. Индекс символа L в строке '" + str1 + "': " + str1.indexOf('L'));

        /** 11, 12
         *
         */
        System.out.println("Введите ваше имя: ");
        Scanner sc = new Scanner(System.in);
        str1 = sc.nextLine();
        System.out.println("Hello, " + str1 +"!");
        //12.
        System.out.println("Ваше имя начинается с символа " + str1.charAt(0));
        /**13.
         *
         */
        double d = 59.976d;
        int int1 = (int) d;
        System.out.println(int1);
        /**
         14.
         */
        int int2 = 475;
        short sh;
        sh = (short)int2;
        System.out.println(sh);



    }
}
