/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 07-Dec-2022 
*/

package edu.javacourse.g5152;/*
Programmed by Sergii Kozhushko
*/

import java.util.Scanner;

public class Homework1 {
    public static boolean compareNumbers(int i, int j){
        return (i >= j);
    }

    public static String glueStr(String s1, String s2){
        return s1.substring(0, s1.length() / 2) + s2.substring(s2.length()/2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //1.
        System.out.print("Введите число 1: ");
        int x = scanner.nextInt();
        System.out.print("Введите число 2: ");
        int y = scanner.nextInt();
        System.out.println((x > y) ? "Число 1 большще числа 2" : "Число 2 большще числа 1");
        //2.
        x = 100; y = 2;
        System.out.println("Результат сравнения чисел "+ x + " и "+ y + ":"+ (compareNumbers(x, y) ? x + " больше " + y : x + " меньше " + y));
        //3.
        String s1 = "Поросенок";
        String s2 = "Фунтик";
        System.out.println("Результат склеивания слов '" + s1 + "' и '" + s2 + "': " + glueStr(s1, s2));
    }

}
