package Go;
import java.util.Scanner;

public class GoBoard {
    static boolean[][] lives = new boolean[9][9];
    static boolean[][] territory = new boolean[9][9];
    static boolean[][] beenChecked = new boolean[9][9];

    public static void main(String[] args) {

        boolean cont = true;
        boolean player_turn = true;
        String[][] board = new String[10][10];
        Scanner scn = new Scanner(System.in);
        System.out.println("");
        int max_length = board.length;
        int moveX;
        int moveY;

        while (cont){
            System.out.println(" 0 1 2 3 4 5 6 7 8 9");
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

            System.out.println("\n" + ((player_turn) ? "Black" : "White") + "'s turn\n\n");
        
        System.out.println("What row would you like to place your piece at " + ((player_turn) ? "Black" : "White") + " (or 00 to pass) ?");
        //black or white piece
        moveX = scn.nextInt();

        System.out.println("What column would you like to place your piece at " + ((player_turn) ? "Black" : "White") + " (or 00 to pass) ?");
        //black or white piece
        moveY = scn.nextInt();

        //prints players move
        if (moveY != 00 && moveX != 00){
            System.out.println(((player_turn) ? "Black" : "White") + " you placed your piece at: ");
            //+ where piece moved
            System.out.println(moveX + "," + moveY);
            System.out.println();
        }else{
            System.out.println(((player_turn) ? "Black" : "White") + " has passed on their turn");
            System.out.println();
        }
        
        //passing on players turn
        if (moveY == 00 || moveX == 00){
            player_turn = !player_turn;
            continue;
        
        }else if (moveY > max_length || moveY < 0 || (moveX > max_length || moveX < 0)){
            System.out.println("Out of Bounds");
            System.out.println();
            //System.out.println(max_length);
            //System.out.println();
            continue;

        //works for anything but not zero gives an index error
        } else{
            if ((moveY == 0) || (moveX == 0) ){
                System.out.println("Not a valid move please choose again");
                System.out.println();
                continue;

            }else if (board[moveY - 1][moveX - 1] == null){
                board[moveY - 1][moveX - 1] = ((player_turn) ? "-B" : "-W");

            }else {
                System.out.println("There is already a piece there, please choose another space");
                System.out.println();
                continue;
            }
        }
        
        player_turn = !player_turn;
    } 
        //out of player loop

    }    
    
}
//" ◯ ";
//" ● ";

//to do
/*
 * create board bounds !
 * capture peices (one or many)
 * basic scoring piece
 * (one of these 2 must recurse)
 * 
 */