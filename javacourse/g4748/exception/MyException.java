/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 28-Nov-2022 
*/

package edu.javacourse.g4748.exception;/*
Programmed by Sergii Kozhushko
*/

import java.util.Random;
/*создаем классы собственных исключений. Одно простое, второе получает два аргумента, индекс элемента, который вызвал исключние
*/

class ArraySizeException extends Exception {}
class ArrayDataException extends Exception {
    private int i;
    private int j;
    ArrayDataException (int i, int j){
        this.i = i;
        this.j = j;
    }
    public int getI() { return i; }

    public int getJ() { return j; }
}
public class MyException {

    public float averageColumnArray(String[][] strArray) throws ArraySizeException, ArrayDataException {
        /* Метод считает среднее каждого столбца квадратного массива. Возвращает среднее всех элементов массива

         */
        if (strArray.length != 10) throw new ArraySizeException();
        float sum = 0;// сумма всех элементов массива
        float[] resArray = new float[10];//массив для подсчета суммы элементов столбца

        for (int i = 0; i < strArray.length; i++){

            for (int j = 0; j < strArray[i].length; j++) {
                System.out.print(strArray[i][j] + "     ");

                try {
                    sum += Float.parseFloat(strArray[j][i]);
                } catch (NumberFormatException e){
                    throw new ArrayDataException(j, i);
                }
                try {
                    resArray[j] += Float.parseFloat(strArray[i][j]);
                } catch (NumberFormatException e){
                    throw new ArrayDataException(i, j);
                }

            }
            System.out.println();
        }
        //Выводим среднее значение каждого столбца
        for (float d: resArray) {
            System.out.print(Float.toString(d/10)+"   ");

        }

    return sum / 100;
    }
    public static void main(String[] args) {
        MyException mye = new MyException();

        Random random = new Random();
        //Чтобы вызвать исключение поменяйте в коде размер массива 10 на другое число
        String[][] strArray = new String[10][10];

        //Заполняем массив рандомно
        for (int i = 0; i < strArray.length; i++) {
            for (int j = 0; j < strArray[i].length; j++) {
                strArray[i][j] = String.valueOf(random.nextInt(10));
            }
          }
        //Вводим в массив значение, которое должно вызвать исключение
        //strArray[7][6] = "a";
        try {
            System.out.println("\nAverage to all array is: "+String.valueOf(mye.averageColumnArray(strArray)));
        } catch (ArraySizeException e1) {
            System.out.println("ArraySizeException catched: Массив не состоит из 10 элементов");
        } catch (ArrayDataException e2){
            System.out.println("\nArrayDataException catched: Элемент массива["+ e2.getI() + "][" + e2.getJ() +"] содержит строку-не дробное число");
        }

    }
}
