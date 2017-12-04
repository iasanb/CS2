public class SingleLinkCell<T> implements ISLink<T>{

  ISLink<T> next;
  T value;
  
  public SingleLinkCell(){
    next = null;
    value = null;
  }

  public T getValue(){
    return value;
  }

  public void setValue(T v){
    value = v;
  }

  public ISLink<T> getNext(){
    return next;
  }

  public void setNext(ISLink<T> c){
    next = c;
  }

}
