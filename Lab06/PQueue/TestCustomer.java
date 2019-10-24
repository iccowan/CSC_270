import java.util.Comparator;

public class TestCustomer
{
   // Make the customers
   public static Customer[] makeCustomers()
   {
      // Create the 3 customers
      Customer customer1 = new Customer(1, 8, 3);
      Customer customer2 = new Customer(263, 6, 8);
      Customer customer3 = new Customer(263, 6, 10);
      
      // Put them into an array
      Customer[] customers = {customer1, customer2, customer3};
      
      return customers;
   }

   // Tests the worth comparator
   public static void testWorth(Customer[] customers)
   {
      // Create worth comparator
      Comparator<Customer> worthComparator = new Customer.WorthComparator();
      
      // Set the customers to variables
      Customer cust1 = customers[0];
      Customer cust2 = customers[1];
      Customer cust3 = customers[2];
      
      // Compare their worth
      assert worthComparator.compare(cust1, cust2) == -1 : "Customer 1 should be worth less than customer 2";
      assert worthComparator.compare(cust2, cust1) == 1 : "Customer 2 should be worth more than customer 1";
      assert worthComparator.compare(cust2, cust3) == 0 : "Customer 2 and customer 3 should be equal worth";
   }
   
   // Test the loyalty comparator
   public static void testYears(Customer[] customers)
   {
      // Create loyalty comparator
      Comparator<Customer> loyaltyComparator = new Customer.LoyaltyComparator();
   
      // Set the customers to variables
      Customer cust1 = customers[0];
      Customer cust2 = customers[1];
      Customer cust3 = customers[2];
      
      // Compare their years
      assert loyaltyComparator.compare(cust1, cust2) == 1 : "Customer 1 should be more loyal than customer 2";
      assert loyaltyComparator.compare(cust2, cust1) == -1 : "Customer 2 should be less loyal than customer 1";
      assert loyaltyComparator.compare(cust2, cust3) == 0 : "Customer 2 and customer 3 should be equal loyal";
   }
   
   // Test the worth/politeness comparator
   public static void testPoliteness(Customer[] customers)
   {
      // Create worth/politeness comparator
      Comparator<Customer> worthPoliteComparator = new Customer.WorthPoliteComparator();
   
      // Set the customers to variables
      Customer cust1 = customers[0];
      Customer cust2 = customers[1];
      Customer cust3 = customers[2];
      
      // Compare their years
      assert worthPoliteComparator.compare(cust1, cust2) == -1 : "Customer 1 should be worth less than customer 2";
      assert worthPoliteComparator.compare(cust2, cust1) == 1 : "Customer 2 should be worth more than customer 1";
      assert worthPoliteComparator.compare(cust2, cust3) == -1 : "Customer 2 and customer 3 should be equal worth, but customer 2 should be less polite than customer 3";
   }
   
   // Test the priority queue
   public static void testPQ(PriorityQueue<Customer> pq)
   {
      // Make a comparator for testing
      Comparator<Customer> worthPoliteComparator = new Customer.WorthPoliteComparator();
      
      // Make sure pushing still works
      pq.push(new Customer(15, 32, 65));
      
      // Now, test the customers
      Customer cust1 = pq.pop();
      Customer cust2 = pq.pop();
      Customer cust3 = pq.pop();
      
      assert worthPoliteComparator.compare(cust1, cust2) == 1 || worthPoliteComparator.compare(cust1, cust2) == 0 : "The first customer should have a higher or equal net worth than the second when popping from the PQueue";
      assert worthPoliteComparator.compare(cust2, cust3) == 1 || worthPoliteComparator.compare(cust2, cust3) == 0 : "The second customer should have a higher or equal net worth than the third when popping from the PQueue";
      assert worthPoliteComparator.compare(cust1, cust3) == 1 || worthPoliteComparator.compare(cust1, cust3) == 0 : "The first customer should have a higher or equal net worth than the third when popping from the PQueue";
      
      // Now, make sure pushing works again
      pq.pop();
      assert pq.isEmpty() : "The priority queue should be empty";
      Customer newCust = new Customer(16, 33, 66);
      pq.push(newCust);
      assert (! pq.isEmpty()) : "The priority queue should not be empty";
      assert newCust == pq.pop() : "The priority queue is not pushing correctly";
   }
   
   public static void main(String[] args)
   {
      Customer[] customers = makeCustomers();
      testWorth(customers);
      testYears(customers);
      testPoliteness(customers);
      
      // Now, test the priority queue
      Comparator<Customer> worthPoliteComparator = new Customer.WorthPoliteComparator();
      PriorityQueue<Customer> pq = new PriorityQueue<Customer>(worthPoliteComparator);
      for(Customer c : customers)
      {
         pq.push(c);
      }
      
      testPQ(pq);
   }
}