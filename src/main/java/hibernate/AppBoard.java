package hibernate;

import java.util.Scanner;

public class AppBoard {
        Scanner scanner = new Scanner(System.in);

StringBuilder sb= new StringBuilder(30);
String[][]board =
        {{"+","------------------------------","+"},
         {"|","         SDA BANK APP         ","|"},
                {"+","------------------------------","+"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"|","                              ","|"},
                {"+","------------------------------","+"}};


public static void printBoard(String[][]board){
    for(String[]row:board){
        for(String s:row){
            System.out.print(s);
        }
        System.out.println();
    }
}

    public AppBoard() {
    }
    public void rowOne(){
        String rowunu="xxxxx2";
        rowunu.concat("xxx2");
        System.out.println("xxxxxxx1"+rowunu);
        printBoard(board);
    }

}