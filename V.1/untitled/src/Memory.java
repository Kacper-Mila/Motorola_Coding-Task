import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Memory {
    public static String [][] board = new String[4][4];
    public static String [][] cards = new String [4][4];
    public static Scanner scanner = new Scanner(System.in);

    public static void renderBoard(){
        for(int i = 0; i < 4; i++){
            System.out.print("|");
            for(int j = 0; j < 4; j++){
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
        words.add("E");
        words.add("F");
        words.add("G");
        words.add("H");
        words.add("A");
        words.add("B");
        words.add("C");
        words.add("D");
        words.add("E");
        words.add("F");
        words.add("G");
        words.add("H");

        int index;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                index = random.nextInt(words.size());
                cards[i][j] = words.get(index);
                words.remove(index);
            }
        }
    }

    public static void checkInput(String [][] cards){
        while(true){
            if(!gameOver()){
                System.out.println("Row: (1-4)");
                int row1 = scanner.nextInt();
                System.out.println("Column: (1-4)");
                int column1 = scanner.nextInt();

                if(!board[row1-1][column1-1].equals(" _ ")){
                    System.out.println("Already entered!!");
                    System.out.println();

                    renderBoard();
                    continue;
                }else{
                    board[row1-1][column1-1] = " " + cards[row1-1][column1-1] + " ";
                    renderBoard();
                }


                System.out.println("Row: (1-4)");
                int row2 = scanner.nextInt();
                System.out.println("Column: (1-4)");
                int column2 = scanner.nextInt();

                if(!board[row2-1][column2-1].equals(" _ ")){
                    System.out.println("Already entered!!");
                    board[row1-1][column1-1] = " - ";
                    System.out.println();

                    renderBoard();
                    continue;
                }else{
                    board[row2-1][column2-1] = " " + cards[row2-1][column2-1] + " ";

                    if(board[row1-1][column1-1].equals(board[row2-1][column2-1])){
                        renderBoard();
                        System.out.println("Correct!");
                    }else{
                        renderBoard();
                        System.out.println("Wrong!");
                        board[row1-1][column1-1] = " _ ";
                        board[row2-1][column2-1] = " _ ";
                        renderBoard();
                    }
                }
            }else{
                System.out.println("Game Over!!");
                break;
            }
        }
    }

    public static boolean gameOver(){
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j].equals(" _ ")){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        while(true){
            System.out.println("Press n for new game or q to quit...");
            String nq = scanner.nextLine();
            if(nq.equals("q")){
                System.out.println("Closing app...");
            }else if(nq.equals("n")){

                shuffle();
                for(int i = 0; i < 4; i++){
                    for (int j = 0; j < 4; j++) {
                        board[i][j] = " _ ";
                    }
                }

                renderBoard();
                checkInput(cards);
                break;

            }else{
                System.out.println("Invalid command");
                continue;
            }


        }
    }
}
