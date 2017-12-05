//Name: Ian Sanborn
//operations for a cell in a linked queue
//helps set and reassign pointers of each node
public class QueueCell<T>{

  QueueCell<T> next;
  QueueCell<T> previous;
  T value;

  public QueueCell(){
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

  public QueueCell<T> getNext(){
    return next;
  }

  public QueueCell<T> getPrev(){
    return previous;
  }

  public void setNext(QueueCell<T> c){
    next = c;
  }

  public void setPrev(QueueCell<T> c){
    previous = c;
  }

}
