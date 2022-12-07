/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 07-Dec-2022 
*/

package edu.javacourse.g5152;

import java.util.Scanner;

public class HomeWork2 {

    public static class ConvertFar2Cel {

        public static int convertCelsium2Fahrenheit(int celsium) {
            return (int) ((celsium*1.8)+32);
        }
        public static int convertFahrrenheit2Celsium(int fahrenheit) {
            return (int) ((int)(fahrenheit-32)/1.8);

        }
    }
    public static String glue2Strings(String s1, String s2){
        return s1 + s2;
    }
    public static void doSomething(){
        return;
    }
    public static void doSomething(int a, int b){
        return;
    }
    public static void doSomething(String a, String b){
        a = b;
        return;
    }
    public static void doSomething(String a, String b, String c){
        a = b;
        b = c;
        return;
    }
    public static void doSomething(String a, char b){
        if (b == 120) a = "String 1";
        return;
    }

    public static int sumThreeNumbers(int a, int b, int c) {
        return a + b + c;
    }




    public static void main(String[] args) {
        //1 - Написать программу, которая считывает с консоли (Scanner) строку и выводит на консоль ее длину
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String str = scanner.nextLine();
        System.out.println("Длинна строки: " + str.length());
        //2 - Написать метод который будет возвращать результат склейки двух строк.
        System.out.println(glue2Strings("I love ", "Java"));
        //3 - создайте 5 методов с разной сигнатурой, но с одинаковым названием метода
        doSomething();
        doSomething(1, 2);
        doSomething("String", 'c');
        doSomething("Str1", "Str2");
        doSomething("s1", "s2", "s3");

        //4
        int far = 50;
        int cels = 10;
        System.out.println(far + "F = " + ConvertFar2Cel.convertFahrrenheit2Celsium(far) +"C");
        System.out.println(cels + "C = " + ConvertFar2Cel.convertCelsium2Fahrenheit(cels) +"F");

        //5 - напишите метод для получения суммы трех чисел
        System.out.println("Сумма трех чисел 10, 20 и 35 = " + sumThreeNumbers(10,20, 35));



        }


    }



