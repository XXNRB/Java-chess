
/**
 * Write a description of class Chess_Piece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Chess_Piece
{
    private int numPiece;
    private int positionNumber;
    private char positionLetter;
    protected int positionColor; // 0 is white, 1 is black
    char VarName;
    public Chess_Piece(int np, int pn, char pl, int pc)
    {
        numPiece = np;
        positionNumber = pn;
        positionLetter = pl;
        positionColor= pc;
    }

    public boolean isValid()
    {
        return true;
    }

    public void display()
    {
        System.out.print(" " +VarName+" " );
    }
}