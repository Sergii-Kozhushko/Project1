/**
 * HomeWork5.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 19-Dec-2022 06:40
 */

package edu.javacourse.g5152;

import java.util.Scanner;

public class HomeWork5 {
    //метод непосредственно считает количество высокосных годов между двумя годами
    static int calculateLeapYearsRange(int year1, int year2){
        int year3, sum = 0;
        if (year2 < year1) {
            year3 = year2;
            year2 = year1;
            year1 = year3;
        }
        for (int i = year1; i <= year2; i++){
            if (i % 4 == 0){
                sum++;
            }
        }
        return sum;
    }
//    1) пользователь вводит с консоли (Scanner) 2 числа (2 года)
//    написать программу, которая считает сколько годов между двумя числами високосные
    static void calculateLeapYears() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Подсчет высокосных годов. \nВведите год 1: ");
        int year1 = scanner.nextInt();
        System.out.println("Введите год 2: ");
        int year2 = scanner.nextInt();
        System.out.printf("Между этими годами %s высокосных годов.", calculateLeapYearsRange(year1, year2));

    }
    // 2) Вывести на консоль те двузначные числа которые делятся на 4, но не делятся на 6.
    static void printNumbers46(){
        System.out.print("Двузначные числа которые делятся на 4, но не делятся на 6: ");
        for (int i = 10; i < 100; i++){
            if (i % 4 == 0 && i % 6 != 0)
                System.out.print(i + " ");
        }
    }

    //    4) Вывести на консоль сумму чисел от 0 до 100
    static void printSumNumbersFrom0To100(){
        int sum = 0;
        for (int i = 0; i <= 100; i++){
            sum += i;
        }
        System.out.println("Сумма чисел от 0 до 100: " + sum);
    }
    //5) Вывести на консоль числа от -10 до -40.
    static void printNumbersInRange(){
        System.out.print("Целые ичсла от -10 до -40: ");
        for (int i = -40; i <= -10; i++)
            System.out.print(i + " ");
    }
    //6) Вывести на консоль произведение двузначных нечетных чисел кратных 13.
    static void printMultiply13(){
        //System.out.print("Произведение двузначных нечетных чисел кратных 13: ");
        int mult = 0;
        String str = "";
        for (int i = 10;i <= 100; i++)
            if (mult == 0) mult = i;
            else if (i % 13 == 0 && i % 2 == 1) {
                mult = mult * i;
                str = str + " " + i;
            }
        System.out.print("Произведение двузначных нечетных чисел кратных 13: (" + str + ") :" + mult);
    }
//    7) Необходимо написать программу, которая проверяет пользователя на знание таблицы умножения. Пользователь сам вводит два
//    целых однозначных числа. Программа задаёт вопрос: результат умножения первого числа на второе.
//    Пользователь должен ввести ответ и увидеть на экране правильно он ответил или нет. Если нет
//– показать еще и правильный результат.
    static void tableMultiply(){
        boolean doAsk = true;
        int num1, num2, result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Таблица умножения.");
        do {
            System.out.print("Введите число 1: ");
            num1 = scanner.nextInt();
            System.out.print("Введите число 2: ");
            num2 = scanner.nextInt();
            System.out.print("Введите результат умножения " + num1 + "x" + num2 + ": ");
            result = scanner.nextInt();
            if (num1 * num2 != result)
                System.out.println("Ответ неверный. Правильный ответ: " + (num1 * num2));
            else
                System.out.println("Правильно. Молодец!");
            System.out.print("Еще раз? y/n: ");
            scanner = new Scanner(System.in);// объявил новый объект тк почему-то не считывало строку
            doAsk = scanner.nextLine().equals("y");

        } while (doAsk);
    }
