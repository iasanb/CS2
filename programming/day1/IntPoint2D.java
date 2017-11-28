//Name: Ian Sanborn
public class IntPoint2D implements IIntPoint2D{

  int x;
  int y;
  int mdistance;
  double edistance;

  //constructor
  public IntPoint2D(int x_coor, int y_coor){
    x = x_coor;
    y = y_coor;
  }

  public int getX(){ //gets x coordinate
    return x;
  }

  public int getY(){ //gets y coordinate
    return y;
  }

  public int manhattanDistance(IIntPoint2D o){
    mdistance = Math.abs(x - o.getX()) + Math.abs(y - o.getY());
    return mdistance;
  }

  public double distance(IIntPoint2D o){
    int x_ = x - o.getX();
    int y_ = y - o.getY();
    double x_sqrt = Math.pow(x_ , 2); //squares new x value
    double y_sqrt = Math.pow(y_ , 2); //squares new y value
    edistance = Math.sqrt(x_sqrt + y_sqrt); //square root of the sum
    return edistance;
  }

  public String toString(){ //(x coordinate, y coordinate)
    return "(" + getX() + "," + getY() + ")";
  }

  public boolean equals(IntPoint2D o){
    if(x == o.getX() || y == o.getY()){
      return true;
    }
    else{
      return false;
    }
  }

  public int hashcode(){
    int shift = (x << 16) + y;
    return shift;
  }

}
