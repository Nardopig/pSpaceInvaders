
package Logic;

public class GamePrinter {
  
  Game game;
  int numRows; 
  int numCols;
  String[][] board;
  final String space = " ";
  
  public GamePrinter (Game game, int cols, int rows) {
    this.game = game;
    this.numRows = rows;
    this.numCols = cols;  
  }
  
  private void encodeGame() {
    board = new String[numRows][numCols];
    for (int i = 0; i < numRows; i++) {
        for (int j = 0; j < numCols; j++) {
        	if (game.isDestroyerInPosition(i, j))
                board[i][j] = "D[" + game.getDestroyerLife(i, j) + "]";
            else if (game.isRegularInPosition(i, j))
                board[i][j] = "C[" + game.getRegularLife(i, j) + "]";
            else if (game.isOvniCreated() && game.isOvniInPosition(i, j))
                board[i][j] = "O[" + game.ovni.getLife() + "]";
            else if (game.isLaserShot() && game.isLaserInPosition(i,j))
            	board[i][j] = "oo";
            else if (game.isBombInPosition(i,j))
            	board[i][j] = "." ;
            else if (game.isUCMShipInPosition(i,j)) {
            	if(game.getShip().getLife() > 0) {
            	board[i][j] = "^___^";
            	}else{
            	board[i][j] = "!xx!";
            	}
            }
            else
                board[i][j] = space;
        }
    }
  }
  
  public String toString() {
    encodeGame();

    int cellSize = 7;
    int marginSize = 2;
    String vDelimiter = "|";
    String hDelimiter = "-";
    
    String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
    String margin = MyStringUtils.repeat(space, marginSize);
    String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);
    
    StringBuilder str = new StringBuilder();
    
    str.append(lineDelimiter);
    
    for(int i=0; i<numRows; i++) {
        str.append(margin).append(vDelimiter);
        for (int j=0; j<numCols; j++) {
          str.append( MyStringUtils.centre(board[i][j], cellSize)).append(vDelimiter);
        }
        str.append(lineDelimiter);
    }
    return str.toString();
  }
}

