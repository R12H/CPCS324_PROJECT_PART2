/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  Dijkstra Algorithm: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/

Section:
CP1
 */
package GraphFramework;


public class heapNode {
    
    Vertex Node;
    Edge edge;
    int weight;

    public heapNode(Vertex Node, int weight) {
        this.Node = Node;
        this.weight = weight;
    }

    public Vertex getNode() {
        return Node;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public Edge getEdge() {
        return this.edge;
    }
    
    public void setEdge(Edge edge) {
        this.edge = edge;
    }
    
    
}