//    8) напишите программу, которая проверяет является ли число простым
//    Простое число - число которое делится только на 1 и на самого себя
//    Например число 17 - просто оно делится только на 1 и на 17
//    число 6 не простое - оно делится на 1, 2, 3 и 6

    // метод проверяет являтся ли число простым
    static boolean isNumberSimple(int number){
        boolean isSimple = true;
        for (int i = 2; i < number; i++){
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
    // основной метод задачи №8
    static void simpleNumberMain(){
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.print("Проверяем является ли число простым. Введите число: ");
        number = scanner.nextInt();
        System.out.println("Ответ: число " + (isNumberSimple(number)? "простое" : "непростое"));
    }
//Second Level
// 1) написать программу которая выводит результат умножения одного числа на другое, не используя знак умножения. только знаки сложения
    static int multiplyNumbersByPlus(int number1, int number2){
        int sum = 0, number3;
        //меняем местами большее им еньшее число, чтобы уменьшить количество циклов
        if (number1 > number2){
            number3 = number1;
            number1 = number2;
            number2 = number3;
        }
        for (int i = 0; i < number1; i++){
            sum += number2;
        }
        return sum;
    }
    static void multiplyNumbersByPlusMain(){
        Scanner scanner = new Scanner(System.in);
        int num1, num2, result;
        System.out.print("Умножение двух чисел сложением.\n Введите число 1: ");
        num1 = scanner.nextInt();
        System.out.print("Введите число 2: ");
        num2 = scanner.nextInt();
        long time = System.nanoTime();
        result = multiplyNumbersByPlus(num1, num2);
        time = System.nanoTime() - time;
        System.out.println("Результат: " + result);
        System.out.printf("Время выполнения: %,9.3f ms \n", time/1_000_000.0);
        time = System.nanoTime();
        result = num1 * num2;
        time = System.nanoTime() - time;
        System.out.printf("Та же операция умножением заняла: %,9.4f ms ", time/1_000_000.0);
    }
    // Second Level 2)
    // вывести на консоль среднее значение всех нечетных чисел от 0 до 100
    static void averageNumbers(){
        int sum = 0, count = 0;
        double result;
        for (int i = 0; i <= 100; i++){
            if (i % 2 != 0) {
                sum += i;
                count++;
            }
        }
        result = ((double) sum) / count;
        System.out.printf("Среднее значение всех нечетных чисел от 0 до 100: %.2f", result);
    }
// Second Level 3)
// Высчитать факториал числа n. Факториал 5 = 1 * 2 * 3 * 4 * 5
    static long fuctorialRec(int number){
        if (number > 1) return fuctorialRec(number - 1) * number;
        else return 1;
    }
    static long fuctorialCycle(int number){
        long sum = 1;
        for (int i = 1; i <= number; i++){
            sum *= i;
        }
        return sum;
    }
    static void fuctorialMain(){
        long time = System.nanoTime();
        final int NUMBER = 20;
        System.out.println("Факториал числа " + NUMBER + " рекурсией: " + fuctorialRec(NUMBER));
        time = System.nanoTime() - time;
        System.out.printf("Вычисление факториала рекурсией заняло: %,9.4f ms \n", time/1_000_000.0);

        time = System.nanoTime();
        System.out.println("Факториал числа " + NUMBER + " циклом: " + fuctorialCycle(NUMBER));
        //fuctorialCycle(5);
        time = System.nanoTime() - time;
        System.out.printf("Вычисление факториала циклом заняло: %,9.4f ms ", time/1_000_000.0);

    }

    // Second Level 4)
    // Дана строка из 3-х цифр. Найдите сумму этих цифр. То есть сложите как числа первый символ строки, второй и третий.
    static int sumStringNumbers(String s){
        int sum = 0;
        for (int i = 0; i < s.length(); i++){
            sum += Integer.parseInt(s.substring(i, i+1));

        }
        return sum;
    }
    static void sumOfStringNumbersMain(){
        String s = "2516";
        System.out.println("Сумма цифр числа '" + s + "': " + sumStringNumbers(s));
    }

    // Second Level 2
//    5) Дана строка из 6-ти цифр. Проверьте, что сумма первых трех цифр равняется сумме вторых трех цифр. Если это так - выведите 'да', в противном случае выведите 'нет'.
//    в данной задаче нужно использовать 2 сумматора и дополнительно метод if чтобы проверить когда нам нужно складывать к первому сумматору, а когда ко второму
    static String sum3Numbers(String string){
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < string.length(); i++){
            if (i < string.length() / 2) sum1 += Integer.parseInt(string.substring(i, i+1));
            else sum2 += Integer.parseInt(string.substring(i, i+1));
        }
        return (sum1 == sum2) ? "Да" : "Нет";
    }
    static void sum3NumbersMain(){
        String string = "123321";
        System.out.println("Сумма первых трех цифр и последених трех числа '" + string +"' равны: " + sum3Numbers(string));

    }

    public static void main(String[] args) {
        //calculateLeapYears();
        //printNumbers46();
        //printSumNumbersFrom0To100();
        //printNumbersInRange();
        //printMultiply13();
        //tableMultiply();
        //simpleNumberMain();
        //multiplyNumbersByPlusMain();
        //averageNumbers();
        //fuctorialMain();
        //sumOfStringNumbersMain();
        sum3NumbersMain();

    }

}
