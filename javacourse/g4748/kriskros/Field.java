/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 03-Dec-2022 
*/

package edu.javacourse.g4748.kriskros;/*
Programmed by Sergii Kozhushko
*/

public class Field {
    public Cell[][] cells;
    public int fieldSize;

    //default Field Class initializer

    Field(int fs){
        fieldSize = fs;
        cells = new Cell[fieldSize][fieldSize];
        for (int i = 0; i < fieldSize; i++){
            for (int j = 0; j <fieldSize; j++){
                cells[i][j] = new Cell(i, j);
                //cells[i][j].setState(0);//Set up zero state to all fields
            }
        }


    }

    public void drawField(){
        //System.out.println("  1  2  3");
        for (int i = 0; i < fieldSize; i++){
            System.out.print("  " + (i+1));
        }
        System.out.println();

        for (int i = 0; i < fieldSize; i++){

            for (int j = 0; j < fieldSize; j++){
                if (j == 0) System.out.print((i+1)+" ");
                System.out.print(cells[i][j].getStateSymbol()+"  ");
                if (j == fieldSize - 1) System.out.println();

            }
        }

    }

    public static void main(String[] args) {
        Field field = new Field(3);
        field.cells[1][1].setState(1);
        field.cells[2][1].setState(2);
        field.drawField();
        field.drawField();
        //boolean
    }

}
