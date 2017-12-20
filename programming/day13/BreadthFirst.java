//Name: Ian Sanborn
public class BreadthFirst<N,W>{

  IGraph<N,W> graph;
  INode<N> start_node; //initial start node
  INode<N> end_node; //initial end node
  boolean pathExists = false; //boolean if there is a path between the nodes
  DoubleLinkList<INode> checked  = new DoubleLinkList<INode>(); //linked list of the nodes already visited
  IList<IEdge<N,W>> path = new ArrayList<IEdge<N,W>>(); //shortest path to the end node
  Queue<IEdge> temp  = new Queue<IEdge>(); //queue where we can dequeue things

  public BreadthFirst(IGraph<N,W> g, INode<N> s, INode<N> e){
    graph = g;
    start_node = s;
    end_node = e;
  }

  public boolean Search(INode<N> start, INode<N> end){
    //finds the path between the start and end node
    IEdge<N,W>[] edgesFrom_arr = graph.getEdgesFrom(start); //array of all the edges that are sourced at the start node
    DoubleLinkList<IEdge> edgesFrom = new DoubleLinkList();
    int t = 0;
    int j = 0;
    int k = 0;

    checked.append(start); //puts the start node in the list that we alrady visited

    for(int a = 0; a < edgesFrom_arr.length; a++){ //copies everything from edges array to a linked list
      edgesFrom.append(edgesFrom_arr[a]);
    }

    if(edgesFrom.size() > 0){ //if there are edges in the list
      for(int b = 0; b < edgesFrom.size(); b++){
        //if a destination of any of the edges are the end node, then stop everything
        if(edgesFrom.fetch(b).getDestination().equals(end)){
          pathExists = true;
          path.append(edgesFrom.fetch(b));
          break;
        }
      }
      if(pathExists == false){ //if a path isnt found yet
        while(j < checked.size()){
          while(k < edgesFrom.size()){
            if(checked.fetch(j).equals(edgesFrom.fetch(k).getDestination())){
              //if we have already visited a node, then remove the edge with that destination
              edgesFrom.remove(k);
            }
            else{
              k++;
            }
          }
          j++;
        }
        for(int i = 0; i < edgesFrom.size(); i++){ //adds everything to the path list and queue
          path.append(edgesFrom.fetch(i));
          temp.enqueue(edgesFrom.fetch(i));
        }
        while(t < path.size()){ //recursion
          Search(temp.dequeue().getDestination(), end); //checks next item in the queue
          t++;
          if(pathExists == true){//once a path is found stop
            break;
          }
        }
      }
    }
    else{ //edgesfrom list is empty
      //do nothing
    }
    return pathExists;
  }

  public IList<INode<N>> Path(){ //creates the path in a list
    IList<INode<N>> final_path = new ArrayList<INode<N>>(); //final path to return
      IEdge<N,W> dest = path.fetch(path.size() - 1);

      final_path.append(dest.getDestination()); //adds the end node and its source
      final_path.insert(0, dest.getSource());
        for(int g = 0; g < path.size(); g++){
        for(int h = g + 1; h < path.size(); h++){
          if(path.fetch(g).getDestination().equals(path.fetch(h).getDestination())){
            path.remove(h);
          }
        }
      }

      for(int s = 0; s < path.size(); s++){
        IEdge<N,W> current = path.fetch(s);
        if(current.getSource() == start_node && current.getDestination().equals(dest.getSource())){
          //if we reached the start node, stop
          break;
        }
        else if(current.getDestination().equals(dest.getSource())){
          //if the destination of the current node equals the source of the most recent edge, add it to the list
          final_path.insert(0, current.getSource());
          dest = current;
        }
      }
      final_path.insert(0, start_node); //adds the start node to the path
      return final_path;
  }

}
