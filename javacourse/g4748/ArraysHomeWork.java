package edu.javacourse.g4748;/*
   Programmed by Sergii Kozhushko 2022 Tel-Ran.DE
   Group 47-49
   Date of creation: 18-Nov-2022 13:36
*/

import java.util.Arrays;

public class ArraysHomeWork {
    private static void changeArray(int[] arrArg){
       //метод перебирает массив и, если значение эемента делится нацело на 3, умножает на 2,
       // если значение элемента делится нацело на 2, то умножает его на 3
        for (int i=0;i<arrArg.length;i++){
            int ostatok = arrArg[i];
            if (ostatok % 3 == 0) arrArg[i] = arrArg[i] * 2;
            if (ostatok % 2 == 0) arrArg[i] = arrArg[i] * 3;
        }
    }
    private static String[] upsideArray(String[] arrArg){
        String[] arrArgTemp = arrArg; //создаем копию массива-аргумента
        String temp;
        for (int i = 0; i < (arrArg.length / 2); i++){
            temp = arrArg[i];
            arrArg[i] = arrArgTemp[arrArg.length-i-1];
            arrArg[arrArg.length-i-1] = temp;
        }
        return arrArg;
    }

    private static int[] shiftIntArrayByN(int[] arr, int shiftNum){
        int[] temp = arr.clone();
        shiftNum %= arr.length;//если длинна массива 5,а нужно сдвинуть на 6, то сдвигаем на 1
        if (shiftNum > 0) {
            //сдвигаем сначала часть массива от конца влево
            for (int i = shiftNum; i < arr.length; i++) {
                arr[i - shiftNum] = arr[i];
            }
            //сдвигаем часть массива от начала до N в конец
            for (int i = 0; i < shiftNum; i++) {
                arr[arr.length - shiftNum + i] = temp[i];
            }
        }
        else {
            shiftNum = -shiftNum;
            for (int i = arr.length-1; i>=shiftNum; i--){
                arr[i] = arr[i-shiftNum];
            }
            for (int i = 0; i<shiftNum; i++){
                arr[i] = temp[arr.length-shiftNum+i];
            }
        }
        return arr;
    }



    public static void main(String[] args) {
//Задание 1. Умножение на 2 и на 3
        int[] array1 = {4, 89, 0, 6, 10, 20};
        changeArray(array1);
        System.out.println(Arrays.toString(array1));

//Задание 2. Поменять местами значения стринг массива
        String[] array2 = {"aa", "cat","dog", "tree","555", "few", "opa", "mama"};
        System.out.println(Arrays.toString(upsideArray(array2)));

//** Сдвиг миссива влево, если shiftNum положительный и вправо, если shiftNum  отрицательный
        int[] array3 = {1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(shiftIntArrayByN(array3,0)));
    }
}
