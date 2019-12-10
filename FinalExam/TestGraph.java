public class TestGraph
{
    public static void main(String[] args)
    {
        Graph myGraph = new Graph(1000000);

        myGraph.addEdge(1, 20, 1.0);

        System.out.println(myGraph.reach(1, 10));
        System.out.println(myGraph.reach(1, 20));
        System.out.println(myGraph.reach(1, 1));
    }
}