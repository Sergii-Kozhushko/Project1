/**
 * HomeWorkWhile.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 25-Dec-2022 21:28
 */

package edu.javacourse.g5152;

import java.util.Scanner;

public class HomeWorkWhile {
   /*
   сломанный лифт
лифт, находящийся на первом этаже здания высотой H, должен подняться на последний этаж.
Лифт сломан. Каждый раз он поднимается на N этажей и спускается на M этажей.
Если на последнем подьеме лифт превысил колличество этажей,
то считается что лифт поднялся на самый верх.
Найдите количество подьемов, которые понадобятся лифту.

Ввод:
H = 200, N = 50, M = 1
Ответ: 5
    */
   static void lift(){
      Scanner scanner = new Scanner(System.in);
      int h, n, m, currentEtage = 1, count = 0;
      System.out.print("Введите количество этажей H: ");
      h = scanner.nextInt();
      System.out.print("Введите на сколько этажей лифт поднимается N: ");
      n = scanner.nextInt();
      System.out.print("Введите на сколько этажей лифт опускается M: ");
      m = scanner.nextInt();
      while (currentEtage < h){
         currentEtage += n;
         currentEtage -= m;
         count++;
      }
      System.out.println("Количество подъемов: " + count);

   }

   /* Проверка гипотезы Сиракуз
   Возьмем любое натуральное число. Если оно четное - разделим его пополам, если нечетное - умножим на 3, прибавим 1 и разделим пополам. Повторим эти действия с вновь полученным числом. Гипотеза гласит, что независимо от выбора первого числа рано или поздно мы получим 1.
*/
   static void siracus(){
      Scanner scanner = new Scanner(System.in);
      int number;
      System.out.print("Введите натруальное число: ");
      number = scanner.nextInt();
      while (number != 1){
         if (number % 2 == 0) number = number / 2;
         else {
            number = ((number*3) + 1) / 2;
         }
         System.out.println(number);
      }


   }

   /*
   5) Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех его цифр (заранее не известно сколько цифр будет в числе).
    */
   static void sumNumbers(){
      Scanner scanner = new Scanner(System.in);
      int number, sum = 0;
      System.out.print("Введите число: ");
      number = scanner.nextInt();
      while (number > 0){
         sum += number % 10;
         number = number / 10;
      }
      System.out.println("Сумма цифр числа: " + sum);


   }


   public static void main(String[] args) {
      //lift();
      //siracus();
      sumNumbers();

   }

}
