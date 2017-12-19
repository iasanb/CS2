//Name: Ian Sanborn
//operations for a cell in a linked stack
//helps set and reassign pointers of each node
public class StackCell<T>{

  StackCell<T> next;
  T value;

  public StackCell(){
    next = null;
    value = null;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public StackCell<T> getNext(){
    return next;
  }

  public void setNext(StackCell<T> c){
    next = c;
  }

}
