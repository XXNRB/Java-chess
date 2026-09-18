import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * /u3000
 */
public class Board
{
    private Chess_Piece[][] board;

    public Board() {
        board = createBoard();
    }

    private Chess_Piece[][] createBoard()
    {
        Chess_Piece[][] board = new Chess_Piece[8][8];
        for (int row = 0; row<8; row++)
        {
            if(row ==1)
            {
                for(int col = 0; col <8; col++)
                {
                    board[row][col] = new Pawn(col, row, (char) ('A' + col), 1);
                }
            }
            if(row ==6)
            {
                for(int col = 0; col <8; col++)
                {
                    board[row][col] = new Pawn(col, row, (char) ('A' + col), 0);
                }
            }
            if (row == 0)
            {
                for (int col = 0; col< 8; col++)
                {
                    if (col == 0)
                    {
                        board[row][col] = new Rook(col, row, (char) ('A' + col), 1);
                    }
                    if (col == 1)
                    {
                        board[row][col] = new Knight(col, row, (char) ('A' + col), 1);
                    }
                    if (col == 2)
                    {
                        board[row][col] = new Bishop(col, row, (char) ('A' + col), 1);
                    }
                    if (col == 3)
                    {
                        board[row][col] = new Queen(col, row, (char) ('A' + col), 1);
                    }
                    if (col == 4)
                    {
                        board[row][col] = new King(col, row, (char) ('A' + col), 1);
                    }
                    if (col == 5)
                    {
                        board[row][col] = new Bishop(col, row, (char) ('A' + col), 1);
                    }
                    if (col == 6)
                    {
                        board[row][col] = new Knight(col, row, (char) ('A' + col), 1);
                    }
                    if (col ==  7)
                    {
                        board[row][col] = new Rook(col, row, (char) ('A' + col), 1);
                    }

                }
            }
            if (row == 7)
            {
                for (int col = 0; col< 8; col++)
                {
                    if (col == 0)
                    {
                        board[row][col] = new Rook(col, row, (char) ('A' + col), 0);
                    }
                    if (col == 1)
                    {
                        board[row][col] = new Knight(col, row, (char) ('A' + col), 0);
                    }
                    if (col == 2)
                    {
                        board[row][col] = new Bishop(col, row, (char) ('A' + col), 0);
                    }
                    if (col == 3)
                    {
                        board[row][col] = new Queen(col, row, (char) ('A' + col), 0);
                    }
                    if (col == 4)
                    {
                        board[row][col] = new King(col, row, (char) ('A' + col), 0);
                    }
                    if (col == 5)
                    {
                        board[row][col] = new Bishop(col, row, (char) ('A' + col), 0);
                    }
                    if (col == 6)
                    {
                        board[row][col] = new Knight(col, row, (char) ('A' + col), 0);
                    }
                    if (col ==  7)
                    {
                        board[row][col] = new Rook(col, row, (char) ('A' + col), 0);
                    }
                }
            }

        }

        return board;
    }

    public void printBoard() 
    {
        System.out.println("    A   B   C   D   E   F   G   H"); // Print column labels
        System.out.println(" +------------------------------------+");
        for (int row = 0; row < 8;row++) {
            System.out.print(8 - row + "| "); // Print row labels
            for (int col = 0; col< 8; col++) {

                if(board[row][col]== null)
                {
                    System.out.print("    "); 
                }
                else
                {
                    board[row][col].display();
                }
            }
            System.out.println("|");
        }
        System.out.println(" +-------------------------------------+");

    }

