/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 03-Dec-2022 
*/

package edu.javacourse.g4748.kriskros;/*
Programmed by Sergii Kozhushko
*/

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    public Field field;
    boolean firstMoveComp;
    boolean nowCompMove; //true - сейчас ход компа, false - сейчас ход человека
    boolean areWePlay;
    int moveCount;

    int winnerState; //0 - икто не выиграл, 1 - компьютер выиграл, 2 - выиграл человек
    Game(){
        field = new Field(3);
        areWePlay = false;
        moveCount = 1;
    }

    //Проверяем является ли строка числом
    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void showInitMessage(){
        int firstMove = 1;
        System.out.println("Игра " +"\u001B[35m"+"крестики"+"\u001B[30m-"+"\u001B[36m"+"нолики");
        System.out.print("\u001B[0m");
        System.out.print("Выберите кто будет ходить первым (1 - компьютер (o), 2 - человек(x)): ");
        Scanner sc1 = new Scanner(System.in);
        try {
            firstMove = sc1.nextInt();
        } catch (InputMismatchException e){
            System.out.println("Выберите 1 или 2");
            showInitMessage();
        }
        if (firstMove != 1 && firstMove != 2){
            System.out.println("Выберите 1 или 2");
            showInitMessage();
        }
        firstMoveComp = firstMove == 1;
    }

    public boolean isCompWon(){
        //****Проверяем победил ли компьютер
        //строчки
        if (field.cells[0][0].isO() && field.cells[1][0].isO() && field.cells[2][0].isO()) {

            return true;
        }
        if (field.cells[0][1].isO() && field.cells[1][1].isO() && field.cells[2][1].isO()) {

            return true;
        }
        if (field.cells[0][2].isO() && field.cells[1][2].isO() && field.cells[2][2].isO()) {

            return true;
        }
        //столбики
        if (field.cells[0][0].isO() && field.cells[0][1].isO() && field.cells[0][2].isO()) {

            return true;
        }

        if (field.cells[1][0].isO() && field.cells[1][1].isO() && field.cells[1][2].isO()) {

            return true;
        }
        //диагонали

        if (field.cells[0][0].isO() && field.cells[1][1].isO() && field.cells[2][2].isO()) {

            return true;
        }
        if (field.cells[2][0].isO() && field.cells[1][1].isO() && field.cells[0][2].isO()) {

            return true;
        }
        return false;
    }

    public boolean isHumanWon(){
        //**** Провереям победил ли человек
        if (field.cells[0][0].isX() && field.cells[1][0].isX() && field.cells[2][0].isX()) {

            return true;
        }
        if (field.cells[0][1].isX() && field.cells[1][1].isX() && field.cells[2][1].isX()) {

            return true;
        }
        if (field.cells[0][2].isX() && field.cells[1][2].isX() && field.cells[2][2].isX()) {

            return true;
        }
        //столбики
        if (field.cells[0][0].isX() && field.cells[0][1].isX() && field.cells[0][2].isX()) {

            return true;
        }

        if (field.cells[1][0].isX() && field.cells[1][1].isX() && field.cells[1][2].isX()) {

            return true;
        }
        //диагонали

        if (field.cells[0][0].isX() && field.cells[1][1].isX() && field.cells[2][2].isX()) {

            return true;
        }
        if (field.cells[2][0].isX() && field.cells[1][1].isX() && field.cells[0][2].isX()) {

            return true;
        }
        return false;

    }
    public boolean checkWinner() {
        //метод вовзращает true если появился победитель

        if (isCompWon()) {
            winnerState = 1;
            return true;
        }
        if (isHumanWon()) {
            winnerState = 2;
            return true;
        }
        return false;

    }

    public void decideCompMove(){
        //Проверяем вдруг есть выигрышная комбинация  у компа
        for (int i = 0; i < field.fieldSize; i++){
            for (int j = 0; j <field.fieldSize; j++)
                if (field.cells[i][j].isFree()) {
                    field.cells[i][j].setStateNolik();
                    if (isCompWon()) return;
                    else field.cells[i][j].setStateFree();

                }
        }
        //Проверяем есть ли выигрышная комбинация у человека и ставим туда нолик
        for (int i = 0; i < field.fieldSize; i++){
            for (int j = 0; j <field.fieldSize; j++)
                if (field.cells[i][j].isFree()) {
                    field.cells[i][j].setStateKrestik();
                    if (isHumanWon()) {
                        field.cells[i][j].setStateNolik();
                        nowCompMove = false;
                        return;
                    }
                    else field.cells[i][j].setStateFree();

                }
        }

        //проверяем центр
        if (field.cells[1][1].getState() == 0){
            field.cells[1][1].setStateNolik();
            nowCompMove = false;
            return;
        }

        if (field.cells[0][0].isFree()) {
            field.cells[0][0].setStateNolik();
            nowCompMove = false;
            return;
        }

        if (field.cells[0][2].isFree()) {
            field.cells[0][2].setStateNolik();
            nowCompMove = false;
            return;
        }

        if (field.cells[2][0].isFree()) {
            field.cells[2][0].setStateNolik();
            nowCompMove = false;
            return;
        }

        if (field.cells[2][2].isFree()) {
            field.cells[2][2].setStateNolik();
            nowCompMove = false;
            return;
        }

        nowCompMove = false;

    }


    public boolean isCorrectXY(String s){
        //проверка корректно ли введегы координаты хода
        String s1, s2;
        if (s.length() != 2) return false;
        s1 = s.substring(0,1);
        s2 = s.substring(1,2);
        if (!isDigit(s1) || !isDigit(s2)) return false;
        if (Integer.parseInt(s1) > 3) return false;
        if (Integer.parseInt(s2) > 3) return false;
        return true;
    }

    public void mainCycle(){
        areWePlay = true;

        nowCompMove = firstMoveComp;
        Scanner sc1 = new Scanner(System.in);
        String moveString;
        int xHuman, yHuman;

        while (areWePlay){
            field.drawField();
            if (nowCompMove) decideCompMove();
            else {
                //ход человека
                System.out.println();
                System.out.print("Введите свой ход в формате 'столбик ряд' (без кавычек): ");
                moveString = sc1.nextLine();
                if (!isCorrectXY(moveString)) {
                    System.out.println("Вы ввели неверные координаты");
                    moveCount--;
                }
                else {
                    yHuman = Integer.parseInt(moveString.substring(0,1));
                    xHuman = Integer.parseInt(moveString.substring(1,2));

                    if (field.cells[xHuman - 1][yHuman - 1].getState() != 0) {
                        //попытка поставить крестик на занятую клетку
                        System.out.println("Эта клетка занята. Введите другие координаты");
                        moveCount--;
                    } else {
                        field.cells[xHuman - 1][yHuman - 1].setStateKrestik();
                        nowCompMove = true;
                    }
                }
            }
            if (checkWinner()) {
                areWePlay = false;
                if (winnerState == 1) {
                    field.drawField();
                    System.out.println("\u001B[36m" + "Победил компьютер!");
                }
                if (winnerState == 2) System.out.println("\u001B[36m" + "Победил человек!");
            }

            if (moveCount == 10) {
                field.drawField();
                System.out.println("\n\u001B[36m" + "Ничья!");
                areWePlay = false;
            }
            moveCount++;

        }
    }

    public static void main(String[] args) {
        Game game1 = new Game();
        game1.showInitMessage();
        //game1.field.cells[0][0].setStateKrestik();
        game1.mainCycle();
    }
}
