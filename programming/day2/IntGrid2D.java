//Name: Ian Sanborn
public class IntGrid2D implements IIntGrid2D{

  char[][] grid;
  int top_x; //upper left x coordinate
  int top_y; //upper left y coordinate
  int low_x; //lower right x coordinate
  int low_y; //lower right y coordinate
  int centerX; //center of the grid
  int centerY; //center of the grid

  //constructor
  public IntGrid2D(int topX, int topY, int lowerX, int lowerY, char spot){
    top_x = topX;
    top_y = topY;
    low_x = lowerX;
    low_y = lowerY;
    int row = topY - lowerY + 1;
    int col = lowerX - topX + 1;
    centerY = row - topY - 1;
    centerX = col - lowerX - 1; //sets the set point in the 2D array to be a "(0,0)" spot

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
    grid[centerY - y][centerX + x] = v; //allows to start at the center
  }

  public char getPoint(IIntPoint2D p){
    int x = p.getX();
    int y = p.getY();
    return grid[centerY - y][centerX + x];
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
