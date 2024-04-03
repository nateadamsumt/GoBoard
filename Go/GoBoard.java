package Go;
import java.util.Scanner;

public class GoBoard {
    static boolean[][] lives = new boolean[9][9];
    static boolean[][] territory = new boolean[9][9];
    static boolean[][] beenChecked = new boolean[9][9];

    public static void main(String[] args) {
        String[][] board = new String[10][10];
        Scanner scn = new Scanner(System.in);
        boolean cont = true;
        System.out.println("");

        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        while (cont) {
            for (int i = 0; i < board.length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == null) {
                        if (j == 0 || j == 9) {
                            System.out.print("|");
                        } else {
                            System.out.print("＋");
                        }
                    } else {
                        System.out.print(board[i][j]);
                    }
                }
                System.out.println();
            }
                //add in board bounds here to fix shit
            System.out.println("Black Piece Turn: ◯ ");
            System.out.print("Please enter the x coordinate of your move:");
            int moveX = scn.nextInt();
            System.out.print("Please enter the y coordinate of your move:");
            int moveY = scn.nextInt();
            board[moveX][moveY] = "◯ ";
            //currently is line breaking the row, find fix?, using white piece for clarity
            System.out.println();
        }
        scn.close();

    }
}
//" ◯ ";
//" ● ";

//to do
/*
 * create board bounds
 * capture peices (one or many)
 * basic scoring piece
 * (one of these 2 must recurse)
 * 
 */