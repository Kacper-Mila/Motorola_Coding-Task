import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Memory {
    public static String [][] board = new String[2][4];
    public static String [][] cards = new String [2][4];
    public static Scanner scanner = new Scanner(System.in);

    public static void renderBoard(){
        for(int i = 0; i<4; i++){
            System.out.print("|");
            for(int j = 0; j<2; j++){
                System.out.print(board[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void shuffle(){
        Random random = new Random();
        ArrayList<String> words = new ArrayList<String>();
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("D");
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("D");

        int index;
        for(){}

    }

}
