//Name: Ian Sanborn
//Linked Stack class
public class Stack<T> implements IStack<T>{//First in, Last out

  //instace variables
  StackCell<T> top; //top node in the stack
  int length = 0; //current size of the stack

  //constructor
  public Stack(){
    top = null;
  }

  /**
   * Pushes a new value onto the stack
   * @param v the value to push
   */
  public void push(T v){
    StackCell<T> node = new StackCell(); //new node to push on the stack
    node.setValue(v);
    if(length == 0){ //if stack is empty
      node.setNext(null);
      top = node;
    }
    else{
      node.setNext(top); //puts the new node on the top of the stack
      top = node;
    }
    length++;
  }
  /**
   * Pops the top value from the stack
   * @return the value
   */
  public T pop() {
    // if(length == 0){ //cannot pop anything if the stack is empty
    //   throw new UnderFlowException();
    // }
    T value = top.getValue(); //gets the top value
    top = top.getNext();
    length--;
    return value;
  }

  public int size(){
    return length;
  }

}
