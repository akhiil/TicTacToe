// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class TicTacToe {
    static String current;
    static String[] board;
    static String checkWinner() {
        String[] arr = new String[8];
        arr[0] = "012";
        arr[1] = "345";
        arr[2] = "678";
        arr[3] = "036";
        arr[4] = "147";
        arr[5] = "258";
        arr[6] = "048";
        arr[7] = "246";
        
        for(int i=0; i<arr.length; i++) {
            int a = arr[i].charAt(0) - '0';
            int b = arr[i].charAt(1) - '0';
            int c = arr[i].charAt(2) - '0';
            
            if(board[a]==board[b] && board[a]==board[c]){
                System.out.println("winner: " + current);
                return "";
            }
        }
        return null;
    }
    static void printTicTac() {
        System.out.println("_____________");
        System.out.println("| "+ board[0] +" | "+ board[1] +" | "+board[2]+" |");
        System.out.println("-------------");
        System.out.println("| "+ board[3] +" | "+ board[4] +" | "+board[5]+" |");
        System.out.println("-------------");
        System.out.println("| "+ board[6] +" | "+ board[7] +" | "+board[8]+" |");
        System.out.println("-------------");
        System.out.println("Curent choice: " + current);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        current = "X";
        board = new String[9];
        String winner = null;
        for(int i=0; i<9; i++) {
            board[i] = String.valueOf(i+1);
        }
        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printTicTac();
        System.out.println("Type the number where you want to place your choice.");
        
        while(winner==null) {
            int numInput;
            try {
                 numInput = in.nextInt();
                 if(numInput>=10 || numInput<0) {
                System.out.println("Please write valid input");
                 printTicTac();
                 continue;
            }
            } catch(InputMismatchException e) {
                System.out.println("Invalid Input, please reneter");
                continue;
            }
           
                if(board[numInput-1]!="X" && board[numInput-1]!="O"){
                    board[numInput-1] = current;
                    current = current=="X" ? "O" : "X";
                    printTicTac();
                }else{
                    System.out.println("Please enter at empty place.");
                     printTicTac();
                     continue;
                }
                winner = checkWinner();
        }
    }
}
