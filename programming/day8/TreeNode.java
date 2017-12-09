//Binary Tree Node
public class TreeNode<K, V>{
  K key;
  V value;
  TreeNode<K, V> left;
  TreeNode<K, V> right;

  //constructor
  //makes a new node
  public TreeNode(K k, V v){
    left = null;
    right = null;
    key = k;
    value = v;
  }

  //Sets the left child of this Node
  public void setLeft(TreeNode<K,V> l){
    left = l;
  }

  //set teh rigth child of this node
  public void setRight(TreeNode<K,V> r){
    right = r;
  }

  //gets left child
  public TreeNode<K,V> getLeft(){
    return left;
  }

  //gets rigth child
  public TreeNode<K,V> getRight(){
    return right;
  }

  //checks if the node is a leaf
  //checks if there is a left AND right child
  public boolean isLeaf(){
    if(left == null && right == null){
      return true;
    }
    else{
      return false;
    }
  }

  public void setKey(K k){
    key = k;
  }

  //gets the key for this node
  //returns the number of the key (not the value assigned to the key)
  public K getKey(){
    return key;
  }

  public void setValue(V v){
    value = v;
  }

  //gets value for this node
  public V getValue(){
    return value;
  }

}
