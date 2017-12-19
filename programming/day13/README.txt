You should copy in your graph implementation from day11 including the DiGraphReader. You will use your graph implementation to support implementing two different path finding algorithms. DepthFirstSearcher will implement a depth first graph search and conform to the ISearcher interface. BreadthFirstSearcher will implement a breadth first graph search and conform to the ISearcher interface.

We will test your searcher implementations with several graph files. Sometimes a path will exist from the starting node to the target node, sometimes there will not be a path.

You should feel free to use any data structures you have implemented earlier in the block when implementing your searchers.

Files:
IGraph.java        - An interface for a graph implementation
INode.java         - An interface for nodes used by IGraph instances
IEdge.java         - An interface for edges used by IGraph instances
IGraphReader.java  - An interface for reading in graph files
DiGraphReader.java - This file isn't included, please include your day11 implementation
ISearcher.java     - An interface for classes that provide graph searches.
graphfile.cs2      - A simple graph file for a basic test

ArrayList.java - List implementation backed by an array
BreadthFirst.java - class that uses Breadth first search logic to find a path in a graph
DepthFirst.java - class that uses Depth first search logic to find a path in a graph
DoubleLinkCell.java - node logic of a double linked list
DoubleLinkList.java - list implementaion backed by a linked list
Edge.java - Functions of edges that implements IEdge
Graph.java - functions of the graph that implements IGraph
IDLink.java - interface for a double linked list node class
IList.java - interface for list classes 
IQueue.java - interface for a queue
IStack.java - interface for a stack
Node.java - functions of nodes in a graph, implements INode
Queue.java - queue implementation of a list
QueueCell.java - funtions of a node in a queue
Searcher.java - finds if a path exists and returns a path based on a depth first or breadth first method call
Stack.java - stack implementation of a list
StackCell.java - node funtions of a stack
