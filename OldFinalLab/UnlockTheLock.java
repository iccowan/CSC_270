import java.util.concurrent.TimeUnit;

public class UnlockTheLock
{
    private TheLock lock;
    private LockTree unlockTree = new LockTree();
    private int iteration = 0;

    public UnlockTheLock(String lockString, int lockLength)
    {
        if(lockLength == 0) lock = new TheLock(lockString);
        else lock = new TheLock(lockString, lockLength);
    }

    private void performAction(String action)
    {
        switch(action) {
            case LockTree.TWIST:
                lock.twistIt();
                break;
            case LockTree.POKE:
                lock.pokeIt();
                break;
            case LockTree.PULL:
                lock.pullIt();
                break;
            case LockTree.SHAKE:
                lock.shakeIt();
                break;
        }
    }

    public boolean testPath(Path path)
    {
        lock.resetLock();
        while(! path.isEmpty()) performAction(path.pop());
        return lock.isUnlocked();
    }

    private Path solveLock()
    {
        boolean isSolved = false;
        Path path = new Path();
        while(! isSolved)
        {
            iteration++;
            path = unlockTree.getNextPath();
            isSolved = testPath(path);
        }

        return path;
    }

    public int getNodeVisits() { return unlockTree.nodeVisits; }

    public static void main(String[] args)
    {
        // Create a lock
        UnlockTheLock unlockIt = new UnlockTheLock(args[0], Integer.parseInt(args[1]));
        long start = System.nanoTime();
        Path solvedPath = unlockIt.solveLock();
        long end = System.nanoTime();
        long diff = end - start;
        System.out.println("Time to solve: " + TimeUnit.NANOSECONDS.toSeconds(diff) + "s");
        System.out.println("Time to solve: " + TimeUnit.NANOSECONDS.toMillis(diff) + "ms");
        System.out.println("The lock was solved in " + unlockIt.iteration + " iterations!");
        System.out.println("Node visits: " + unlockIt.getNodeVisits());
        System.out.println("Path length: " + solvedPath.getArchive().getLength());
    }
}
