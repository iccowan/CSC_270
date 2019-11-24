/*
   Test 3 Prep
   This is not a binary tree.
   Each node can have an arbitrary number of children.

   Study the code and infer the design.

   Then solve these problems:
   1. Write int numDesc(String label) returns the number of the node's descendants.
   2. Write int numAnc(String label) returns the number of the node's ancestors.
   3. Write int height() returns the height of the tree.

   numDesc() and numAnc() throw NodeNotFoundException if node with label doesn't exist.

   You will want to write your own test cases.
   Good luck!
*/

import java.util.ArrayList; // We use Java's class to store children
import java.util.List;

public class Tree
{
   /* Nested Node class */
   class Node
   {
      String label;
      List<Node> children;
      Node parent;

      Node(String s, Node parent) // constructor
      {
         label = s;
         children = new ArrayList<Node>();
         this.parent = parent;
      }

      void addChild(String label) // adds a new child with label
      {
         children.add(new Node(label, this));
      }

      Node getChild(String label) // returns the child with label
      {
         for (Node child : children)
         {
            if (child.label == label)
               return child;
         }
         return null; // no such child
      }

      int numDesc()
      {
         int totalChildren = children.size();
         for(Node child : children)
         {
            totalChildren += child.numDesc();
         }

         return totalChildren;
      }
   }

   /* Exception if node not found */
   class NodeNotFoundException extends Exception
   {
      public NodeNotFoundException() { super(); }
      public NodeNotFoundException(String s) { super(s); }
   }

   Node root; // There will always be a root

   public Tree(String label)
   {
      root = new Node(label, null); // There will always be a root node
   }

   /*
      Finds Node with label and inserts a new child.
      If label is null then the root is intended.
      Throws an exception if the position is
   */
   public void insert(String childLabel, String parentLabel) throws NodeNotFoundException
   {
      // call recursive helper function
      // if it returns false then child was not found
      // if it returns true then the action was successful
      if (! insert(childLabel, parentLabel, root))
          throw new NodeNotFoundException("Node " + parentLabel + " not found");
   }

   public boolean insert(String childLabel, String parentLabel, Node node)
   {
      if (node.label == parentLabel) // found node
      {
         System.out.println("Adding child");
         node.addChild(childLabel); // insert new child of parent
         return true;
      }
      else
      {
         for (Node child : node.children)
         {
            if (insert(childLabel, parentLabel, child))
               return true;
         }
         return false; // child not found among this node's descendants
      }
   }

   public void display()
   {
      display(root);
   }

   public void display(Node node)
   {
      System.out.print(node.label + ": ");
      if (node.children.isEmpty())
      {
         System.out.println("No children");
      }
      else
      {
         for (Node child : node.children)
            System.out.print(child.label + " ");
         System.out.println();
         for (Node child : node.children)
            display(child);
      }
   }

   /** MY CODE BEGINS HERE **/
   // Returns a node when it is found in the tree
   // If the node is not found, return null
   private Node seek(String label) throws NodeNotFoundException
   {
      // Let's find the node via BFS with this helper function
      // Throw an exception if it's not found
      Node returnNode = seek(root, label);
      if(returnNode == null) throw new NodeNotFoundException("No node with label " + label + " in tree");
      System.out.println(returnNode.label);
      return returnNode;
   }

   private Node seek(Node n, String label)
   {
      if(n.label.equals(label)) return n;
      else
      {
         Node findNode = null;
         for(Node child : n.children)
         {
            findNode = seek(child, label);
            if(findNode != null) break;
         }

         return findNode;
      }
   }

   public int numDesc(String label) throws NodeNotFoundException
   {
      return seek(label).numDesc();
   }

   public int numAnc(String label) throws NodeNotFoundException
   {
      // Let's seek out the node then go reverse through the parents
      // and keep a counter to find the total number of parents
      Node seekNode = seek(label);
      if(seekNode == null) throw new NodeNotFoundException("No node with label " + label + " in tree");

      return numAnc(seekNode);
   }

   private int numAnc(Node n)
   {
      int totalAnc = 0;
      while(n.parent != null)
      {
         totalAnc++;
         n = n.parent;
      }

      return totalAnc;
   }

   // Return the maxHeight of the tree
   public int height()
   {
       List<Node> nodeQueue = new ArrayList<Node>();
       nodeQueue.add(root);

       int totalNodes = 0;

       while(! nodeQueue.isEmpty())
       {
           Node nextNode = nodeQueue.get(0);
           nodeQueue.remove(0);
           totalNodes++;
           for(Node n : nextNode.children) nodeQueue.add(n);
       }

       return (int) (Math.log(totalNodes) / Math.log(2));
   }

   public static void main(String[] args) throws NodeNotFoundException
   {
      /* Creates and displays a simple tree */
      Tree t = new Tree("ROOT");
      t.insert("A", "ROOT");
      t.insert("B", "ROOT");
      t.insert("C", "ROOT");
      t.insert("D", "A");
      t.insert("E", "B");
      t.insert("F", "B");

      t.display();

      System.out.println(t.height());
   }
}
