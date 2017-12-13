public class Edge<N,W> implements IEdge<N,W>{

  //instance variables
  W weight;
  Node<N> source;
  Node<N> destination;

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
    Edge compared = (Edge) o;
    if(source.equals(compared.getSource()) && destination.equals(compared.getDestination())){
      return true;
    }
    else{
      return false;
    }
  }

}
