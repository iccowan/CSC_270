import java.util.LinkedList;

public class LockTree
{
    private Node root;
    private LinkedList<Integer> nextLocation = new LinkedList<Integer>();
    public int nodeVisits = 0;

    // Possible methods for the nodes
    static final String DUMMY = "DUMMY";
    static final String TWIST = "TWIST"; // child 0
    static final String POKE = "POKE"; // child 1
    static final String PULL = "PULL"; // child 2
    static final String SHAKE = "SHAKE"; // child 3

    public LockTree()
    {
        // Create the dummy root node
        root = new Node(DUMMY);
        root.visitNode();
        nextLocation.add(0);
    }

    public void incrementNextLocation(int i)
    {
        nextLocation.set(i, nextLocation.get(i) + 1);
        if(nextLocation.get(i) == 4)
        {
            nextLocation.set(i, 0);
            if(i == 0)
            {
                nextLocation.add(0);
            }
            else {
                incrementNextLocation(i - 1);
            }
        }
    }

    public Path getNextPath()
    {
        // Find the first unvisited node and visit it
        // If all the nodes have been visited, move on to the next branch
        Path nextPath = new Path();
        Node currentNode = root;
        Node child;
        for(int i = 0; i < nextLocation.size(); i++)
        {
            currentNode.visitNode();
            nodeVisits++;
            child = currentNode.children[nextLocation.get(i)];
            nextPath.addAction(child.method);
            currentNode = child;
        }

        // Increment the nextLocation
        incrementNextLocation(nextLocation.size() - 1);

        return nextPath;
    }
}

class Node
{
    public Node[] children = new Node[4];
    public String method;
    public boolean visited = false;

    public Node(String method)
    {
        this.method = method;
    }

    public void visitNode()
    {
        visited = true;

        // Upon visiting, create the children nodes
        children[0] = new Node(LockTree.TWIST);
        children[1] = new Node(LockTree.POKE);
        children[2] = new Node(LockTree.PULL);
        children[3] = new Node(LockTree.SHAKE);
    }
}
