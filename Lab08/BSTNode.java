import java.lang.Comparable;
import java.util.function.Consumer;

/**
   This is a smart Node that ustilzies generics.
   Note how we ensured that the type T will always be comparable...

 */
public class BSTNode<T extends Comparable<T>>
{
   private T val;
   private BSTNode<T> left;
   private BSTNode<T> right;

   public BSTNode(T val)
   {
      this(val, null, null);
   }
   
   public BSTNode(T val, BSTNode<T> l, BSTNode<T> r)
   {
      this.val = val;
      this.left = l;
      this.right = r;
   }

   /*
     Uses recursion to insert the target into the tree
    */
   public void insert(T target)
   {
      if(this.val.compareTo(target) == 1 || this.val.equals(target))
      {
         if(this.left == null) { this.left = new BSTNode<T>(target); }
         else
         {
            this.left.insert(target);
         }
      }
      else
      {
         if(this.right == null) { this.right = new BSTNode<T>(target); }
         else
         {
            this.right.insert(target);
         }
      }
   }

   /*
     Uses recursion to rerived the value target from the tree.  
     Returns null if it can't find the value.
    */
   public T retrieve(T target)
   {
      if(this == null) { return null; }
      else if(this.val.equals(target)) { return target; }
      else
      {
         if(this.val.compareTo(target) == 1)
         {
            if(this.left == null) { return null; }
            return this.left.retrieve(target);
         }
         else
         {
            if(this.right == null) { return null; }
            return this.right.retrieve(target);
         }
      }
   }

    /**
       If it is present, what level is the node?
       If it is not present, what level would it be placed.
     */
   public int retrieveDepth(T target, int counter)
   {
      if(this == null) { return counter; }
      else if(this.val.equals(target)) { return counter; }
      else
      {
         if(this.val.compareTo(target) == 1)
         {
            if(this.left == null) { return counter + 1; }
            return this.left.retrieveDepth(target, counter + 1);
         }
         else
         {
            if(this.right == null) { return counter + 1; }
            return this.right.retrieveDepth(target, counter + 1);
         }
      }
   }

   /**
      Uses recursion to return the largest value in the tree
    */
   public T getLargest()
   {
      if(this.right == null) { return this.val; }
      else { return this.right.getLargest(); }
   }

   /**
      Uses recursion to do an inorder traverals.
      consume is part of a stratagy pattern, to determine what the "Visit" should be.
    */
   public void inOrderTraversal(Consumer<T> consume)
   {
      if(this.left != null) { this.left.inOrderTraversal(consume); }
         consume.accept(this.val);
      if(this.right != null) {this.right.inOrderTraversal(consume); }
   }

   /**
      returns true if this tree is equal to that tree.
      false otherwise.

      Note: While I must always be non-null.  
            Nothing prevents "that" from being null.
	    
	    This one is long!
    */
   public boolean myEquals(BSTNode<T> that)
   {
      if(that == null) { return false; }
      else
      {
         boolean leftEquals = false;
         boolean rightEquals = false;
         if(this.val.equals(that.val))
         {
            if(this.right != null) { rightEquals = this.right.myEquals(that.right); }
            else { rightEquals = this.right == that.right; }
            
            if(rightEquals)
            {
               if(this.left != null) { leftEquals = this.left.myEquals(that.left); }
               else { leftEquals = this.left == that.left; }
            }
         }
         
         if(leftEquals == true && rightEquals == true) { return true; }
         else { return false; }
      }
   }
}
