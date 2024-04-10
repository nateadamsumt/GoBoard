package Go;

// Import Statements
import java.util.Scanner;

// Declaring the class
public class GoBoard {
    // Declaring the class wide items
    static String[][] board = new String[10][10];
    static int whitePoints = 0;
    static int blackPoints = 0;

    // Function to print the Go Board
    public static void printBoard() {
        System.out.println(" 1 2 3 4 5 6 7 8 9");
        for (int i = 0; i < board.length - 1; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < board[i].length - 1; j++) {
                if (board[i][j] == null) {
                    if (j == 0 || j == 8) {
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
    }

    //function to check if a piece is captured
    public static boolean checkForCaptures(int col, int row, String currentPlayerPiece) {

        boolean captured = false;

        if (col > 0 && board[col - 1][row] != null && !canBreathe(col - 1, row)) {
            captured = true;
            board[col - 1][row] = null;
        }
        if (col < board.length - 1 && board[col + 1][row] != null && !canBreathe(col + 1, row)) {
            captured = true;
            board[col + 1][row] = null;
        }
        if (row > 0 && board[col][row - 1] != null && !canBreathe(col, row - 1)) {
            captured = true;
            board[col][row - 1] = null;
        }
        if (row < board[col].length - 1 && board[col][row + 1] != null && !canBreathe(col, row + 1)) {
            captured = true;
            board[col][row + 1] = null;
        }
        return captured;
    }

    // Function to see if a Piece has any Liberties
    public static boolean canBreathe(int col, int row) {

        if (col > 0 && board[col - 1][row] == null) {
            return true;
        }
        if (col < board.length - 1 && board[col + 1][row] == null) {
            return true;
        }
        if (row > 0 && board[col][row - 1] == null) {
            return true;
        }
        if (row < board[col].length - 1 && board[col][row + 1] == null) {
            return true;
        }
        return false;
    }

   // Function to score points
    public static void updatePoints(String currentPlayerPiece){

    if (currentPlayerPiece.equals("◯ ") || currentPlayerPiece.equals("◯")) {
        blackPoints++;

    } else if (currentPlayerPiece.equals("● ") || currentPlayerPiece.equals("●")) {
        whitePoints++;
    }
}

    // Main Function to use these previous functions
    public static void main(String[] args) {

        boolean cont = true;
        boolean player_turn = true;

        Scanner scn = new Scanner(System.in);

        int max_length = board.length;
        int moveX;
        int moveY;

        //while look to continuously play the game
        while (cont) {

            printBoard();

            System.out.println("Black Points: " + blackPoints);
            System.out.println("White Points: " + whitePoints);

            System.out.println("Would you like to continue to play? Q to quit.");
            String quit = scn.nextLine();

            System.out.println("\n" + ((player_turn) ? "Black" : "White") + "'s turn\n\n");

            System.out.println("What row would you like to place your piece at " + ((player_turn) ? "Black" : "White") + " (or 0 to pass) ?");
            moveX = scn.nextInt();

            System.out.println("What column would you like to place your piece at " + ((player_turn) ? "Black" : "White") + " (or 0 to pass) ?");
            moveY = scn.nextInt();

            if (moveY == 0 || moveX == 0) {
                player_turn = !player_turn;
                continue;
            } else if (moveY > max_length || moveY < 0 || moveX > max_length || moveX < 0) {
                System.out.println("Out of Bounds");
                System.out.println();
                continue;
            } else {

                if (board[moveY - 1][moveX - 1] != null) {
                    System.out.println("There is already a piece there, please choose another space");
                    System.out.println();
                    continue;
                }

                board[moveY - 1][moveX - 1] = ((player_turn) ? "◯ " : "● ");

                if (checkForCaptures(moveX - 1, moveY - 1, ((player_turn) ? "● " : "◯ "))) {
                    System.out.println("Captured opponent's piece!");
                }
            }

            player_turn = !player_turn;

            if (quit.equalsIgnoreCase("q")) {
                break;
            }
        }
    }
}

//" ◯ ";
//" ● ";

//to do
/* 
 * capture of multiple pieces
 * scoring those captured pieces
 * quit statement
 * breathe for same kind of piece
 * 
 */