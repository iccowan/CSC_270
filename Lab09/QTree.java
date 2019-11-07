import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class QTree
{

	private Scanner in;
	private PrintStream out;
   private Node root;
	
   //initializes the game
	public QTree(InputStream in, PrintStream out)
	{
		this.out = out;
		this.in = new Scanner(in);
      
		//Please initialize your data here
      Node yes = new Node(Strings.DUCK, false);
      Node no = new Node(Strings.ROCK, false);
      root = new Node(Strings.IS_IT_ALIVE, true, yes, no);
	}
   
   // Asks the user a question
   public void askUser(Node currentNode)
   {
      // Check to see if the current node is a question
      // and print the appropiate thing
      if(currentNode.isQuestion)
      {
         out.print(currentNode.value + "\n");
      }
      else
      {
         out.print(Strings.IS_IT_A + currentNode.value + "?\n");
      }
      out.flush();
   }
	
   // Gets a response from the user
   public String getResponse() { return in.nextLine(); }
   
   // Ends the game with a win
   public void endGameWin()
   {
      out.print(Strings.I_WIN + "\n"); out.flush();
      out.print(Strings.PLAY_AGAIN + "\n"); out.flush();
      if(getResponse().toUpperCase().equals("Y")) { playGame(); }
   }
   
   // Gets a new question from the user
   public void getNewQuestion(Node lastNode)
   {
      // Get the appropiate information from the user
      out.print(Strings.WHAT_IS_THE_ANSWER + "\n"); out.flush();
      String newAnswer = getResponse();
      out.print(Strings.NEW_QUESTION + lastNode.value + " and a " + newAnswer + "\n"); out.flush();
      String newQuestion = getResponse();
      out.print("Answering yes to " + newQuestion + " means " + newAnswer + "?\n"); out.flush();
      String isYesAnswer = getResponse();
      
      // Change some Nodes around
      String tempVal = lastNode.value;
      lastNode.value = newQuestion;
      lastNode.isQuestion = true;
      Node copyOfLastNode = new Node(tempVal, false);
      Node newNode = new Node(newAnswer, false);
      
      // Create the new links as appropiate
      if(isYesAnswer.toUpperCase().equals("Y"))
      {
         lastNode.yes = newNode;
         lastNode.no = copyOfLastNode;
      }
      else
      {
         lastNode.yes = copyOfLastNode;
         lastNode.no = newNode;
      }
      
      // Thank the user and see if they want to play again
      out.print(Strings.THANKS + "\n"); out.flush();
      out.print(Strings.PLAY_AGAIN + "\n"); out.flush();
      if(getResponse().toUpperCase().equals("Y")) { playGame(); }
   }
    
   //plays the game, be sure to grab input from the Scanner "in", and send your output to "out".
	public void playGame() { playGame(root); }
   public void playGame(Node currentNode)
   {
      // Ask the user depending on the current node's state
      askUser(currentNode);
      String answer = getResponse();
      
      // Do one thing if the current node is a questino
      // Do another if the current node is an answer
      if(currentNode.isQuestion)
      {
         if(answer.toUpperCase().equals("Y")) { playGame(currentNode.yes); }
         else { playGame(currentNode.no); }
      }
      else
      {
         if(answer.toUpperCase().equals("Y")) { endGameWin(); }
         else { getNewQuestion(currentNode); }
      }
   }
	
   // Play the game!
	public static void main(String[] args)
	{
		QTree t = new QTree(System.in, System.out);
		t.playGame();
	}
	
}

// Nodes to store the questions and answers
class Node {

   public String value;
   public boolean isQuestion;
   public Node yes = null;
   public Node no = null;
   
   // Constructor with no yes/no values
   public Node(String value, boolean isQuestion) {
      this.value = value;
      this.isQuestion = isQuestion;
   }
   
   // Constructor with yes/no values
   public Node(String value, boolean isQuestion, Node yes, Node no) {
      this.value = value;
      this.isQuestion = isQuestion;
      this.yes = yes;
      this.no = no;
   }
}
