    /*
     * ############################################################################
     * Name: Billy Hart
     * Date:  Tue Apr 19 15:30:23 2016
     * Description: A different type of cell that affects the behavior of the game
     * Dead StrongCell's with either two or three live neighbors becomes a live 
     * cell. A live StrongCell with one to four live neighbors stays alive.
     * ############################################################################
    */
    
    // Includes
    import java.util.*;
    
    public class GoLStrongCell extends GoLCell {
        
        // Instance Variables
        //private boolean cellStatus;
    
        // Constructor(s) ----------------------------------------------------------
        public GoLStrongCell(boolean cellStatus) {
            super(cellStatus);
        }
    
        // Method(s) ---------------------------------------------------------------
        
        // Updates the cell using the given neighborhood and returns true if alive 
        // and false if dead
        public boolean updateCell(GoLNeighborhood myNeighborhood) {
            boolean stateOfCell = false;
            int numAlive = 0;

            for (int row = 0; row < 3; row++) {
                for (int column = 0; column < 3; column++) {
                    try { if (myNeighborhood.getCell(row, column).isAlive())
                            numAlive++;
                    } catch (NullPointerException e) {}
                }
            }

            // Check to see if the current cell is alive or dead
            stateOfCell = myNeighborhood.getCell(1, 1).isAlive();
               
            // Apply game rules to neighbors 
            if (stateOfCell) {
                numAlive--;
                if (numAlive < 0 || numAlive > 5)
                    stateOfCell = false;
            } else {
                if (numAlive == 2 || numAlive == 3)
                    stateOfCell = true;
            }

            return stateOfCell;
        } 
}
