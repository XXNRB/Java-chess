import java.util.ArrayList;
import java.util.Scanner;

/**
 * \u265A-\u265F
\u2654-\u2659

Correctly displays the board and pieces:5 points
Properly keeps track of whose turn it is: 5 points
Has a class for pieces and a subclass for each piece that correctly deals with move validation: 40 points
Can move pieces: 10points
Removes pieces that are taken: 5 points
Properly deals with castling: 5 points
Properly deals with en passant: 5 points
Properly deal with pawn Promotion: 5 points
Prints out when player is in check/checkmate: 5 points
Give the option for both players to resign: 5 points
Neatness of code and comments: 10 points

Bonus Proper AI for single player: 10 points
 */
public class Chess
{
    private static String player1Name;
    private static String player2Name;
    private static int currentPlayer = 1; // 1 for player 1 (white), 2 for player 2 (black)
    private static boolean player1IsWhite = true; // By default, player 1 (white) plays first

    public static void main(String args[])
    {
        Board B = new Board();
        getPlayerNames();
        selectColor();
        B.printBoard();
        while (true)
        {
            System.out.println("Player " + (currentPlayer == 1 ? player1Name : player2Name) + "'s turn:");
            if (currentPlayer == 1 && player1IsWhite || currentPlayer == 2 && !player1IsWhite) {
                // Player 1 (white) or Player 2 (black) moves
                int[] move = B.translateMove();
                if (move != null) {
                    int fromRow = move[0];
                    int fromCol = move[1];
                    int toRow = move[2];
                    int toCol = move[3];

                    if (B.isMoveValid(fromRow, fromCol, toRow, toCol)) 
                    {
                        B.movePiece(fromRow, fromCol, toRow, toCol);
                        B.printBoard();
                        currentPlayer = currentPlayer == 1 ? 2 : 1; // Switch player turns
                    } 
                    else 
                    {
                        System.out.println("Invalid move! Try again.");
                    }
                } else 
                {
                    System.out.println("Invalid input! Try again.");
                }

            }

        }
    }

    private static void getPlayerNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter player 1 name:");
        player1Name = scanner.nextLine();
        System.out.println("Enter player 2 name:");
        player2Name = scanner.nextLine();
    }

    private static void selectColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select color for " + player1Name + " (white or black):");
        String color = scanner.nextLine();
        if (color.equalsIgnoreCase("black")) {
            player1IsWhite = false;
        }
    }
}