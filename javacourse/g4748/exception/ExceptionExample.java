package edu.javacourse.g4748.exception;/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 24-Nov-2022 
*/

 /*
Programmed by Sergii Kozhushko
*/

import java.io.File;
import java.util.Scanner;

public class ExceptionExample {

    private static int devByZero(int a, int b){
        return a / b;
    }
    static void func1(){
        try {
            throw new Exception();

        } catch (Exception e) {
            System.out.println("Stack:");
            for (StackTraceElement ste : e.getStackTrace()) {

                System.out.println(ste.getMethodName()+" "+ ste.hashCode());
            }


        }
    }
    static void func2(){
        func1();
    }
    static void func3(){
        func2();
    }
    static void func4(){
        func3();
    }

    public static void main(String[] args) {
        //func4();
        //func3();
        //System.out(0);
        int counter = 0;
//        try {
//            Scanner scanner = new Scanner(new File("files/some.txt"));
//        }
//            catch () {
//
//        }
//        while (scanner.hasNext()){
//                    System.out.println(scanner.nextLine());
//                    counter++
//        }
//        scanner.close();


        try {
            devByZero(3, 0);
        }
        catch (IndexOutOfBoundsException | NullPointerException | UnsupportedOperationException exception){
            System.out.println("Someth wrong 1");

        }

        catch (ArithmeticException exception) {
            System.out.println("Не дели на ноль");
        }
        finally {
            System.out.println("All bad");
        }


    }

}
