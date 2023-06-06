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


public class ShortestPathAlgorithm {
    
    Graph gragh;
    LinkedList<Edge> MSTResultList;
    
    public ShortestPathAlgorithm(Graph gragh){
        this.gragh = gragh;
    }
    
    public void setMSTResultList(LinkedList<Edge> MSTResultList) {
        this.MSTResultList = MSTResultList;
    }
    
    public Graph getGragh() {
        return gragh;  
    }
    
    public void displayResultingMST() {
        
        for (int i = 0; i < MSTResultList.size(); i++) {
            
            printPath(this.MSTResultList.get(i));

            System.out.print(" : ");
            this.MSTResultList.get(i).displayInfo();
            System.out.println();
        }
    }
   
    public void printPath(Edge node) {
        
        if(node.getParent() == null) node.source.displayInfo();
        for(Edge e : this.MSTResultList){
            if(e.getSource().equals(node.getParent()) && e.getTarget().equals(node.getSource()))
                printPath(e);
        }
        System.out.print(" - ");
        node.target.displayInfo();
        
    }
    
}
