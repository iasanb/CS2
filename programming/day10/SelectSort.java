//Name: Ian Sanborn
public class SelectSort<T extends Comparable> implements ISort<T>{
  //Selection sorting class

  //instance variables
  T[] selection; //newly sorted array
  
  //constructor
  public SelectSort(){
    T[] selection = (T[]) new Comparable[0];
  }

  /**
   * Sorts an array of items in place
   * @param in An array to sort
   */
  public  void sort(T[] in){ //sorts items in the array
    T smallest_value;
    int smallest_index;
    selection = in;

    for(int i = 0; i < selection.length; i++){ //index to sort into
      smallest_value = selection[i];
      smallest_index = i;
      for(int j = i; j<selection.length; j++){
        //goes through the list to find the value to put at the index
        if(selection[j].compareTo(smallest_value) < 0){
          smallest_value = selection[j];
          smallest_index = j;
        }
        else{ // do nothing
        }
      }
      selection[smallest_index] = selection[i]; //swap the value that we started at and the smallest value in the array
      selection[i] = smallest_value;
    }
  }

  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName(){
    String name = "Selection Sort";
    return name;
  }
}
