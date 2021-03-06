import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    Graph<String,Double> graph;
    INode<String> s;
    INode<String> d;

    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
        graph = new Graph();
        // Open the file
        BufferedReader file = new BufferedReader(new FileReader(filename));
        // Parse the lines. If a line does not have exactly 3 fields, ignore the line
        String line = file.readLine();
        while(line != null){
          String line_data[] = line.split(":");
          if(line_data.length == 3){
            String source = line_data[0];
            String destination = line_data[1];
            Double weight = Double.parseDouble(line_data[2]);

            s = graph.addNode(source);
            d = graph.addNode(destination);
            graph.addEdge(s, d, weight);

            line = file.readLine();
          }
        }
        // For each line, add the nodes and edge
        //After i have the right fields, need to make nodes and weights and add to graph

        // Return the graph instance
        return graph;
    }


    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
