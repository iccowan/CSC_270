import java.util.ArrayList;

public class Graph
{
    int verticies;
    double[][] edges;

    public Graph(int verticies) // 0(n^2) time where n = verticies
    {
        this.verticies = verticies;
        edges = new double[verticies][verticies];

        // Clear the edges array
        for(int i = 0; i < verticies; i++)
            for(int j = 0; j < verticies; j++)
                edges[i][j] = 0;
    }

    public void addEdge(int v1, int v2, double weight) // 0(1) time
    {
        if(v1 <= verticies && v2 <= verticies) edges[v1 - 1][v2 - 1] = weight;
    }

    public double getEdgeCost(int v1, int v2) // 0(1) time
    {
        if(v1 <= verticies && v2 <= verticies) return edges[v1 - 1][v2 - 1];
        else return -1.0;
    }

    public boolean reach(int v1, int v2) // 0(n^2) time where n = verticies
    {
        if(v1 == v2) return true;
        v1--; v2--;

        // Keep track of the visited nodes
        ArrayList<Integer> visitedNodes = new ArrayList<Integer>();

        // List for a queue
        ArrayList<Integer> queue = new ArrayList<Integer>();

        // BFS through the tree
        queue.add(v1);

        while(! queue.isEmpty())
        {
            // Pop off the queue
            int node = queue.get(0);
            queue.remove(0);
            visitedNodes.add(node);

            // Add children to the list only if they have not been visited
            // If one of the children is v2, then we know we have reached
            // v2 and we return true
            for(int i = 0; i < verticies; i++)
            {
                if((! visitedNodes.contains(i)) && edges[node][i] > 0.0)
                {
                    if(i == v2) return true;
                    queue.add(i);
                }
            }
        }

        // We didn't reach v2
        return false;
    }
}