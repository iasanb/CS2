//Name: Ian Sanborn
//Linked Queue class
public class Queue<T> implements IQueue<T>{ //First in, first out!

  //instance variables
  QueueCell<T> front; //front of queue
  QueueCell<T> back; //back of queue
  int length = 0; //current size of the Queue

  //constructor
  public Queue(){
    front = null;
    back = null;
  }
  /**
   * Dequeues the Front element from the queue
   * @return dequeued element
   * @throws UnderFlowException if dequeueing an empty queue
   */
  public T dequeue() throws UnderFlowException{
    if(length == 0){ //cannot dequeue if there is nothing in the queue
      throw new UnderFlowException();
    }
    T value = front.getValue(); //front item in the queue
    front = front.getNext(); //makes the front the next item in the queue
    length--;
    return value;
  }

  /**
   * Enqueues an element at the back of the queue
   * @param v enqueued element
   * @throws OverFlowException if enqueueing a full queue
   */
  public void enqueue(T v) throws OverFlowException{
    QueueCell<T> node = new QueueCell(); //node to add to the linked queue
    node.setValue(v);
    if(length == 0){ //if there is nothing in the queue
      node.setNext(null);
      node.setPrev(null);
      front = node;
      back = node;
    }
    else{ //reassigns pointers
      node.setNext(null);
      node.setPrev(back);
      back.setNext(node);
      back = node;
    }
    length += 1;
  }
}
