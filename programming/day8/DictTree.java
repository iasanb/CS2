//Name: Ian Sanborn
public class DictTree<K extends Comparable<K>,V> implements IDict<K,V>{

  //instance variables
  TreeNode<K,V> root;
  TreeNode<K,V> current;
  int size = 0;
  K[] keys;

  //constructor
  public DictTree(){
    root = null;
    current = null;
  }

  public V add(K k, V v){
    K[] temp = (K[]) new Comparable[size + 1];
    current = root;
    if(current == null){
      root = new TreeNode<K,V>(k,v);
      temp[0] = k;
      keys = temp;
      size++;
      return null;
    }

    //not inserting root
    return helper(k,v);
  }

  public V helper(K k, V v){
    K[] temp = (K[]) new Comparable[size + 1];
    for(int i = 0; i < size; i++){
      temp[i] = keys[i];
    }
    //checks if key is already in tree
    if(k.compareTo(current.getKey()) == 0){
      V returnvalue = current.getValue();
      current.setValue(v);
      return returnvalue;
    }
    if((k.compareTo(current.getKey()) < 0 && current.getLeft() == null) || (k.compareTo(current.getKey()) > 0 && current.getRight() == null)){
      if(k.compareTo(current.getKey()) < 0){
        current.setLeft(new TreeNode<K,V>(k,v));
        size++;
        temp[size - 1] = k;
        keys = temp;
        return null;
      }
      else{
        current.setRight(new TreeNode<K,V>(k,v));
        size++;
        temp[size - 1] = k;
        keys = temp;
        return null;
      }
    }
    if(k.compareTo(current.getKey()) < 0){
      current = current.getLeft();
    }
    else{
      current = current.getRight();
    }
    helper(k,v);
    return null;
  }


  public V remove(K k){
    V returnvalue = null;

    int index = 0;
    K[] temp = (K[]) new Comparable[size - 1];
    while(index <= size){
      if(k.compareTo(keys[index]) == 0){
        break;
      }
      else if(k.compareTo(keys[index]) != 0){
        index++;
      }
    }
    for(int i = 0; i < size; i++){
      if(i < index){
        temp[i] = keys[i];
      }
      else if (i > index){
        temp[i-1] = keys[i];
      }
      else{
      }
    }
    keys = temp;

    // Find the node to remove and it's parent
    TreeNode<K,V> parent = null;
    // start at the root
    current = root;
    //while we have not found the key
    while(k.compareTo(current.getKey()) != 0){
      if(current.isLeaf() == false && k.compareTo(current.getKey()) > 0){ //go right if the key comes after
        parent = current;
        current = current.getRight();
      }
      else if(current.isLeaf() == false && k.compareTo(current.getKey()) < 0){ //go left if the key comes before
        parent = current;
        current = current.getLeft();
      }
    }
    //We have the node and its parent
    //Case 1: no grandchildren
    if(current.isLeaf() == true){
      if(current == root){
        root = null;
      }
      if(parent.getRight() == current){
        returnvalue = current.getValue();
        parent.setRight(null);
      }
      if(parent.getLeft() == current){
        returnvalue = current.getValue();
        parent.setLeft(null);
      }
      size--;
      current = root;
      return returnvalue;
    }
    //Case 2: one child, replace node with children
    if(current.getRight() == null || current.getLeft() == null){
      //Set parent to the point at the child
      if(current == root){
        if(current.getRight() == null){
          returnvalue = current.getValue();
          current = current.getLeft();
        }
        else{
          returnvalue = current.getValue();
          current = current.getRight();
        }
        size--;
        return returnvalue;
      }

      if(current.getRight() == null){
        if(parent.getRight() == current){
          returnvalue = current.getValue();
          parent.setRight(current.getLeft());
        }
        else{
          returnvalue = current.getValue();
          parent.setLeft(current.getLeft());
        }
        size--;
        return returnvalue;
      }
      else{
        if(parent.getRight() == current){
          returnvalue = current.getValue();
          parent.setRight(current.getRight());
        }
        else{
          returnvalue = current.getValue();
          parent.setLeft(current.getRight());
        }
      }
      size--;
      return returnvalue;
    }
      //Case 3: two children
      TreeNode<K,V> swapParent = current;
      TreeNode<K,V> swapNode = current.getRight();
      while(swapNode.getLeft() != null){
        swapParent = swapNode;
        swapNode = swapNode.getLeft();
      }
      //Have the left most node, set the left most parent to the right child
      if(parent != null){
        swapParent.setLeft(swapNode.getRight());
        swapNode.setLeft(current.getLeft());
        swapNode.setRight(current.getRight());
        if(parent.getRight() == current){
          parent.setRight(swapNode);
        }
        if(parent.getLeft() == current){
          parent.setLeft(swapNode);
        }
      }
      else{
        swapParent.setLeft(swapNode.getRight());
        swapNode.setLeft(current.getLeft());
        swapNode.setRight(current.getRight());
      }
    size--;
    current = root;
    return null;
  }

  public int size(){
    return size;
  }

  public V fetch(K k){
    //start at the root
    current = root;

    while(k.compareTo(current.getKey()) != 0){
      if(k.compareTo(current.getKey()) < 0 && current.getLeft() != null){
        current = current.getLeft();
      }
      else if(k.compareTo(current.getKey()) > 0 && current.getRight() != null){
        current = current.getRight();
      }
    }
    if(k.compareTo(current.getKey()) == 0){
      return current.getValue();
    }
    else{
      return null;
    }
  }

  public K[] keys(){
    return keys;
  }

}
