/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 01-Dec-2022 
*/

package edu.javacourse.g4748;/*
Programmed by Sergii Kozhushko
*/

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class TestArray {
    public static void main(String[] args) {
        int[] intArr = new int[8];
        Random r = new Random();
        for (int i = 0; i < intArr.length; i++){
            intArr[i] = r.nextInt(8);
            //System.out.print(k+" ");
        }
        System.out.println(Arrays.toString(intArr));

        for (int i = 0; i <intArr.length;i++){
            if (i % 2 == 0) intArr[i] = 0;
        }

        System.out.println(Arrays.toString(intArr));

    }

}
