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

public class Vertex {
    
    String label;
    boolean isVisited;
    LinkedList<Edge> adjList;
    
    public Vertex() {}
    
    public Vertex(String label) {
        this.label = label;
        isVisited = false;
        adjList = new LinkedList<>();
    }
    
    public void setLabel(String label) {
        this.label = label;
    }
    
    public String getLabel() {
        return label;
    }

    public boolean isIsVisited() {
        return isVisited;
    }

    public LinkedList<Edge> getAdjList() {
        return adjList;
    }

    public void setIsVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
    
    public void displayInfo() {
        
        System.out.print("Vertex No. "+ getLabel());
        
    }
    
}
