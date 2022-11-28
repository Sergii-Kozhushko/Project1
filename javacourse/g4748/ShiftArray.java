package edu.javacourse.g4748;

import java.util.Arrays;

/*
ДЗ:

1.Написать метод, который в качестве аргумента принимает одномерный массив целых чисел
и числа котрые делятся на три умножае на 2
2. метод переворачивает массив строк
3. Сдвиг массива на n  позиций, n  может быть отрицательным и положительным

 */
public class ShiftArray {
    private static void shiftArraySimple(int[] arr){
        int temp = arr[1];
        for (int i=0; i < arr.length - 1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1] = temp;
    }
    public static void main(String[] args) {
        int[] arr2 = {1, 9, 7, 8, 10, 14};
        shiftArraySimple(arr2);
        System.out.println(Arrays.toString(arr2));

    }
}
