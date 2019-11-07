import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TestBST
{
   public static void findLargest(BSTree myTree)
   {
      Random rand = new Random();
      BSTree lastTree = myTree;
      for(int i=0; i<50; i++)
      {
         int largest = 0; 
         int sum = 0;
         BSTree tree = new BSTree();
         for(int j=0; j<50; j++)
         {
            int randNum = rand.nextInt();
            tree.insert(randNum);
            sum = sum + randNum;
            if(randNum>largest)
            {
               largest = randNum;
            }
         }
         assert tree.largest() == largest;
         assert tree.sum() == sum;
         assert tree.myEquals(lastTree) == false;
         lastTree = tree;
      }
   }
   
   public static void treeEquals(BSTree t1, BSTree t2, boolean equal)
   {
      assert t1.myEquals(t2) == equal;
      assert t2.myEquals(t1) == equal;
   }
   
   public static BSTree createTree(int[] array)
   {
      BSTree newTree = new BSTree();
      for(int i : array)
      {
         newTree.insert(i);
      }
      
      return newTree;
   }
   
   public static void testWeirdCases()
   {
      BSTree tree1 = new BSTree();
      BSTree tree2 = new BSTree();
      BSTree tree3 = new BSTree();
      BSTree tree4 = new BSTree();
      
      assert tree1.myEquals(tree2);
      
      tree1.insert(10);
      assert (! tree1.myEquals(tree2));
      
      tree2.insert(20);
      tree2.insert(10);
      assert (! tree1.myEquals(tree2));
      assert (! tree2.myEquals(tree1));
      
      tree1.insert(20);
      assert (! tree1.myEquals(tree2));
      assert (! tree2.myEquals(tree1));
      
      tree3.insert(10);
      tree3.insert(5);
      assert (! tree3.myEquals(tree1));
      assert (! tree1.myEquals(tree3));
      assert (! tree3.myEquals(tree2));
      assert (! tree2.myEquals(tree3));
      
      tree4.insert(10);
      tree4.insert(10);
      tree4.insert(20);
      
      assert (! tree4.myEquals(tree1));
      assert (! tree1.myEquals(tree4));
      
      int[] A = {50, 72, 96, 94, 107, 26, 12, 11, 9, 10, 25, 51, 16, 17, 95};
      BSTree tA = createTree(A);
      
      int[] B = {50, 72, 96, 94, 107, 26, 12, 11, 9, 25, 51, 16, 17, 95};
      BSTree tB = createTree(B);
      
      int[] C = {50, 72, 96, 94, 107, 26, 12, 11, 9, 10, 25, 51, 16, 17, 95, 18};
      BSTree tC = createTree(C);
      
      int[] D = {50, 72, 96, 94, 107, 26, 12, 11, 9, 10, 25, 16, 17, 95};
      BSTree tD = createTree(D);
      
      int[] E = {50, 72, 96, 94, 107, 26, 12, 11, 9, 10, 25, 51, 16, 17, 95, 51};
      BSTree tE = createTree(E);
      
      treeEquals(tA, tB, false);
      treeEquals(tA, tC, false);
      treeEquals(tA, tD, false);
      treeEquals(tA, tE, false);
   }

   public static void main(String[] args)
   {
      BSTree tree1 = new BSTree();
      assert tree1.isEmpty() == true;
      assert tree1.getSize() == 0;
      assert tree1.myEquals(tree1) == true;
      
      //tree 2
      BSTree tree2 = new BSTree();
      assert tree1.myEquals(tree2) == true;
      
      tree1.insert(10);
      assert tree1.isEmpty() == false;
      
      assert tree1.myEquals(tree2) == false; 
      assert tree2.myEquals(tree1) == false;
      
      //tree 1
      tree1.insert(4);
      tree1.insert(2);
      assert tree1.myEquals(tree2) == false;
      assert tree2.myEquals(tree1) == false;
      tree1.insert(30);
      tree1.insert(8);
      assert tree1.myEquals(tree2) == false;
      assert tree2.myEquals(tree1) == false;
      tree1.insert(22);
      
      List<Integer> list1 = new ArrayList<Integer>();
      list1.add(2);
      list1.add(4);
      list1.add(8);
      list1.add(10);
      list1.add(22);
      list1.add(30);
      
      // tree 2
      tree2.insert(10);
      assert tree1.myEquals(tree2) == false;
      assert tree2.myEquals(tree1) == false;
      tree2.insert(4);
      tree2.insert(2);
      assert tree1.myEquals(tree2) == false;
      assert tree2.myEquals(tree1) == false;
      tree2.insert(30);
      tree2.insert(8);
      assert tree1.myEquals(tree2) == false;
      assert tree2.myEquals(tree1) == false;
      
      tree2.insert(22);
      assert tree1.myEquals(tree2) == true;
      assert tree2.myEquals(tree1) == true;
      
      //random
      findLargest(tree1);   
      
      assert tree1.retrieve(10) == 10;
      assert tree1.retrieve(4) == 4;
      assert tree1.retrieve(22) == 22;
      assert tree1.retrieve(11) == null;
      
      assert tree1.myEquals(tree2) == true;
      assert tree2.myEquals(tree1) == true;
      
      assert tree1.retrieveDepth(10) == 0;
      assert tree1.retrieveDepth(30) == 1;
      assert tree1.retrieveDepth(8) == 2;
      assert tree1.retrieveDepth(9) == 3;
      
      assert tree1.myEquals(tree2) == true;
      assert tree2.myEquals(tree1) == true;
      assert tree1.myEquals(tree1) == true;
      
      assert tree1.getSize() == 6;
      assert tree1.largest() == 30;
      
      assert tree1.toList().equals(list1);
      
      assert tree1.sum() == 76;
      assert tree1.sum() == tree2.sum();
      
      //tree 3
      BSTree tree3 = new BSTree();
      //tree3.insert(1);
      tree3.insert(3);
      tree3.insert(5);
      
      //tree 4
      BSTree tree4 = new BSTree();
      tree4.insert(3);
      tree4.insert(1);
      //tree4.insert(5);
      
      assert tree3.myEquals(tree4) == false;
      
      //tree 5
      BSTree tree5 = new BSTree();
      tree5.insert(3);
      tree5.insert(2);
      tree5.insert(4);
      tree5.insert(1);
      
      //tree 6
      BSTree tree6 = new BSTree();
      tree6.insert(3);
      tree6.insert(2);
      tree6.insert(4);

      assert tree5.myEquals(tree6) == false;
      assert tree6.myEquals(tree5) == false; 
      
      //tree 7
      BSTree tree7 = new BSTree();
      tree7.insert(3);
      tree7.insert(1);
      tree7.insert(4);
      assert tree6.myEquals(tree7) == false;
      assert tree7.myEquals(tree6) == false;
      
      //tree 8
      BSTree tree8 = new BSTree();
      tree8.insert(3);
      tree8.insert(4);
      assert tree7.myEquals(tree8) == false;
      assert tree8.myEquals(tree7) == false;
      
      testWeirdCases();
   }
}