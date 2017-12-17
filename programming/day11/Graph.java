public class Graph<N,W> implements IGraph<N,W>{

  //instance variables
  DoubleLinkList<Node> nodes; //linked list of all the nodes
  DoubleLinkList<Edge> edges; //linked list of all the edges
  N value; //value of the node


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
      //copies all the nodes from the nodes linked list to the array
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
    DoubleLinkList<INode> neighbors = new DoubleLinkList(); //linked list for the neightbor nodes

    for(int i = 0; i < edges.size(); i++){
      //checks all the edges in the edge linked list
      Edge current = edges.fetch(i);
      if(current.getSource().equals(n)){
        //if the node passed in is the source for the current edge, then its neightbor is the edge's destination
        neighbors.append(current.getDestination());
      }
    }

    INode<N>[] neighbors_array = (Node<N>[])new Node[neighbors.size()];
    //copies all the nodes in the neighbors linked list into the neighbors array to return
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
    N val = (N) v; //value for the node
    String current; //current node's value that we are looking at to check
    Node<N> new_node = new Node(val); //node to return/add
    boolean duplicate = false; //checker if the new node already exists
    int i = 0;

    if(nodes.size() > 0){ //if list is not empty
      while(duplicate == false && i < nodes.size()){
        //as long as we are inside the list length and have not found a duplicate
        current = (String)nodes.fetch(i).getValue();
        if(current.equals(val)){
          duplicate = true;
        }
        else{
          duplicate = false;
          i++;
        }
      }
      if(duplicate == false){
        //adds new node to the node linked list
        nodes.append(new_node);
      }
      else{ //do nothing
      }

    }
    else if(nodes.size() == 0){
      //if the list is empty then there is nothing to check against
      //instantly add new node
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
      //copipes all edges from linked list to array
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
    DoubleLinkList<IEdge> edgesFrom = new DoubleLinkList(); //linked list of all edges coming from a particular node

    for(int i = 0; i < edges.size(); i++){
      //looks through all edges in linked list
      IEdge<N,W> current = edges.fetch(i);
      if(current.getSource().equals(n)){
        //if current edge's source is the passed in node, add the edge to the list
        edgesFrom.append(current);
      }
    }

    IEdge<N,W>[] edge_source = (Edge<N,W>[]) new Object[edgesFrom.size()];
    //copies all the edges from the linked list to the array to return
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
    //casts source and destination parameters to Node type from INode types
    N sVal = s.getValue();
    N dVal = d.getValue();
    Node<N> source =(Node<N>) s;
    Node<N> destination = (Node<N>) d;
    boolean duplicate = false;

    for(int j = 0; j < nodes.size(); j++){
      Node<N> current = (Node<N>) nodes.fetch(j);
      if(current.getValue().equals(sVal)){
        source = current;
      }
      if(current.getValue().equals(dVal)){
        destination = current;
      }
    }
    Edge<N,W> new_edge = new Edge(source, destination, w);
    //check is the edge already exists
    for(int i = 0; i < edges.size(); i++){
      //checks all current edge's sources, destinations, and weights
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

  public int getSize(){ //returns the size of the node linked list
    //used this for testing the DiGraphReader (not on interface)
    return nodes.size();
  }
}
