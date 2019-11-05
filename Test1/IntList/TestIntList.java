public class TestIntList
{
   public static void main(String[] args)
   {
      IntList myList1 = new IntList(10);
      IntList myList2 = new IntList(3);
      
      myList1.append(1);
      myList1.append(3);
      myList1.append(10);
      
      myList2.append(2);
      myList2.append(5);
      myList2.append(22);
      
      // Should be {1, 3, 10, 2, 5, 22}
      System.out.println("myList1: " + myList1);
      System.out.println("myList2: " + myList2);
      myList1.concat(myList2);
      System.out.println("myList1 + myList2: " + myList1);
   }
}