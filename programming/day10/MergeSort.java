//Name: Ian Sanborn
public class MergeSort<T extends Comparable> implements ISort<T>{
  //Merge sorting class

  //instance variables
  T[] merge;

  //constructor
  public MergeSort(){
    merge = (T[]) new Comparable[0];
  }

  public void sort(T[] in){ //takes in an unsorted array
    merge = in;
    splitter(0, merge.length - 1); //initial call to split the array
  }

  public void splitter(int start_index, int last_index){
    //splits the array until the sub-arrays are a length one
    //doesnt split array but splits up the index

    if(start_index < last_index){ //if there are two or more indexes in the sub array
      int middle_index = start_index + (last_index - start_index)/2; //gets the middle index of the initial or sub array

      splitter(start_index, middle_index); //left half of the array
      splitter(middle_index + 1, last_index); //right half of the array
      merger(start_index, middle_index, last_index); //combines the left and right halves
    }
  }

  public void merger(int start_index, int middle_index, int last_index){
    //combines both halves of the array
    int i = start_index; //starting index of the left half
    int j = middle_index + 1; //starting index of the right half
    int k = start_index; //index of the new sorted array

    T[] temp = (T[]) new Comparable[last_index + 1];
    for (int x = start_index; x <= last_index; x++) { //copies original array to a temporary one
      temp[x] = merge[x];
    }

    while(k < temp.length){
      if(i <= middle_index && j <= last_index){
        if(temp[i].compareTo(temp[j]) > 0){ //if the left is greater than the right
          merge[k] = temp[j];
          j++;
          k++;
        }
        else{ //if the right is greater than the left
          merge[k] = temp[i];
          i++;
          k++;
        }
      }
      else if(i > middle_index && j <= last_index){
        //if the left half ahs already been sorted into the array, move the rest of the right half into the array
        merge[k] = temp[j];
        j++;
        k++;
      }
      else if(i <= middle_index && j > last_index){
        merge[k] = temp[i];
        i++;
        k++;
      }

    }
  }

  /**
   * Produces the name of the kind of sort implemented
   * @return the name of the sort algorithm
   */
  public String sortName(){
    String name = "Merge Sort";
    return name;
  }

}