    public boolean isMoveValid(int fromRow, int fromCol, int toRow, int toCol) {
        Chess_Piece piece = board[fromRow][fromCol];
        if (piece == null) {
            return false; // No piece at starting position
        }

        // Check if destination is out of board bounds
        if (toRow < 0 || toRow >= 8 || toCol < 0 || toCol >= 8) {
            return false;
        }

        // Implement specific move validation logic based on the type of piece
        if (piece instanceof Pawn) 
        {
            // Movement rules for Pawns
            int direction = piece.positionColor == 0 ? 1 : -1; // Assuming white pawns move upwards
            if (toCol == fromCol) {
                // Moving forward
                if (board[toRow][toCol] == null) {
                    if (toRow == fromRow + direction) {
                        return true; // Valid pawn move one step forward
                    }
                    if (fromRow == 1 && toRow == 3 && board[2][toCol] == null) {
                        return true; // Valid pawn move two steps forward from starting position
                    }
                }
            } else if (Math.abs(toCol - fromCol) == 1 && toRow == fromRow + direction) {
                // Capturing diagonally
                if (board[toRow][toCol] != null) {
                    return true;
                }
            }
            // Other conditions like en passant, promotion, etc., can be added here
        }
        // Implement specific move validation logic based on the type of piece
        if (piece instanceof Rook) {
            // Rook move validation logic
            // Rook can move horizontally (same row) or vertically (same column)
            // Check if moving along the same row or column
            if (fromRow == toRow || fromCol == toCol) {
                // Check if there are any pieces in between
                if (fromRow == toRow) { // Moving horizontally
                    int minCol = Math.min(fromCol, toCol);
                    int maxCol = Math.max(fromCol, toCol);
                    for (int col = minCol + 1; col < maxCol; col++) {
                        if (!isSpaceEmpty(fromRow, col)) {
                            return false; // Path is blocked
                        }
                    }
                } else { // Moving vertically
                    int minRow = Math.min(fromRow, toRow);
                    int maxRow = Math.max(fromRow, toRow);
                    for (int row = minRow + 1; row < maxRow; row++) {
                        if (!isSpaceEmpty(row, fromCol)) {
                            return false; // Path is blocked
                        }
                    }
                }
                // Destination cell is either empty or has opponent's piece
                return isSpaceEmpty(toRow, toCol) || piece.positionColor != board[toRow][toCol].positionColor;
            } else {
                return false; // Invalid move for a rook
            }
        }
        if (piece instanceof Bishop) {
            // Bishop move validation logic
            // Bishop can move diagonally
            // Check if the move is along a diagonal path
            if (Math.abs(fromRow - toRow) == Math.abs(fromCol - toCol)) {
                int rowIncrement = toRow > fromRow ? 1 : -1; // Determine row direction
                int colIncrement = toCol > fromCol ? 1 : -1; // Determine column direction
                int currentRow = fromRow + rowIncrement;
                int currentCol = fromCol + colIncrement;
                // Check each square along the diagonal path
                while (currentRow != toRow && currentCol != toCol) {
                    if (!isSpaceEmpty(currentRow, currentCol)) {
                        return false; // Path is blocked
                    }
                    currentRow += rowIncrement;
                    currentCol += colIncrement;
                }
                // Destination cell is either empty or has opponent's piece
                return isSpaceEmpty(toRow, toCol) || piece.positionColor != board[toRow][toCol].positionColor;
            } else {
                return false; // Invalid move for a bishop
            }
        }
        if (piece instanceof Knight) {
            // Knight move validation logic
            int rowDiff = Math.abs(toRow - fromRow);
            int colDiff = Math.abs(toCol - fromCol);
            // Knight moves in an L-shape (2 squares in one direction and 1 square in another)
            return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
        }
        if (piece instanceof Queen) {
            // Queen move validation logic
            int rowDiff = Math.abs(toRow - fromRow);
            int colDiff = Math.abs(toCol - fromCol);

            // Queen moves like a rook or a bishop
            return (rowDiff == 0 || colDiff == 0 || rowDiff == colDiff);
        }
        if (piece instanceof King) {
            // King move validation logic
            int rowDiff = Math.abs(toRow - fromRow);
            int colDiff = Math.abs(toCol - fromCol);

            // King moves one square in any direction
            return (rowDiff <= 1 && colDiff <= 1);
        }

        return false; // If none of the conditions are met, the move is invalid
    }

    public void movePiece(int fromRow, int fromCol, int toRow, int toCol) 
    {
        Chess_Piece piece = board[fromRow][fromCol];
        board[toRow][toCol] = piece; // Move the piece to the destination
        board[fromRow][fromCol] = null; // Clear the starting position
    }

    public boolean isSpaceEmpty(int row, int col) 
    {
        return board[row][col] == null;
    }

    public void takePiece(int row, int col) 
    {
        board[row][col] = null;    
    }

    public int [] translateMove() 
    {
        return null;  
    }

}