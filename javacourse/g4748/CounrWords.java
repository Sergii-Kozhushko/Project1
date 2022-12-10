/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 01-Dec-2022 
*/

package edu.javacourse.g4748;/*
Programmed by Sergii Kozhushko
*/

import java.util.Scanner;


public class CounrWords {

    public static int countW(String s){
        s = s.trim();
        char[] ch = s.toCharArray();
        int count = 0;
        if (ch.length != 0) count = 1;
        for (int i = 0; i <s.length(); i++){
            if (ch[i] == ' ') count++;
        }
        return count;

    }


    public static void main(String[] args) {
        System.out.println("Enter the word:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("The number of words is: "+countW(str));
    }
}
