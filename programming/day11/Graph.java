public class Graph<N,W> implements IGraph<N,W>{

  //instance variables
  DoubleLinkList<Node> nodes; //linked list of all the nodes
  DoubleLinkList<Edge> edges; //linked list of all the edges
  N value;


  //constructor
  public Graph(){
    value = null;
    nodes = new DoubleLinkList<Node>();
    edges = new DoubleLinkList<Edge>();
  }

  /**
   * Gets an array of all the nodes in the graph
   * @return the node set
   */
  public INode<N>[] getNodeSet(){
    INode<N>[] node_array = (INode<N>[]) new Node[nodes.size()]; //array of all the nodes

    for(int i = 0; i < node_array.length; i++){
      node_array[i] = nodes.fetch(i);
    }
    return node_array;
  }

  /**
   * An array of the neighbors of a node
   * @param n the node
   * @return neighbors of n
   */
  public INode<N>[] getNeighbors(INode<N> n){
    DoubleLinkList<INode> neighbors = new DoubleLinkList();

    for(int i = 0; i < edges.size(); i++){
      Edge current = edges.fetch(i);
      if(current.getSource().equals(n)){
        neighbors.append(current.getDestination());
      }
      else if(current.getDestination().equals(n)){
        neighbors.append(current.getSource());
      }
    }

    INode<N>[] neighbors_array = (Node<N>[])new Object[neighbors.size()];
    for(int j = 0; j < neighbors.size(); j++){
      neighbors_array[j] = neighbors.fetch(j);
    }
    return neighbors_array;
  }

  /**
   * Adds a node to the graph
   * @param v value at the node
   * @return the newly added node
   */
  public INode<N> addNode(N v){
    N value = (N) v;
    String current;
    Node<N> new_node = new Node(value);
    boolean duplicate = false;
    int i = 0;

    if(nodes.size() > 0){
      while(duplicate == false && i < nodes.size()){
        current = (String)nodes.fetch(i).getValue();
        if(current.equals(value)){
          duplicate = true;
        }
        else{
          duplicate = false;
          i++;
        }
      }
      if(duplicate == false){
        nodes.append(new_node);
      }
      else{ //do nothing
      }

    }
    else if(nodes.size() == 0){
      nodes.append(new_node);
    }
    return new_node;
  }

  /**
   * Gets an array of all the edges in the graph
   * @return the edge set
   */
  public IEdge<N,W>[] getEdgeSet(){
    IEdge<N,W>[] edge_array = (IEdge<N,W>[]) new Edge[edges.size()]; //array of all the edges

    for(int i = 0; i < edge_array.length; i++){
      edge_array[i] = edges.fetch(i);
    }
    return edge_array;
  }

  /**
   * Gets an array of all the edges sourced at a particular node
   * @param n the source node
   * @return the edge set
   */
  public IEdge<N,W>[] getEdgesFrom(INode<N> n){
    DoubleLinkList<IEdge> edgesFrom = new DoubleLinkList();

    for(int i = 0; i < edges.size(); i++){
      IEdge<N,W> current = edges.fetch(i);
      if(current.getSource().equals(n)){
        edgesFrom.append(current);
      }
    }

    IEdge<N,W>[] edge_source = (Edge<N,W>[]) new Object[edgesFrom.size()];
    for(int j = 0; j < edgesFrom.size(); j++){
      edge_source[j] = edgesFrom.fetch(j);
    }
    return edge_source;
  }

  /**
   * Gets an array of all the edges destined for a particular node
   * @param n the destination node
   * @return the edge set
   */
  public IEdge<N,W>[] getEdgesTo(INode<N> n){
    DoubleLinkList<IEdge> edgesTo = new DoubleLinkList();

    for(int i = 0; i < edges.size(); i++){
      IEdge<N,W> current = edges.fetch(i);
      if(current.getDestination().equals(n)){
        edgesTo.append(current);
      }
    }

    IEdge<N,W>[] edge_destination = (Edge<N,W>[]) new Object[edgesTo.size()];
    for(int j = 0; j < edgesTo.size(); j++){
      edge_destination[j] = edgesTo.fetch(j);
    }
    return edge_destination;
  }

  /**
   * Adds an edge to the graph.
   * Duplicate edges are not allowed in the graph. The equals method of the edge can
   * be used to determine if two edges duplicate one another.
   * @param w weight of the edge
   * @param s source node
   * @param d destination node
   */
  public void addEdge(INode<N> s, INode<N> d, W w){
    Node<N> source =(Node<N>) s;
    Node<N> destination = (Node<N>) d;
    boolean duplicate = false;
    Edge<N,W> new_edge = new Edge(source, destination, w);

    for(int i = 0; i < edges.size(); i++){
      Edge<N,W> current = edges.fetch(i);
      if(current.getSource().equals(source) && current.getDestination().equals(destination) && current.getWeight().equals(w)){
        duplicate = true;
        break;
      }
      else{
        duplicate = false;
      }
    }
    if(duplicate == false){
      edges.append(new_edge);
    }
  }

  public int getSize(){
    return nodes.size();
  }
}
