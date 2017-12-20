//Name: Ian Sanborn
public class DepthFirst<N,W>{

  IGraph<N,W> graph; //passed in graph
  INode<N> start_node; //initial node ot start at
  INode<N> end_node; //node to end at
  boolean nodesExist = false; //boolean if nodes are in the graph
  boolean pathExists = false; //boolean is there is a path between the nodes
  Stack<INode> path  = new Stack<INode>(); //path between the two nodes
  DoubleLinkList<INode> checked  = new DoubleLinkList<INode>(); //nodes that have already been visited in the graph so that we do not go through them again

  //Constructor
  public DepthFirst(IGraph<N,W> g, INode<N> s, INode<N> e){
    graph = g;
    start_node = s;
    end_node = e;
  }

  public boolean Exist(){ //checks if the passed in start and end nodes are in the graph
    INode<N>[] nodes_arr = graph.getNodeSet(); //array of all the nodes in the graph
    boolean startFound = false; //if true, found start node
    boolean endFound = false; //if true, found end node
    DoubleLinkList<INode> nodes = new DoubleLinkList<INode>();
    INode<N> current;
    int i = 0;

    for(int j = 0; j < nodes_arr.length; j++){ //copies everything from the array to a linked list
      nodes.append(nodes_arr[j]);
    }

    if(nodes.size() == 0){ //if there are no nodes in the graph
      startFound = false;
      endFound = false;
    }
    else{ //there are nodes in the graph
      while(i < nodes.size()){
        current = nodes.fetch(i);
        if(current.equals(start_node)){ //checks if the current node in the list is the start node
          startFound = true;
          i++;
        }
        else if(current.equals(end_node)){ //checks if the current node in the list is the end node
          endFound = true;
          i++;
        }
        else{ //else, check next node in the list
          i++;
        }
      }
    }
    if(startFound == true && endFound == true){
      nodesExist = true;
    }
    else{
      nodesExist = false;
    }
    return nodesExist;
  }

  public boolean Search(INode<N> start, INode<N> end){ //sees if there is a path between the two nodes
    INode<N>[] neighbors_arr = graph.getNeighbors(start); //nodes of all the neighbors of the start node
    DoubleLinkList<INode> neighbors = new DoubleLinkList();
    int n = 0;

    path.push(start); //pushes the starting node on to the stack
    checked.append(start); //puts the starting node into the linked list of the nodes we have already visited

    for(int a = 0; a < neighbors_arr.length; a++){ //copies everything from the niehgbor array to a linked list
      neighbors.append(neighbors_arr[a]);
    }

    if(neighbors.size() > 0 ){ //if the node has neighbors
      for(int i = 0; i < neighbors_arr.length; i++){ //checks if an of the neighbors are the end node
        if(neighbors_arr[i].equals(end)){ //if a neighbor is the end node
          path.push(end); //push end node to the stack
          pathExists = true;
          break; //stop everything
        }
      }
      if(pathExists == false){ //if a path wasn't found yet
        for(int j = 0; j < checked.size() - 1; j++){ //nested for loops
          for(int k = 0; k < neighbors.size(); k++){ //checks if any of the neighbors of the start node have already been visited
            if(checked.fetch(j).equals(neighbors.fetch(k))){
              neighbors.remove(k); //if they have been visited, remove it from the list so we dont go to it again
            }
            else{ //do nothing
            }
          }
        }
        while(n < neighbors.size()){ //recursive
          Search(neighbors.fetch(n), end); //takes the next neighbor in the neighbor list and looks for a path to the end
          if(pathExists == true){
            break;
          }
          else{
            n++;
          }
        }
        if(pathExists == false && n >= neighbors.size()){
          //if we reached the end of one neighbors list then
          //pop off the top node because it did not lead to the end node
          path.pop();
        }
      }
    }
    else{
      path.pop();
      pathExists = false;
    }

    return pathExists;
  }

  public IList<INode<N>> Path(){
    IList<INode<N>> final_path = new ArrayList<INode<N>>();
    INode<N> dest = path.pop();
    final_path.append(dest);

    while(path.size() > 0){
    INode<N> current = path.pop();
    final_path.insert(0, current);
    }
    return final_path;
  }


}
