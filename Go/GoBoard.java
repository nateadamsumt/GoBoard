package Go;

import java.util.Scanner;

public class GoBoard {

    public static void main(String[] args) {
        String[][] Board = new String[10][10];
        Scanner myObj = new Scanner(System.in);
        Boolean cont = true;

        System.out.println(" 0 1 2 3 4 5 6 7 8 9");
        while (cont) {
            for (int i = 0; i < Board[0].length; i++) {
                System.out.print(i + " ");
                for (int j = 0; j < Board.length; j++) {
                    if (Board[i][j] == null) {
                        if (j == 0) {
                            System.out.print("|");
                        } else {
                            System.out.print("-|");
                        }

                    } else {
                        System.out.println();
                    }

                }
                System.out.println();
            }

            System.out.println("Black Piece Turn: ◯ ");
            System.out.print("Please enter the x coordinate of your move:");
            int moveX = myObj.nextInt();
            System.out.print("Please enter the y coordinate of your move:");
            int moveY = myObj.nextInt();
            System.out.println();
        }
    }
}
        // go pieces ◯ ●
        // Board[9][9] = "◯";
        // Board[9][8] = "●";
