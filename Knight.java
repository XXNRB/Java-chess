
/**
 * Write a description of class Knight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Knight extends Chess_Piece
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Knight
     */
    public Knight(int np, int pn, char pl, int pc)
    {
        super (np, pn, pl, pc);
        if( pc == 0)
        {
             VarName = '\u2658';
        }
        else
        
        {
            
            VarName = '\u265E';
        }
    }
}
