package edu.javacourse.g4748;/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 22-Nov-2022 
*/

import java.util.Random;
import java.util.Scanner;

public class GameGuessWord {
    static String[] words = {"мама", "папа","точка", "мышка", "ложка", "привет", "тачка","дом", "дурка", "бублик", "комп", "собака", "кот", "кобра", "лапа", "жаба", "шишка"};
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";


    private static void fillArrayDiagonal(int num){
        //Метод создает квадратный массив и заполняет его диагональнеы эелменты заданным числом
        int [][] intArr = new int[5][5] ;
        for (int i=0;i<5; i++){
            for (int j=0; j < 5;j++){
                if ((i == j) || (i + j) == 4) intArr[i][j] = num;
                else intArr[i][j] = new Random().nextInt(100);
                System.out.print(intArr[i][j]+"  ");
            }
            System.out.println();
        }
    }

    private static int countSubStrAtString(String s1, String s2){
        //s1 - строка в которой ищем, s2 - строка, которую ищем
        int count = 0;
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        boolean equals = false;
        for (int i = 0; i < (ch1.length-ch2.length)+1;i++){
            equals = true;
            for (int j = 0;j < ch2.length; j++){
                if (ch2[j] != ch1[i+j]) equals = false;
            }
            if (equals) count++;

        }
        return count;
    }
    private static int countCharAtString(String s, char c){
        int count=0;
        for (int i=0; i < s.length(); i++){
            if (s.charAt(i) == c) count++;
        }
        return count;
    }
    private static String fillStringStars(String s){
        String s2 = "";
        for (int i = 0;i < s.length();i++)
            s2 = s2 + '*';
        return s2;
    }

    private static String compareStrings(String s1, String s2){
        //метод сравнивает две строки и вовзращает мтроку в которой открыты только совпадающие символы из двух строк, остальные *
        //s1 - Secret String, s2 - string, entered by user

        String res = "";
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) == s2.charAt(i)) res = res+s1.charAt(i);
            else res = res + '*';
        }
        return res;
    }

    public static void main(String[] args) {
        //Задание 1. Заполнить диагонали массива заданным числом
        //fillArrayDiagonal(5);

        //Задание 2. Посчитать вхождения чара в строку
        //System.out.println(countCharAtString("Test string", 's'));
        //Задание 3. Посчитать число вхождений подстроки в строку
        //System.out.println(countSubStrAtString("String1 Str", "Str"));
        //System.exit(0);




        //Задание 4. Игра Угадай слово
        String wordToFind;//загаданное слово
        String wordCurrent;
        String intStr;

        System.out.println("Давай поиграем? Игра "+ANSI_RED+"'Отгадай слово'"+ANSI_RESET+" o\\/o");
        boolean areWePlayOuter = true;
        boolean areWeInPlay;
        Scanner scanner = new Scanner(System.in);

        while (areWePlayOuter) {
            //внешний цикл для нескольких игр
            wordToFind = words[new Random().nextInt(words.length-1)];
            areWeInPlay = true;

            System.out.println("Загадано слово на русском языке, оно состоит из " + wordToFind.length() + " букв.\n " + fillStringStars(wordToFind));
            while (areWeInPlay) {
                //цикло одной игры
                System.out.print("Введи твой вариант (для выхода жми 'в'): ");
                wordCurrent = scanner.nextLine();

                if (wordCurrent.equals("в")) {
                    areWePlayOuter = false;
                    break;
                }
                if (wordCurrent.equals(wordToFind)) {
                    System.out.print(ANSI_GREEN + "Поздравляю. На этот раз ты победил! ");
                    System.out.print("Хочешь сыграть еще? (д/н) "+ANSI_RESET);
                    intStr = scanner.nextLine();
                    if (intStr.equals("н")) areWePlayOuter = false;
                    break;
                }
                if (wordToFind.length() == wordCurrent.length()) {

                    System.out.println("\n" + compareStrings(wordToFind, wordCurrent));
                } else
                    System.out.println("Длинна твоего слова не совпадает с длинной загаданного слова. Попробуй еще:");
            }
        }


    }

}
