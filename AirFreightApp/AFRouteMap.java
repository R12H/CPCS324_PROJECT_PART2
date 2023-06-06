/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  Dijkstra Algorithm: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/

Section:
CP1
 */
package AirFreightApp;

import GraphFramework.*;
import java.io.*;

public class AFRouteMap extends Graph{
    
    public int labelNo = 0;
    
    public AFRouteMap(){
        super();
    }

    public AFRouteMap(int vertices, int edges, boolean isDigraph) {
       super(vertices, edges, isDigraph);
    }

    //----------------------------------------------------------------------------------
    
    @Override
    public void makeGraph(int reqVetices, int reqEdges) {
        super.makeGraph(reqVetices, reqEdges);
    }
    
    @Override
    public void readGraphFromFile(File file) throws FileNotFoundException {
       super.readGraphFromFile(file);

    }
    
    //----------------------------------------------------------------------------------
    
    @Override
    public Vertex createVertex(String label){
        if ( label.equals("Random"))
            return new Location("Loc" + ++labelNo);
        return new Location(label);
    }
    
    @Override
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
        return new Route(source, destination, weight);
    }
    
}
