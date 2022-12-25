/**
 * HoweWork6.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 24-Dec-2022 17:44
 */

package edu.javacourse;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HoweWork6 {
    /* Создайте массив А[1..100] с помощью генератора случайных чисел и выведите его на экран.
    Увеличьте все его элементы в 2 раза.
    Найти номер и значение первого положительного элемента массива.
    */
    static void generateArrayRandom() {
        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-20, 20);
        }
        // печатаем массив
        for (int var : array) {
            System.out.print("  " + var);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                System.out.println(String.format("Первый положительный элемент массива: a[%d] = %d", i, array[i]));
                break;
            }
        }
        // увеличиваем все элементы в два раза
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
        // печатаем массив еще раз
        for (int var : array) {
            System.out.print("  " + var);
        }
    }


    /*
    Создайте массив из пяти фамилий и выведите их на экран столбиком.
     */
    static void printNames() {
        String[] names = {"Macdauell", "Nickson", "Johnson", "Piterson", "Oruell"};
        for (String s : names) {
            System.out.println(s);
        }
    }

    /*
    В массиве, состоящем из N вещественных элементов (вводится из консоли),
    после заполняется случайными числами, найти максимальный по модулю элемент массива.
     */
    static void realNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива вещественных чисел: ");
        int n = scanner.nextInt();
        double[] array = new double[n];
        for (int i = 0; i < array.length; i++) {

            //array[i] = random.nextDouble();
            array[i] = Math.random() * 200 - 100;
        }
        double maxValue = array[0];
        for (double d : array) {
            if (Math.abs(d) > maxValue) maxValue = Math.abs(d);
            //System.out.printf("%.2f ", d);
            System.out.println(d);

        }
        System.out.println("Максимальное по модулю число: " + maxValue);
    }

    /*
    5. Есть массив чисел. Создайте его сами, и наполните сами. Нужно напечатать на консоль:
    значение каждой ячейки массива (пройтись циклом)
    значение каждой ячейки всего массива с конца в начало
    сумму значений всех ячеек
    напечатать кого в массиве больше, четных или нечетных?
    Все элементы массива поделить на значение наибольшего элемента этого массива.

    */
    static void operationsArray() {
        int[] array = new int[20];
        int sum = 0, numberOdd = 0, numberEven = 0, maxValue = 0;
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        System.out.println("Массив в прямом порядке: ");
        System.out.println(Arrays.toString(array));
        System.out.println("Массив в обратном порядке: ");
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == array.length - 1) System.out.print("[");
            System.out.print(array[i]);
            if (i == 0) System.out.print("]");
            else System.out.print(", ");
            sum += array[i];
            if (array[i] % 2 == 0) numberEven++;
            else numberOdd++;
            if (maxValue < array[i]) maxValue = array[i];
        }

        System.out.println("\nСумма значений всех элементов массива: " + sum);
        System.out.println("Максимальное значение: " + maxValue);
        System.out.printf("Количество нечетных элементов: %d, четных: %d\n", numberOdd, numberEven);
        System.out.println("Все элементы разделены на маскимальное значение: ");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%.2f ", (double) array[i] / maxValue);
        }
    }

    /*
    Second level: 1. Есть два массива char[] first = {‘a’,’b’,’c’,’d’,’e’} и char[] second = {‘f’,’g’,’h’,’i’,’g’}
    создать массив соединяющий два этих массива в один новый
         */
    static void glueArrays() {
        char[] first = new char[]{'a', 'b', 'v', 'd', 'e' };
        char[] second = {'f', 'g', 'h', 'i', 'g' };
        char[] third = new char[10];
        for (int i = 0; i < third.length; i++) {
            if (i < 5) third[i] = first[i];
            else third[i] = second[i - 5];
        }
        System.out.println(Arrays.toString(third));
    }

    /*
    Анатолию в последний месяц удача улыбалась очень плохо.
    У него 3 раза взломали пароль.
    Вот он и задумался над тем, что неправильно подходит к вопросу составления паролей.
    Чтобы не напрягаться больше и опять не попасть впросак.
    Требования к паролю у Анатолия следующие (он внимательно изучил рекомендации знатоков)
    - Длина – 8 символов (если меньше – то проще взломать, а если длиннее – то сложно запомнить).
    - В пароле должны быть:
         - заглавные буквы,
         - строчные символы,
         - числа
         - специальные знаки (из перечня {'*','-','#',';'} другие спецсимволы недопустимы, так как Анатолий их не может запомнить).

    Помогите парню составить функцию checkPass (pswd), которая проверит пароль на соответствие требованиям.

    В случае верного пароля выведется на печать «Пароль идеален», а в остальных случаях будут перечислены все ошибки, которые Анатолий допустил
     */
    // метод проверяет строку на соответствие требованиям и выдает строковый результат-сообщение
    static boolean isCharAllowed(char ch) {
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == '*' || ch == '-' || ch == '#' || ch == ';' || (ch >= '0' && ch <= '9') || (ch >= 'А' && ch <= 'я') || (ch == 'Ё') || (ch == 'ё'))
            return true;
        else return false;

    }

    // Метод проверяет строку на наличие дргуих спец символов,
    // возвращает найденный запрещенный символ или 0 если спец символ не найден
    static char hasStringOtherSpecialSymbols(String string) {
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (isCharAllowed(ch)) continue;
            else return ch;
        }
        return 0;

    }

    static boolean hasStringLowerCase(String string) {
        //boolean returnFlag = false;
        for (int i = 0; i < string.length(); i++) {
            if (Character.isLowerCase(string.charAt(i))) return true;
        }
        return false;
    }

    static boolean hasStringNumbers(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isDigit(string.charAt(i))) return true;
        }
        return false;
    }

    static boolean hasStringSpecialSymbols(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '*' || string.charAt(i) == '-' || string.charAt(i) == '#' || string.charAt(i) == ';')
                return true;
        }
        return false;
    }

    static String checkPass(String password) {
        char ch;
        if (password.length() != 8) return "Длинна пароля не равна 8 символам";
        if (password.equals(password.toLowerCase()))
            return "Пароль должен содержать хотя бы одну заглавную (большую) букву";
        if (!hasStringLowerCase(password)) return "Пароль не содержит ни одной строчной (маленькой) буквы";
        if (!hasStringNumbers(password)) return "Пароль должен содержать хотя бы одну цифру";
        if (!hasStringSpecialSymbols(password)) return "Пароль должен содержать хотя бы один символ '*','-','#',';'";
        ch = hasStringOtherSpecialSymbols(password);
        if (ch != 0) return "Пароль содержит недопустимый спецсмивол '" + ch + "'";

        return "Пароль идеален!";

    }

    static void checkPasswordMain() {
        boolean doEnterPassword = true;
        Scanner scanner = new Scanner(System.in);
        String password;
        while (doEnterPassword) {
            System.out.print("Пароль должен содержать:\n" +
                    " - минимум одну заглавную одну строчную\n" +
                    " - одну цифру\n" + " - 8 символов\n" +
                    " - один из символов '*','-','#',';', другие спецсимволы недопустимы\n" +
                    " - английский или русский язык\n" + "Введите пароль (q - выход): ");
            password = scanner.nextLine();
            if (password.equals("q")) doEnterPassword = false;
            else {
                System.out.println(checkPass(password));
                System.out.println();
            }
        }

    }

    /*
    Найти в массиве самую длинную последовательность, состоящую из одинаковых элементов.
    Вывести на экран количество элементов самой длиной последовательности и номер элемента, который является ее началом.
    Например, если массив выглядит так:
    0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0 ,
    то количество элементов самой длинной последовательности, состоящей из одинаковых элементов, равно 5,
    а начинается она с 9-го элемента.
     */
    static void findLongestPart() {
        int[] array = {1, 1, 1, 1, 0, 4, 5, 5, 5, 0, 5, 5, 5, 0, 6, 6, 6, 0};
        int maxIndex = 0,  checkNum = array[0], maxLength = 1, currentLength = 0;
        for (int i = 0; i < array.length; i++) {
            //конец последовательности
            if (array[i] != checkNum) {
                //последовательность самая длинная?
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxIndex = i;
                }
                checkNum = array[i];
                currentLength = 1;
            } else {
                currentLength++;
            }
        }
        // доп проверка если последовательность крайяння справа
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxIndex = array.length;
        }
        maxIndex = maxIndex - maxLength;
        System.out.println(Arrays.toString(array));
        System.out.printf("Самая длинная последовательность: индекс - %d, длинна - %d", maxIndex, maxLength);
    }

    public static void main(String[] args) {
        //generateArrayRandom();
        //printNames();
        //realNumbers();
        //operationsArray();
        // * 1.
        //glueArrays();
        // * 2.
        checkPasswordMain();
        // * 3.
        //findLongestPart();

    }

}
