
/**
 * Write a description of class King here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class King extends Chess_Piece
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class King
     */
    public King(int np, int pn, char pl, int pc)
    {
        super (np, pn, pl, pc);
        if( pc == 0)
        {
             VarName = '\u2654';
        }
        else
        
        {
            
            VarName = '\u265A';
        }
    }
}
