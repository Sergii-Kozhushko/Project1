package edu.javacourse.g4748;/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 20-Nov-2022 
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysMore {
    private static int stringCompare(String s1, String s2){
        //метод сравнивает две строки по алфавиту. Если первая строка раньше по алфавиту,
        // то возвращает 1, если вторая 2, если равны, то 0
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int i=0;
        while (i < (s1.length()>s2.length()? s2.length() : s1.length())) {
             if (s1.charAt(i) != s2.charAt(i)) {
                 if (s1.charAt(i) > s2.charAt(i)) return 2;
                 else return 1;
             }
             i++;

        }
        return 0;

    }
    private static String[] sortStringArray(String [] arrayString){
        //метод сортирует массив строк
        boolean areWeFinished = false;
        String str1, str2;
        while (!areWeFinished) {
            areWeFinished = true;
            for (int i = 0; i < arrayString.length-1; i++) {
                if (stringCompare(arrayString[i], arrayString[i+1])==2) {
                    // если мы нашли несортированные элементы, то
                    // поменять их местаим и следует начать проверку массива сначала
                    str1 = arrayString[i];
                    arrayString[i] = arrayString[i+1];
                    arrayString[i+1] = str1;
                    areWeFinished = false;
                }
            }
        }
        return arrayString;
    }
    private static int maxValueArray(int [] arr1){
        int max = arr1[0];
        for (int i:arr1){
            if (i > max ) max = i;
        }
        return max;
    }

    private static int minValueArray(int [] arr1){
        int min = arr1[0];
        for (int i:arr1){
            if (i < min ) min = i;
        }
        return min;
    }
    private static double avgValueArray(int [] arr){
        int sum = 0;
        for (int i:arr){
            sum += i;
        }
        return (double) sum / arr.length;
    }
    public static int [] deleteNumFromArray(int [] arr, int num){
        int temp;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == num){
                if (i != arr.length-1){
                    //arr[i] = arr[i+1];
                    for (int j=i;j < arr.length-1; j++){
                        temp = arr[j];
                        arr[j] = arr[j+1];
                    }
                    arr[arr.length-1] = 0;

                }
                else arr[i] = 0;
            }
        }
        return arr;
    }
    //
    private static int findStrInArray(String [] str, String toFind){
        int n = 0;
        for (int i = 0 ; i <str.length; i++){
            if (str[i].indexOf(toFind) != -1) n++;
        }
        return n;
    }


    public static void main(String[] args) {
        //1. Сортировка массива строк по афлавиту
        String[] str = {"ypsilon", "aa", "cat", "dog", "Bibop", "oma","Bibika"};

        System.out.print("Alphabetically sorted String array: ");
        for (String i : sortStringArray(str)){
            System.out.print(i+" ");
        }
        System.out.println();


        //2. Нахождение макс, мин, ср значения в инт-массиве
        int [] arr1 = {1, 2, 3, 4, 5, 10};
        System.out.println("Max Value " + maxValueArray(arr1));
        System.out.println("Min Value " + minValueArray(arr1));
        System.out.println("Avg Value " + avgValueArray(arr1));

        //5. Удаление заданного числа из массива
        System.out.println(Arrays.toString(deleteNumFromArray(arr1,2)));

        //4.Нахождение заданной строки в массиве строк
        String wordToFind = "Bib";
        System.out.println("Word `" + wordToFind + "` was founded " + findStrInArray(str,wordToFind) +" times in array " + Arrays.deepToString(str));


    }
}
