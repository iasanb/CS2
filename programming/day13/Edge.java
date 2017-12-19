public class Edge<N,W> implements IEdge<N,W>{

  //instance variables
  W weight; //weight of the edge
  Node<N> source; //source node of the edge
  Node<N> destination; //destination node for the edge

  //constructor takes in the source, destination, and the weight
  public Edge(Node<N> start, Node<N> finish, W w){
    weight = w;
    source = start;
    destination = finish;
  }

  /**
  * The source node of the edge
  * @return the source node
  */
  public INode<N> getSource(){
  return source;
  }

  /**
  * The destination node of the edge
  * @return the destination node
  */
  public INode<N> getDestination(){
    return destination;
  }

  /**
  * The weight of the edge
  * @return the weight
  */
  public W getWeight(){
    return weight;
  }

  /**
  * Test for equality of two edges.
  * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
  * and this.dst == o.dst
  * @param o the other edge
  * @return true if the edges are the same
  */
  public boolean equals(Object o){
    Edge compared = (Edge) o; //edge type casted variable for the o Object
    if(source.equals(compared.getSource()) && destination.equals(compared.getDestination())){
      //compares the source and the destination of the o Object to the current edge
      return true;
    }
    else{
      return false;
    }
  }

}
