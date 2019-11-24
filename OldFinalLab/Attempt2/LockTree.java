public class LockTree
{
    private final String ROOT = "ROOT";
    private final String TWIST = "TWIST";
    private final String POKE = "POKE";
    private final String PULL = "PULL";
    private final String SHAKE = "SHAKE";

    // Create a custom node for the tree
    class TreeNode
    {
        TreeNode[] children = null;
        String action;
        Path pathToNode = new Path();

        TreeNode(String action) { this.action = action; }

        void visit()
        {
            TreeNode[] childs = new TreeNode[4];
            childs[0] = new TreeNode(TWIST);
            childs[1] = new TreeNode(POKE);
            childs[2] = new TreeNode(PULL);
            childs[3] = new TreeNode(SHAKE);

            children = childs;
        }

        void appendToPath() { pathToNode.add(action); }
    }

    class Counter { int count = 0; public Counter() {} }

    // Root of the tree
    private TreeNode root = new TreeNode(ROOT);
    private Counter iterations = new Counter();
    private Counter nodeVisits = new Counter();

    public LockTree() {}

    public Path breadthFirstUnlock(TheLock lock)
    {
        if(lock.isUnlocked()) return new Path();
        lock.resetLock();

        // We keep track

        // Begin the BFS here
        Queue<TreeNode> bQueue = new Queue<TreeNode>();
        bQueue.add(root);

        // Loop until we finally unlock the lock!
        // Once the lock is unlocked, we shouldn't get here
        // But at least the loop will end if it gets unlocked
        // and something breaks.
        while(! lock.isUnlocked())
        {
            TreeNode currentNode = bQueue.pop();
            currentNode.visit();

            // Add each iteration to the counter
            iterations.count++;

            for(TreeNode n : currentNode.children)
            {
                bQueue.add(n);
                n.pathToNode = currentNode.pathToNode.copy();
                n.appendToPath();
                nodeVisits.count++;

                // Test the path and if it works, return the path
                if(test(n.pathToNode, lock)) return n.pathToNode;
            }
        }

        // We should never get here. The lock should be solved
        // within the while loop eventually
        return new Path();
    }

    public boolean test(Path path, TheLock lock)
    {
        // Reset the lock and copy the path for good measures
        lock.resetLock();
        path = path.copy();

        while(! path.isEmpty()) performAction(path.pop(), lock);
        return lock.isUnlocked();
    }

    private void performAction(String action, TheLock lock)
    {
        switch(action) {
            case TWIST:
                lock.twistIt();
                break;
            case POKE:
                lock.pokeIt();
                break;
            case PULL:
                lock.pullIt();
                break;
            case SHAKE:
                lock.shakeIt();
                break;
        }
    }

    public int numOfOps() { return iterations.count; }
    public int numOfNodeVisits() { return nodeVisits.count; }
}
