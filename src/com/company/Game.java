package com.company;


import java.util.Scanner;

public class Game {
    private Point[][] table = new Point[20][20];
    private int playerTurn;
    private int a, b;
    private boolean isOn;

    Game(){
        this.playerTurn=1;
    }
    void setTable(){
        System.out.println("Enter size:");
        boolean isTrue = false;
        int q=0,p=0;
        while(!isTrue) {
            Scanner scanner = new Scanner(System.in);
            q = scanner.nextInt();
            p = scanner.nextInt();
            if ((q > 20 || p > 20) || (q < 3 || p < 3)) {
                System.out.println("Invalid size");
                continue;
            } else {
                isTrue = true;
                setA(q);
                setB(p);
            }


        }
            for (int i = 0; i < getA(); i++) {
                for (int j = 0; j < getB(); j++) {
                    Point point = new Point(i, j, '.');
                    this.table[i][j] = point;
                }
            }

    }

    void showTable(){
        for (int i=0; i<getA();i++){
            for(int j=0; j<getB();j++){
                System.out.print(this.table[i][j].getSymbol());
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    void playGame(){
        this.isOn=true;
        while(isOn){
            System.out.println("Next player: choose a spot");
            boolean isTrue = false;
            int n=0,m=0;
            while (!isTrue) {
                Scanner sc = new Scanner(System.in);
                n = sc.nextInt();
                m = sc.nextInt();
                if (n>this.a || m>this.b){
                    System.out.println("Invalid numbers");
                    continue;
                }
                if (this.table[n - 1][m - 1].isPlayed()) {
                    System.out.println("Choose another spot");
                }else{
                    isTrue=true;
                }
            }
            if (this.playerTurn==1){
                this.table[n-1][m-1].changeSymbol('X');
                this.table[n-1][m-1].setPlayed(true);
                this.playerTurn=2;
            }else {
                this.table[n-1][m-1].changeSymbol('O');
                this.table[n-1][m-1].setPlayed(true);
                this.playerTurn=1;
            }
            showTable();
            if(checkIfThreeInRow()){
                isOn=false;
                System.out.println("Game over");
            }
            if (checkIfThreeInColumn()){
                isOn=false;
                System.out.println("Game over");
            }
            if (checkIfThreeInDiagonal()){
                isOn=false;
                System.out.println("Game over");
            }
            if (checkIfThreeInReverseDiagonal()){
                isOn=false;
                System.out.println("Game over");
            }

        }
    }

    boolean checkIfThreeInRow(){
        for (int i=0;i<this.a;i++){
            for (int j=0; j<this.b-2;j++){
                if(this.table[i][j].getSymbol() == this.table[i][j+1].getSymbol() &&
                        this.table[i][j].getSymbol()==this.table[i][j+2].getSymbol() &&
                        (this.table[i][j].getSymbol()=='X' ||this.table[i][j].getSymbol()=='O')){
                    if (this.playerTurn==1) {
                        System.out.println("Player 2 won!");
                    }
                    if (this.playerTurn==2) {
                        System.out.println("Player 1 won!");
                    }
                    return true;

                }
            }
        }
        return false;
    }
    boolean checkIfThreeInColumn(){
        for (int i=0;i<this.a-2;i++){
            for (int j=0; j<this.b;j++){
                if(this.table[i][j].getSymbol() == this.table[i+1][j].getSymbol() &&
                        this.table[i][j].getSymbol()==this.table[i+2][j].getSymbol() &&
                        (this.table[i][j].getSymbol()=='X' ||this.table[i][j].getSymbol()=='O')){
                    if (this.playerTurn==1) {
                        System.out.println("Player 2 won!");
                    }
                    if (this.playerTurn==2) {
                        System.out.println("Player 1 won!");
                    }
                    return true;

                }
            }
        }
        return false;
    }
    // C:\Users\а38100\IdeaProjects\TicTacToe\src\com\company\Game.java
    boolean checkIfThreeInDiagonal(){
        for (int i=0;i<this.a-2;i++){
            for (int j=0; j<this.b-2;j++){
                if(this.table[i][j].getSymbol() == this.table[i+1][j+1].getSymbol() &&
                        this.table[i][j].getSymbol()==this.table[i+2][j+2].getSymbol() &&
                        (this.table[i][j].getSymbol()=='X' ||this.table[i][j].getSymbol()=='O')){
                    if (this.playerTurn==1) {
                        System.out.println("Player 2 won!");
                    }
                    if (this.playerTurn==2) {
                        System.out.println("Player 1 won!");
                    }
                    return true;

                }
            }
        }
        return false;
    }
    boolean checkIfThreeInReverseDiagonal(){
        for (int i=0;i<this.a-2;i++){
            for (int j=this.b-1; j>1;j--){
                if(this.table[i][j].getSymbol() == this.table[i+1][j-1].getSymbol() &&
                        this.table[i][j].getSymbol()==this.table[i+2][j-2].getSymbol() &&
                        (this.table[i][j].getSymbol()=='X' ||this.table[i][j].getSymbol()=='O')){
                    if (this.playerTurn==1) {
                        System.out.println("Player 2 won!");
                    }
                    if (this.playerTurn==2) {
                        System.out.println("Player 1 won!");
                    }
                    return true;

                }
            }
        }
        return false;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    private class Point{
        private int x;
        private int y;
        private char symbol;
        private boolean isPlayed;

        Point(int x, int y, char symbol){
            this.x=x;
            this.y=y;
            this.symbol=symbol;
            this.isPlayed=false;
        }

        public void setPlayed(boolean played) {
            isPlayed = played;
        }

        public boolean isPlayed() {
            return isPlayed;
        }


        public char getSymbol() {
            return symbol;
        }
        public void changeSymbol(char S){
             this.symbol=S;
        }
    }
}
