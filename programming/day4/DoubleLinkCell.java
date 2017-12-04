//Name: Ian Sanborn
public class DoubleLinkCell<T> implements IDLink<T>{ //Node Class

  IDLink<T> next;
  IDLink<T> previous;
  T value;

  public DoubleLinkCell(){
    next = null;
    previous = null;
    value = null;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public IDLink<T> getNext(){
    return next;
  }

  public IDLink<T> getPrev(){
    return previous;
  }

  public void setNext(IDLink<T> c){
    next = c;
  }


  public void setPrev(IDLink<T> c){
    previous = c;
  }
}
