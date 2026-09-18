
/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rook extends Chess_Piece
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Rook
     */
    public Rook(int np, int pn, char pl, int pc)
    {
        super (np, pn, pl, pc);
        if( pc == 0)
        {
             VarName = '\u2656';
        }
        else
        
        {
            
            VarName = '\u265C';
        }
    }
    }

