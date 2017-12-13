//Name: Ian Sanborn
public class DoubleLinkList<T> implements IList<T>{ //Link List Class

  IDLink<T> head; //start of the list
  IDLink<T> tail; //end of the list
  int current = 0; //index of the current pointer
  int length = 0;
  IDLink<T> mover;

  //constructor
  public DoubleLinkList(){
    head = null;
    tail = null;
  }

  public void insert(int idx, T v){
    IDLink<T> after = null; //node after the spot that we want to insert at
    IDLink<T> node = new DoubleLinkCell(); //new node
    node.setValue(v);

    if(idx == length){ //if inserting at the end
      append(v);
    }
    else{ //inserting anywhere else
      for(int i = 0; i <= idx; i++){
        /* Since ther eare no indexs we have to keep track of where we are in
          the list with points starting at the head and use the getNext method
          until it reaches the index after where we want to insert
        */
        if(i == 0){ //at the first index, start at the head
          after = head;
        }
        else{ //move throught the linked list
          after = after.getNext();
        }
      }
      IDLink<T> before = after.getPrev(); //gets the node before the index we want to insert at
      //reassign before, after, and new node pointers
      node.setNext(after);
      node.setPrev(before);
      before.setNext(node);
      after.setPrev(node);
    }
    length += 1; //increase the lenght of the list since it isnt an array
  }

  public void append(T v){ //attach new node to the end
    IDLink<T> node = new DoubleLinkCell();
    node.setValue(v);
    if(length == 0){ //if list is empty
      node.setNext(node);
      node.setPrev(node);
      head = node;
      tail = node;
    }
    else{ //if list isnt empty
      node.setNext(node);
      node.setPrev(tail);
      tail.setNext(node);
      tail = node;
    }
    length += 1;
    current = length - 1; //assign current pointer to last index
  }

  public void remove(int idx){ //remove at a current index
    IDLink<T> delete = null; //item we want to remove
    IDLink<T> before = null; //item before the delete node
    IDLink<T> after = null; //item after the delete node
    for(int i = 0; i <= idx; i++){
      //same logic as the insert but gets us to the index we want to remove
      if(i == 0){
        delete = head;
      }
      else{
        delete = delete.getNext();
      }
    }
    if(idx == 0){ //if removing the head
      after = delete.getNext();
      after.setPrev(after);
      head = after;
    }
    else{
      //reassign before and after pointers to point to each other
      // and not at the removed node
      before = delete.getPrev();
      after = delete.getNext();
      before.setNext(after);
      after.setPrev(before);
    }
    if(current > idx){
      /* decrease current if it is bigger than the index
        because the amount of indexes deccreased
      */
      current--;
    }
    length -= 1;
  }

  public void remove(){ //remove where current is pointing to
    //since current is an int represeting and index
    //we can call remove(index) on current
    remove(current);
    prev();
  }

	public void move(int sidx, int didx){
    for(int i = 0; i <= sidx; i++){ //searches for the index and its value to move
      if(i == 0){
        mover = head;
      }
      else{
        mover = mover.getNext();
      }
    }
    remove(sidx); //remove index
    insert(didx, mover.getValue()); //insert it back in
  }

	public T fetch(){ //fetch current index
    IDLink<T> node = head;
    for(int i = 0; i < current; i++){ //gets to index that is current
      node = node.getNext();
    }
    return node.getValue(); //returns current's values
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
