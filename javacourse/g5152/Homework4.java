/**
 * Homework4.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Dec-2022 15:44
 */

package edu.javacourse.g5152;

import java.util.Random;
import java.util.Scanner;

public class Homework4 {
    // 1. В первом подъезде квартиры с 1 по 20. Во втором с 21 по 48. В третьем с 49 по 90.
    // Пользователь вводит номер квартиры.
    // Программа должна указать в каком подъезде находится данная квартира.
    public static void flatNum() {
        Scanner scanner = new Scanner(System.in);
        int flatNumber;
        boolean doAsk = true;
        do {
            System.out.print("Введите номер квартиры (0 - выход): ");
            flatNumber = scanner.nextInt();
            if (flatNumber >= 1 && flatNumber <= 20) {
                System.out.println("Квартира находится в первом подъезде");
            }
            if (flatNumber >= 21 && flatNumber <= 48) {
                System.out.println("Квартира находится во втором подъезде");
            }
            if (flatNumber >= 49 && flatNumber <= 90) {
                System.out.println("Квартира находится в первом подъезде");
            }
            if (flatNumber == 0) doAsk = false;

        } while (doAsk);
    }

    // 2. Переменная num может принимать 4 значения: 1, 2, 3 или 4.
    // Если она имеет значение '1', то в переменную result запишем 'зима',
    // если имеет значение '2' – 'весна' и так далее.
    // Решите задачу через switch-case.
    public static void switchExample() {
        Scanner scanner = new Scanner(System.in);
        int num;
        boolean doAsk = true;
        do {
            System.out.print("Введите число от 0 до 3 (4 - выход): ");
            num = scanner.nextInt();
            String result = switch (num) {
                case 0 -> "зима";
                case 1 -> "весна";
                case 2 -> "лето";
                case 3 -> "осень";
                default -> "";
            };
            System.out.println("Результат: " + result);
            if (num == 4) doAsk = false;
        } while (doAsk);
    }

    // 3. В переменной month лежит какое-то число из интервала от 1 до 12.
    // Определите в какую пору года попадает этот месяц (зима, лето, весна, осень).
    public static void determineSeason() {
        int month;
        String season = "", answer = "";
        boolean doNextMonth = true;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        do {
            month = random.nextInt(12);
            if (month == 12 || month <= 3) {
                season = "Зима";
            }
            if (month >= 9 && month <= 11) {
                season = "Осень";
            }
            if (month >= 6 && month <= 8) {
                season = "Лето";
            }
            if (month >= 3 && month <= 5) {
                season = "Весна";
            }
            System.out.printf("Месяц №%s, сезон %s%n", month, season);
            System.out.print("Еще раз? y/n ");
            answer = scanner.nextLine();
            doNextMonth = answer.equals("y");
        } while (doNextMonth);
    }

    // Second level. Перевод суммы денег в пропись.
    // Пользователь вводит число от 1 до 9999 (сумму выдачи в банкомате).
    // Необходимо вывести на экран словами введенную сумму и
    // в конце написать название валюты с правильным окончанием

    // метод возвращает строку "доллар-ов" с правильным окончанием
    public static String getCurrencyStringEnd(int num) {
        int num11 = num % 100;// последние две цифры
        int n4 = num % 10;// последняя цифра
        String result;

        if (num11 != 11 && num11 != 12 & num11 != 13 && num11 != 14) {
            result = switch (n4) {
                case 1 -> "доллар";
                case 2 -> "доллара";
                case 3 -> "доллара";
                case 4 -> "доллара";
                case 5 -> "долларов";
                case 6 -> "долларов";
                case 7 -> "долларов";
                case 8 -> "долларов";
                case 9 -> "долларов";
                default -> "";
            };
        }
        else {
            result = "долларов";
        }
        return result;
    }

    // метод переводит число в строку прописью
    public static String convertNumToWord(int currencyNum) {
        String result, endDollar = "";
        int n1, n2, n3, n4;
        n1 = currencyNum / 1000;
        result = switch (n1) {
            case 1 -> "одна тысяча";
            case 2 -> "две тысячи";
            case 3 -> "три тысячи";
            case 4 -> "четыре тысячи";
            case 5 -> "пять тысяч";
            case 6 -> "шесть тысяч";
            case 7 -> "семь тысяч";
            case 8 -> "восемь тысяч";
            case 9 -> "девять тысяч";
            default -> "";
        };
        if (n1 > 0) result += " ";
        n2 = (currencyNum - (currencyNum / 1000) * 1000) / 100;
        result += switch (n2) {
            case 1 -> "сто";
            case 2 -> "двести";
            case 3 -> "триста";
            case 4 -> "четырста";
            case 5 -> "пятьсот";
            case 6 -> "шестьсот";
            case 7 -> "семьсот";
            case 8 -> "восемьсот";
            case 9 -> "девятьсот";
            default -> "";
        };
        if (n2 > 0) result += " ";

        n3 = ((currencyNum % 100) - (currencyNum % 10)) / 10;

        result += switch (n3) {
            case 2 -> "двадцать";
            case 3 -> "тридцать";
            case 4 -> "сорок";
            case 5 -> "пятьдесят";
            case 6 -> "шестьдесят";
            case 7 -> "семьдесят";
            case 8 -> "восемьдесят";
            case 9 -> "девяносто";
            default -> "";
        };
        if (n3 == 1) {
            n4 = currencyNum % 100;
            result += switch (n4) {
                case 10 -> "десять";
                case 11 -> "одиннадцять";
                case 12 -> "двенадцать";
                case 13 -> "тринадцать";
                case 14 -> "четырнадцать";
                case 15 -> "пятнадцать";
                case 16 -> "шестнадцать";
                case 17 -> "семьнадцать";
                case 18 -> "восемнадцать";
                case 19 -> "девятьнадцать";
                default -> "";
            };
        } else {
            if (n3 > 0) result += " ";
            n4 = currencyNum % 10;
            result += switch (n4) {
                case 1 -> "один";
                case 2 -> "два";
                case 3 -> "три";
                case 4 -> "четыре";
                case 5 -> "пять";
                case 6 -> "шесть";
                case 7 -> "семь";
                case 8 -> "восемь";
                case 9 -> "девять";
                default -> "";
            };
        }
        result += " " + getCurrencyStringEnd(currencyNum);


        return result;
    }

    public static void bankomat() {
        Scanner scanner = new Scanner(System.in);
        int sumCurrency;
        System.out.print("Ввведите сумму от 1 до 9999: ");
        sumCurrency = scanner.nextInt();
        System.out.println("Ваша сумма словами: " + convertNumToWord(sumCurrency));
    }

    public static void main(String[] args) {
        //flatNum();
        //switchExample();
        //determineSeason();
        bankomat();

    }

}
