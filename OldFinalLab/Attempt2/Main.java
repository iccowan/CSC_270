import java.util.concurrent.TimeUnit;

public class Main
{
    public static void BFS(String stringForLock, int length)
    {
        // Create a lock
        TheLock lock = new TheLock(stringForLock, length);
        LockTree unlock = new LockTree();

        // Unlock the lock via BFS
        // Keep track of the time to unlock
        long start = System.nanoTime();
        Path unlockedPath = unlock.breadthFirstUnlock(lock);
        long end = System.nanoTime();
        long timeMS = TimeUnit.NANOSECONDS.toMillis(end - start);

        // Display some information!
        System.out.println("Steps to unlock: " + unlockedPath.getSize());
        System.out.println("Iterations to unlock: " + unlock.numOfOps());
        System.out.println("Node visits to unlock: " + unlock.numOfNodeVisits());
        while(! unlockedPath.isEmpty())
        {
            System.out.print(unlockedPath.pop());
            if(! unlockedPath.isEmpty()) System.out.print(", ");
        }
        System.out.println();
        System.out.println("Time to unlock: " + timeMS + "ms");
    }

    public static void main(String[] args)
    {
        // Get the appropiate variables as inputted
        String stringForLock = args[0];
        int length = Integer.parseInt(args[1]);

        // BFS
        System.out.println();
        System.out.println("------ BREADTH FIRST SEARCH ------");
        BFS(stringForLock, length);
        System.out.println("----------------------------------");
        System.out.println();
    }
}
