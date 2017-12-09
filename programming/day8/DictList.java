public class DictList<K extends Comparable<K>,V> implements IDict<K,V>{

  //instance variables
  DoubleDictCell<K,V> head;
  DoubleDictCell<K,V> tail;
  int length = 0;
  K[] keys;


  //constructor
  public DictList(){
    head = null;
    tail = null;
  }

  /**
   * Adds a value to the dictionary, replacing the existing value if any.
   * @param k key for the new value
   * @param v value
   * @return the value replaced, otherwise null
   */
  public V add(K k, V v){
    DoubleDictCell<K,V> node = new DoubleDictCell();
    V returnvalue = null;
    node.setValue(v);
    node.setKey(k);
    if(length == 0){ //if there is nothing in the list
      head = node;
      tail = node;
      length++;
    }
    else{
      DoubleDictCell<K,V> current = head;
      for(int i = 0; i <= length; i++){
        if(i < length && node.getKey().compareTo(current.getKey()) == 0){
          returnvalue = current.getValue();
          current.setValue(node.getValue());
          break;
        }
        else if(i < length && node.getKey().compareTo(current.getKey()) != 0){
          current = current.getNext();
        }
        else if(i == length){
          node.setPrev(tail);
          tail.setNext(node);
          tail = node;
          length++;
          break;
        }
      }
    }
    return returnvalue;
  }

  /**
   * Removes a value and key from the dictionary. An unmatched key should return null.
   * @param k key to remove
   * @return the value of the removed key
   */
  public V remove(K k){
    DoubleDictCell<K,V> current = head;
    DoubleDictCell<K,V> before = null;
    DoubleDictCell<K,V> after = null;
    V returnvalue = null;
    for(int i = 0; i <= length; i++){
      if(i == 0 && k.compareTo(current.getKey()) == 0){
        returnvalue = current.getValue();
        after = current.getNext();
        after.setPrev(null);
        after = head;
        length--;
        break;
      }
      else if(i == length - 1 && k.compareTo(current.getKey()) == 0){
        returnvalue = current.getValue();
        before = current.getPrev();
        before.setNext(null);
        before = tail;
        length--;
        break;
      }
      else if(k.compareTo(current.getKey()) != 0){
        current= current.getNext();
      }
      else if(k.compareTo(current.getKey()) == 0){
        returnvalue = current.getValue();
        before = current.getPrev();
        after = current.getNext();
        before.setNext(after);
        after.setPrev(before);
        length--;
        break;
      }
      else if(i == length){
        break;
      }
    }
    return returnvalue;
  }

  /**
   * Returns the size of the dictionary
   * @return the number of values stored in the dictionary
   */
  public int size(){
    return length;
  }

  /**
   * Returns the value associated with a particular key in the dictionary.
   * Returns null if there is no matching key.
   * @param k key to retrieve the value for
   * @return the value
   */
  public V fetch(K k){
    DoubleDictCell<K,V> current = head;
    V returnvalue = null;
    for(int i = 0; i <= length; i++){
      if(k.compareTo(current.getKey()) == 0){
        returnvalue = current.getValue();
      }
      else if(k.compareTo(current.getKey()) != 0){
        current = current.getNext();
      }
      else if(i == length){
        returnvalue = null;
      }
    }
    return returnvalue;
  }

  /**
   * Returns an array of the keys in the dictionary
   * @return array of all keys
   */
  public K[] keys(){
    DoubleDictCell<K,V> current = head;
    keys = (K[]) new Object[length];
    for(int i = 0; i < length; i++){
      keys[i] = current.getKey();
      current = current.getNext();
    }
    return keys;
  }

}
