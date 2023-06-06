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

public class Route extends Edge {
    
    public Route (){
        super();
    }
    
    public Route (Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }


    public void displayInfo() {
        System.out.print("--- route length: " + super.getWeight()); 
    }
    
}
