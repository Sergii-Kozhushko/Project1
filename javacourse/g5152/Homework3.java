/**
 * Homework3.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 10-Dec-2022 15:42
 */

package edu.javacourse.g5152;

import java.util.Random;
import java.util.Scanner;

public class Homework3 {


   /**
    * Second Level, Задача 3, 4. Траффик-2. Пропсук в город по четности номера, дню недели и виду автомобиля
    */
   public static void traffic2() {
      boolean doAsk = true;
      Scanner scanner = new Scanner(System.in);
      boolean isLorry;
      boolean isWeekend;
      int num;
      String str;
      while (doAsk) {
         System.out.print("Введите номер машины от 1 до 10 000 (0 - выход): ");
         num = scanner.nextInt();
         if (num == 0) {
            doAsk = false;
            break;
         }
         System.out.print("Это грузовик(1) или легковая машаина(2)? (Ввведите 1 или 2): ");
         if (scanner.nextInt() == 1) isLorry = true;
         else isLorry = false;
         System.out.print("Выходной(1) или будний день(2): ");
         isWeekend = scanner.nextInt() == 1;
         if (isWeekend) {
            if (!isLorry) {
               if (num % 2 == 0) str = "Машина может проехать!";
               else str = "Машина не может проехать. В выходные машина с нечетным номером не может заехать.";
            }
            else str = "Машина не может проехать. Грузовым машинам запрещен въезд в город на выходные дни.";
         }
         else if (isLorry){
            str = "Машина может проехать!";
         }
         else if (num % 2 != 0) str = "Машина может проехать!";
         else str = "Машина не может проехать. В будние легковые машины с четными номерами не могут въехать в город.";

         System.out.println(str);
      }
   }


   /**
    * Second Level, Задача 2. Секунды в часы
    */
   public static void sec2Hours(){
      int sec;
      Random r = new Random();
      sec = r.nextInt(28801);
      int hours = sec / 3600;
      String hStr = switch (hours) {
         case 0 -> "менее часа";
         case 1 -> "один час";
         case 2 -> "два часа";
         case 3 -> "три часа";
         case 4 -> "четыре часа";
         case 5 -> "пять часов";
         case 6 -> "шесть часов";
         case 7 -> "семь часов";
         case 8 -> "восемь часов";

         default -> "";
      };
      System.out.println("До конца рабочего дня осталось " + sec + " секунд или " + hStr);
   }

   /**
    * Second Level, Задача 1. Максимальное значение трех чисел
    */
   public static void maxFromThreeNumbers(){
      Scanner scanner = new Scanner(System.in);
      int n1, n2, n3, max;
      System.out.print("Введите первое число: ");
      n1 = scanner.nextInt();
      System.out.print("Введите второе число: ");
      n2 = scanner.nextInt();
      System.out.print("Введите третье число: ");
      n3 = scanner.nextInt();
      if (n1 > n2){
         if (n1 > n3) max = n1;
         else max = n3;
      } else if (n2 > n3) {
         max = n2;
      }
      else max = n3;

      System.out.println("Макс. число: " + max);


   }


   /**
    * 5. Ограничение на вьезд в город: не пускать машины с нечетными номерами и все грузовики
    */
   public static void traffic() {
      boolean doAsk = true;
      Scanner scanner = new Scanner(System.in);
      boolean isLorry;
      int num;
      while (doAsk) {
         System.out.print("Введите номер машины от 1 до 10 000 (0 - выход): ");
         num = scanner.nextInt();
         if (num == 0) {
            doAsk = false;
            break;
         }

         System.out.print("Это грузовик(1) или легковая машаина(2)? (Ввведите 1 или 2) ");
         if (scanner.nextInt() == 1) isLorry = true;
         else isLorry = false;
         if (!isLorry && num % 2 == 0) {
            System.out.println("Эту машину пропускаем в город\n");
         } else {
            System.out.println("Эту машину НЕ пропускаем в город\n");
         }
      }
   }


   /**
    * 4. Орел-решка
    */
   public static void orelReshka(){
      Random r2 = new Random();
      Scanner sc3 = new Scanner(System.in);
      String st = "y";
      while (st.equals("y")){
         if (r2.nextBoolean()) {
            System.out.println("Выпала решка. Продолжить? (y/n) ");
         }
         else {
            System.out.println("Выпал орел. Продолжить? (y/n) ");
         }
         st = sc3.nextLine();
      }
   }

   /**
    * 3. Задача о печеньках
    */
   public static void  cookies(){
      final float PRICE_COOKIES = 0.5f;
      Scanner scanner = new Scanner(System.in);
      System.out.print("Сколько печенья Вы хотите купить? ");
      int amountCookies = scanner.nextInt();
      System.out.print("Сколько у вас есть денег в EUR? (центы вводите через точку) ");
      float sumMoney = scanner.nextFloat();

      if (sumMoney < amountCookies * PRICE_COOKIES) {
         System.out.println("Этой суммы недостаточно");
      } else {
         /**
          * Округление сдачи. Если ввести 10 печенек и сумму 5.2 евро, то считает сдачу 0,199999981
          */
         double sdacha = (double)Math.round( (sumMoney - (amountCookies * PRICE_COOKIES)) * 100)/100;
         System.out.println("Все нормально, брат. Держи твои печеньки и сдачу " + sdacha +" EUR");
      }
   }

   /**
    * 2. Метод определяет является ли случайный год высокосным
    */
   public static void leapYear(){
      Random r = new Random();
      int year = r.nextInt(2022);
      System.out.print("Случаный год: " + year);
      if (year % 4 == 0) System.out.println(" - высокосный");
      else System.out.println(" - не высокосный");
   }


   public static String isAllowedAdultContent(int age){
      if (age >= 18) return "Я вам конечно не верю. Но вам смотреть это кино можно :)";
      else return "Вы несовершеннолетний. Вам нельзя смотреть это кино";
   }

   /**
    * 1. Вывод сообщения о том, можно ли смотреть кино до 18 лет
    *
    */
   public static void adultContent(){
      Scanner scanner = new Scanner(System.in);
      System.out.print("Введите свой возврат: ");
      int age = scanner.nextInt();
      System.out.println(isAllowedAdultContent(age));
   }


   public static void main(String[] args) {

      //1.
      //adultContent();

      //2. Высокосный год
      //leapYear();

      //3. Печенье
      //cookies();

      //4. Орел-решка
      //orelReshka();

      //5. Траффик
      //traffic();

      //*.1
      //maxFromThreeNumbers();
      //*2. Сколько часов до конца рабочего дня?
      // sec2Hours();

      //* 3,4 Траффик
      traffic2();



   }

}
