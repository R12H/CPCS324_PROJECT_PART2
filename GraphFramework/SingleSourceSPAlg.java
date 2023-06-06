/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  Dijkstra Algorithm: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/

Section:
CP1
 */
package GraphFramework;

import java.util.*;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {
    
    public SingleSourceSPAlg(Graph graph) {
        super(graph);
    }

    public void computeDijkstraAlg(Vertex source) throws CloneNotSupportedException {
        
        // Create a (Min-heap) to store node that have (Vertex, edge, weight)
        MinHeap minHeap = new MinHeap(super.gragh.verticesNo);
        // Create a List to track visited vertices
        LinkedList<Vertex> visited = new LinkedList<>();
        //Create Array to store the result set  as edges
        LinkedList<Edge> MinSpanTree = new LinkedList<>();
        
        //Add the source verte with 0 distant
        minHeap.add(new heapNode(source, 0));

        //add all the edges to array with infinite distant
        for (Vertex v: super.gragh.vertices) {
            if (v.equals(source)) continue;
            minHeap.add(new heapNode(v, Integer.MAX_VALUE));
        }

        // Process vertices until the minHeap is empty
        while (minHeap.peek() != null) {

            // remove the minimum node from minHeap
            heapNode node = minHeap.poll();
            
            
            
            //Check if it visited, if not add it to visited list
            if (visited.contains(node.getNode())) continue;
            visited.add(node.getNode());
            
            //In this case, vertex cannot be reach from source
            if(node.getWeight() == Integer.MAX_VALUE)continue;

            //Add the Edge of The minimum cost vertex
            if(node.getEdge() != null){
                
                Edge e = (Edge) node.getEdge().clone();
                
                //Better to store the path cost to edge
                e.setWeight(node.getWeight());
                MinSpanTree.add(e); 
            }
            
            
            LinkedList<Edge> adj = node.getNode().getAdjList();
 
            // For loop to update the distance of the verteces that near the current one
            for (int i = 0; i < adj.size(); i++) {
                
                Vertex target = adj.get(i).target;
                
                // If current node hasn't already been processed
                if (!visited.contains(target)) {
                    
                    //store the distance temporarily
                    int newDistance = adj.get(i).getWeight() + node.getWeight();
 
                    // If the new distance is cheaper in cost
                    if (newDistance < minHeap.get(target).getWeight()){
                        
                        //Update the node(target) weight
                        minHeap.get(target).setWeight( newDistance);
                        
                        //For loop to set a parent ro the edge before add it to MinSpanTree
                        if(!MinSpanTree.isEmpty()){
                            for (Edge edge : MinSpanTree) {
                                if(edge.getTarget().equals(node.getNode()))
                                    adj.get(i).setParent( edge.getSource());   
                                
                            }
                        }else adj.get(i).setParent(null);
                    
                    //add the edge to the target as it's its shortest edge then sort minheap
                    minHeap.get(target).setEdge(adj.get(i));
                    minHeap.sort();
 
                    }
                } 
            }    
        }
        setMSTResultList(MinSpanTree);
    }
    
    @Override
    public void setMSTResultList(LinkedList<Edge> MSTResultList){
        super.setMSTResultList(MSTResultList);
    }
    
    @Override
    public void displayResultingMST() {
        super.displayResultingMST();

    }
    
}
