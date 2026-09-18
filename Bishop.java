
/**
 * Write a description of class Bishop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bishop extends Chess_Piece
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(int np, int pn, char pl, int pc)
    {
        super (np, pn, pl, pc);
        if( pc == 0)
        {
             VarName = '\u2657';
        }
        else
        
        {
            
            VarName = '\u265D';
        }
    }
}
