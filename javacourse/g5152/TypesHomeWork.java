package edu.javacourse.g5152;/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 18-Nov-2022 
*/

import java.util.Scanner;

public class TypesHomeWork {
    public static void main(String[] args) {
        //Part 1. Инициализировать и вывести на экран различные типы данных
        char ch1 = 'G';
        int int1 = 89;
        byte b1 = 4;
        short sh1 = 56;
        float fl1 = 4.7333436f;
        double d1 = 4.355453532;
        long l1 = 12121;

        System.out.println("Char variable: " + ch1);
        System.out.println("Integer variable: " + int1);
        System.out.println("Byte variable: " + b1);
        System.out.println("Short variable: " + sh1);
        System.out.println("Float variable: " + fl1);
        System.out.println("Double variable: " + d1);
        System.out.println("Long variable: " + l1);

        //Part 2. Вывод льдельно какждой из цифр целого трехзначного числа
        int int2 = 998;
        System.out.println("Integer variable : "+int2+ " consists of '" + (int2 / 100) + "' '" + ((int2 / 10) % 10) + "' and '" + (int2 % 10)+"'");


        //Part 3. 10  переменных
        int int3 = 6;
        System.out.println(int3 + "*" + int3 + "=" + int3 * int3);
        int a1 = 0, a2 = 1, a3 = 2, a4 = 3, a5 = 4, a6 = 5, a7 = 6, a8 = 7, a9 = 8, a10 = 9, sum = 0;
        sum = (a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10) / 10;
        double sumf = ((double)(a1 + a2 + a3 + a4 + a5 + a6 + a7 + a8 + a9 + a10)) / 10;
        System.out.println("Avarage arythmetic of 10 numbers is: " + sum + ". Actually, more precise value is: " + sumf );

        //Part 4. Скидка на товары
        int priceA = 1000, priceB = 500, kolvoA = 0, kolvoB = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter how much of good A (1000 rub) do you want to buy: ");
        kolvoA = scanner.nextInt();
        System.out.println("Enter how much of good B (500 rub) do you want to buy: ");
        kolvoB = scanner.nextInt();
        if (kolvoB != 0 && kolvoA !=0){
            System.out.println("The sum you have to pay is: "+ (kolvoA * priceA + kolvoB * priceB - 100));
            System.out.println("Your discount is 100 rub");
        }
        else {
            System.out.println("The sum you have to pay is: "+ (kolvoA * priceA + kolvoB * priceB   ));
            System.out.println("Your discount is 0 rub");
        }
    }

}
