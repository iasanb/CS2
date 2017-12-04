//Name: Ian Sanborn
public class DoubleLinkList<T> implements IList<T>{ //List Class

  IDLink<T> head;
  IDLink<T> tail;
  int current = 0;
  int length = 0;
  IDLink<T> mover;

  //constructor
  public DoubleLinkList(){
    head = null;
    tail = null;
  }

  public void insert(int idx, T v){
    IDLink<T> after = null;
    IDLink<T> node = new DoubleLinkCell();
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
      IDLink<T> before = after.getPrev();
      node.setNext(after);
      node.setPrev(before);
      before.setNext(node);
      after.setPrev(node);
    }
    length += 1;
  }

  public void append(T v){
    IDLink<T> node = new DoubleLinkCell();
    node.setValue(v);
    if(length == 0){
      node.setNext(node);
      node.setPrev(node);
      head = node;
      tail = node;
    }
    else{
      node.setNext(node);
      node.setPrev(tail);
      tail.setNext(node);
      tail = node;
    }
    length += 1;
    current = length - 1;
  }

  public void remove(int idx){
    IDLink<T> delete = null;
    IDLink<T> before = null;
    IDLink<T> after = null;
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
      after.setPrev(after);
      head = after;
    }
    else{
      before = delete.getPrev();
      after = delete.getNext();
      before.setNext(after);
      after.setPrev(before);
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
    IDLink<T> node = head;
    for(int i = 0; i < current; i++){
      node = node.getNext();
    }
    return node.getValue();
  }

	public T fetch(int idx){
    IDLink<T> node = head;
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
