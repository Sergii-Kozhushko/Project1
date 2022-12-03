/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 01-Dec-2022 
*/

package edu.javacourse.g4748.kriskros;/*
Programmed by Sergii Kozhushko
*/

public class Cell {
    private int X;//
    private int Y;
    private int State;//состояние клетки, 0 - пустая, 1 - крестик, 2 - нолик

    public int getState(){
        return this.State;
    }

    public boolean isFree(){
        return State == 0;

    }
    public boolean isO(){
        return State == 2;
    }

    public boolean isX(){
        return State == 1;
    }
    public void setState(int s){
        if (s == 0 || s == 1 || s ==2) State = s;
    }

    public void setStateKrestik(){
        State = 1;
    }

    public void setStateNolik(){
        State = 2;
    }

    public void setStateFree(){
        State = 0;
    }


    public String getStateSymbol(){
        if (State == 0) return ".";
        if (State == 1) return "x";
        if (State == 2) return "o";
        return ".";
    }

    Cell(int x1, int y1){
        X = x1;
        Y = y1;
        State = 0;
    }


    public static void main(String[] args) {
        //Cell c1 = new Cell();

    }


}
