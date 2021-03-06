//Name: Ian Sanborn
/**
 * Interface for searching graphs
 */
public class BreadthFirstSearcher<N,W> implements ISearcher<N,W> {

  //instance variables
  boolean nodesExist; //nodes are in the graph
  boolean pathExists; //if there is a bath between the two nodes
    /**
     * Determines if there is a path without returning the path
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return if a path of any length exists
     */
    public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
      //finds if there is a path between the nodes using depth first methods
      DepthFirst d = new DepthFirst(g, s, e);
      BreadthFirst bf = new BreadthFirst(g, s, e);

      nodesExist = d.Exist(); //checks if the nodes are actually in the graph

       if(nodesExist == true){
         //call Depth First search method if the nodes exists
         pathExists = bf.Search(s,e); //finds a path
       }

       else{
         //if the nodes do not exist, then there is no path
         pathExists = false;
       }
       return pathExists;
    }

    /**
     * Finds a path based on the properties of the search algorithm.
     * If there is no path in graph g from node s to node e, null should be
     * returned. If node s and node e are the same, an empty list should be returned.
     * @param g the graph to search in
     * @param s node to start from
     * @param e node to end at
     * @return the list of nodes in the path
     */
    public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
      //finds if a path exists using depth first search methods
      //if a path exists, then both a depth first and breadth search path are created
      DepthFirst df = new DepthFirst(g, s, e);
      BreadthFirst b = new BreadthFirst(g, s, e);
      IList<INode<N>> depth_path = new ArrayList<INode<N>>(); //list for a depth search
      IList<INode<N>> breadth_path = new ArrayList<INode<N>>(); //list for a breadth search

      nodesExist = df.Exist(); //checks if the nodes are in the graph
      if(nodesExist == true){ //nodes are in the graph
        pathExists = b.Search(s,e); //checks if a path exists through breadth search
      }
      else{ //nodes are not in the graph
        pathExists = false;
      }

      if(pathExists == false){
        //if no path exists sets both paths to null
        breadth_path = null;
        depth_path = null;
      }
      else{ //a path does exist
        if(s.getValue().equals(e.getValue())){
          //do nothing, gives empty list
        }
        else{
          b.Search(s,e); //does a breadth first search
          breadth_path = b.Path(); //returns the path for a breadth search
        }
      }

      //when checking a certain path, make sure to change the return statments
      //originally returning the breadth first path, depth first return is
      // commented out beneath it
      return breadth_path;
    }
}
