public class SingleLinkList<T> implements IList<T> {

  //instance variables
  ISLink<T> head;
  ISLink<T> tail;
  int current = 0;
  int length = 0;
  ISLink<T> mover;

  //constructor
  public SingleLinkList(){
    head = null;
    tail = null;
  }

  public void insert(int idx, T v){
    ISLink<T> before = null;
    ISLink<T> after = null;
    ISLink<T> node = new SingleLinkCell();
    node.setValue(v);

    if(idx == length){
      append(v);
    }
    else{
      for(int i = 0; i <= idx; i++){
        if(i == 0){
          after = head;
        }
        else{
          after = after.getNext();
        }
      }
      for(int i = 0; i < idx; i++){
        if(i == 0){
          before = head;
        }
        else{
          before = before.getNext();
        }
      }
      node.setNext(after);
      before.setNext(node);
    }
    length += 1;
  }

  public void append(T v){
    ISLink<T> node = new SingleLinkCell();
    node.setValue(v);
    if(length == 0){
      node.setNext(node);
      head = node;
      tail = node;
    }
    else{
      node.setNext(node);
      tail.setNext(node);
      tail = node;
    }
    length += 1;
    current = length - 1;
  }

  public void remove(int idx){
    ISLink<T> delete = null;
    ISLink<T> before = null;
    ISLink<T> after = null;
    for(int i = 0; i <= idx; i++){
      if(i == 0){
        delete = head;
      }
      else{
        delete = delete.getNext();
      }
    }
    if(idx == 0){
      after = delete.getNext();
      head = after;
    }
    else{
      for(int i = 0; i < idx; i++){
        if(i == 0){
          before = head;
        }
        else{
          before = before.getNext();
        }
      }
      after = delete.getNext();
      before.setNext(after);
    }
    if(current > idx){
      current--;
    }
    length -= 1;
  }

  public void remove(){
    remove(current);
    prev();
  }

  public void move(int sidx, int didx){
    for(int i = 0; i <= sidx; i++){
      if(i == 0){
        mover = head;
      }
      else{
        mover = mover.getNext();
      }
    }
    remove(sidx);
    insert(didx, mover.getValue());
  }

  public T fetch(){
    ISLink<T> node = head;
    for(int i = 0; i < current; i++){
      node = node.getNext();
    }
    return node.getValue();
  }

  public T fetch(int idx){
    ISLink<T> node = head;
    for(int i = 0; i < idx; i++){
      node = node.getNext();
    }
    return node.getValue();
  }

  public void next(){
    if(current < length - 1){
      current++;
    }
  }

  public void prev(){
    if(current > 0){
      current--;
    }
  }

  public void jumpToTail(){
    current = length - 1;
  }

  public void jumpToHead(){
    current = 0;
  }

  public int size(){
    return length;
  }

}
