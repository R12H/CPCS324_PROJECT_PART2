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

public class Edge implements Comparator<Edge>, Cloneable {
    
    Vertex parent;
    Vertex source;
    Vertex target;
    int weight;
    
    public Edge(){}
    
    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Edge(Vertex parent, Vertex source, Vertex target, int weight) {
        this.parent = parent;
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public Vertex getSource() {
        return source;
    }
    
    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Vertex getTarget() {
        return target;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
    
    @Override
    public int compare(Edge edge1, Edge edge2){
 
        if (edge1.weight < edge2.weight) return -1;
 
        if (edge1.weight > edge2.weight) return 1;
 
        return 0;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
 
        return super.clone();
    }
    
    public void displayInfo() {

        System.out.print(" Edge length: "+ weight);
    }
    
}
