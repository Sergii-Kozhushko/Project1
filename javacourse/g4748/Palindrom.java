/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 30-Nov-2022 
*/

package edu.javacourse.g4748;/*
Programmed by Sergii Kozhushko
*/

import java.util.Arrays;
import java.util.Scanner;

public class Palindrom {
    private static boolean ifStringPalindrom(String s){
        char chArray[] = s.toCharArray();
        for (int i = 0; i < chArray.length; i++){
            if (chArray[i] != chArray[chArray.length-i-1]) return false;
        }
        return true;
    }

    private static String maxStringInArray(String[] s){
        if (s.length == 0) return "";
        String s1=s[0];
        for (int i = 1; i < s.length; i++){
            if (s[i].length() > s1.length()) s1 = s[i];
        }
        return s1;
    }


    private static void countChars(String s){
        if (s.length()==0) return;
        System.out.println("Analyzing word '" +s+"':");
        char[] ch1 = s.toCharArray();
        //char[] ch = new сhar[s.length];
        //s.
        int count;
        boolean isCharChecked;
        for (int i = 0; i < ch1.length; i++){
            count = 0;
            /*цикл считает вхождение символа встроку*/
            for (int j = i; j < ch1.length; j++){
                if (ch1[j] == ch1[i]) count++;
            }
            /*теперь определяем не считали ли мы уже этот символ до этого*/
            isCharChecked = false;
            for (int k = 0; k < i; k++)
                if (ch1[k] == ch1[i]) isCharChecked = true;
            if (!isCharChecked) System.out.println("Char '"+ch1[i]+"' is "+count+" times");
        }

    }

    public static void main(String[] args) {
       /*1. Палиндром*/
//        String s = "bbbb";
//        Scanner sc = new Scanner(System.in);
//        while (!s.equals("q")) {
//            System.out.print("Enter the word please ('q' to quit): ");
//            s = sc.nextLine();
//            System.out.println("The word '" + s + "' is " + ((ifStringPalindrom(s)) ? "palindrom" : "not palindrom"));
//        }

        /*2.Поиск самой длинной строки в массиве
                 */
        String[] sArray = new String[] {"1ab11", "2222", "3333", "6666666"};
        System.out.println("The longest String in array " + Arrays.toString(sArray) + " is "+maxStringInArray(sArray));

        /*3. Считаем буквы в строке*/
        countChars("qdwdwdeeee");

    }

}
