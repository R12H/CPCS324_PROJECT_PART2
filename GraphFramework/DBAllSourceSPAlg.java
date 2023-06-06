/* Team members:
Raghad Hawsawi 2105869 - Najd Khalid 2006156 - Wed Aljahdali 2105502 - Renad Baghdadi 2006538

Resources
1)  Levitin, A. (2012). Introduction to the design and analysis of algorithms. Pearson.
2)  Dijkstra Algorithm: https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-in-java-using-priorityqueue/

Section:
CP1
 */
package GraphFramework;

public class DBAllSourceSPAlg extends ShortestPathAlgorithm {

    public DBAllSourceSPAlg(Graph graph) {
        super(graph);
    }

    public void computeDijkstraBasedSPAlg() throws CloneNotSupportedException {
        
        
        //Create object of one source dijkstra to compute fro i to other vertecies
        SingleSourceSPAlg dijkstraOneSourse = new SingleSourceSPAlg(super.gragh);
        
        for (int i = 0; i < super.gragh.verticesNo; i++) {

            dijkstraOneSourse.computeDijkstraAlg(super.gragh.vertices.get(i));

            System.out.println("\n    The starting point location is " + super.gragh.vertices.get(i).getLabel());
            
            /**Run the algorithm if the program read from file to save time
             * Note that u can delete if statement if you wanna see cases paths
             */
             
            if(super.gragh.verticesNo < 2000)
                dijkstraOneSourse.displayResultingMST();
            
            System.out.println("\n    ---------------------------");

        }

    }
}
