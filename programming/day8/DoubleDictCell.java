public class DoubleDictCell<K, V>{

  DoubleDictCell<K, V> next;
  DoubleDictCell<K, V> previous;
  V value;
  K key;

  public DoubleDictCell(){
    next = null;
    previous = null;
    value = null;
  }

  public V getValue(){
    return value;
  }

  public void setValue(V v){
    value = v;
  }

  public K getKey(){
    return key;
  }

  public void setKey(K k){
    key = k;
  }

  public DoubleDictCell<K,V> getNext(){
    return next;
  }

  public DoubleDictCell<K,V> getPrev(){
    return previous;
  }

  public void setNext(DoubleDictCell<K,V> c){
    next = c;
  }


  public void setPrev(DoubleDictCell<K,V> c){
    previous = c;
  }
}
