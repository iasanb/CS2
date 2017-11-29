//Name: Ian Sanborn
public class IntGrid2D implements IIntGrid2D{

  char[][] grid;
  int top_x; //upper left x coordinate
  int top_y; //upper left y coordinate
  int low_x; //lower right x coordinate
  int low_y; //lower right y coordinate
  int row;
  int col;
  int centerX; //center of the grid
  int centerY; //center of the grid

  //constructor
  public IntGrid2D(int topX, int topY, int lowerX, int lowerY, char spot){
    top_x = topX;
    top_y = topY;
    low_x = lowerX;
    low_y = lowerY;
    row = Math.abs(topX) + Math.abs(lowerX) + 1;
    col = Math.abs(topY) + Math.abs(lowerY) + 1;
    centerX = row - lowerX - 1;
    centerY = col - topY - 1; //sets the set point in the 2D array to be the "(0,0)" spot

    grid = new char[row][col];
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        grid[i][j] = spot; //fills in a blank grid
      }
    }
  }

  public void setPoint(IIntPoint2D p, char v){ //sets points in the array to the character
    int x = p.getX();
    int y = p.getY();
    char point = v;
    grid[centerX + x][centerY + y] = v; //allows to start at the center
  }

  public char getPoint(IIntPoint2D p){
    int x = p.getX();
    int y = p.getY();
    return grid[centerX + x][centerY + y];
  }

  public IIntPoint2D getUpperLeftCorner(){
    IIntPoint2D top = new IntPoint2D(top_x, top_y);
    return top;
  }

  public IIntPoint2D getLowerRightCorner(){
    IIntPoint2D bottom = new IntPoint2D(low_x, low_y);
    return bottom;
  }

}
