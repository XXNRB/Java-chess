
/**
 * Write a description of class Pawn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pawn extends Chess_Piece
{
    // instance variables - replace the example below with your own

    public Pawn(int np, int pn, char pl, int pc)
    {
        super (np, pn, pl, pc);
         if( pc == 0)
        {
             VarName = '\u2659';
        }
        else
        
        {
            
            VarName = '\u265F';
        }
    }
    }
