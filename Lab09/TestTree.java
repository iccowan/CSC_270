import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class TestTree
{

	Scanner comp;
	PrintStream me;
	boolean show = true; //if set to true, will print out respones to and from the game.  Set to false to make it faster.


    //initializes the Testing environment with piped streams (Queues)
	public TestTree() throws IOException
	{
		PipedOutputStream inputHandle = new PipedOutputStream();
		PipedInputStream input= new PipedInputStream(inputHandle);

		PipedOutputStream output = new PipedOutputStream();
		PipedInputStream outputHandle= new PipedInputStream(output);

		QTree game = new QTree(input,new PrintStream(output));

		Thread t = new Thread(()->{game.playGame();});
		t.start();

        comp = new Scanner(outputHandle);
		me = new PrintStream(inputHandle);


	}

    /*
        Helper methods for IO and testing

        These methods are beefed up versions of assert.

    */

    //Use this to "check" if the string from the program is correct.
	public void check(String s)
	{
		String observed = comp.nextLine();
		if(show) { System.out.println("observed:" + observed); }
		//will not work with simple assert statements due to multithreading
		if( ! observed.equals(s))
		{
			System.out.println("expected " + s + " but got "+observed);
			System.exit(1);
		}
	}

	public void say(String s)
	{
		me.println(s);
		me.flush(); //greatly increases speed of program, lets other side know there is new data.
		if(show) { System.out.println("said:" + s); }
	}

	public void run()
	{
		check(Strings.IS_IT_ALIVE);
      say("Y");
      //now what? Think of all the input and outputs here...
		check(Strings.IS_IT_A + Strings.DUCK + "?");
      say("Y");

      check(Strings.I_WIN);
      check(Strings.PLAY_AGAIN);
      say("Y");

      check(Strings.IS_IT_ALIVE);
      say("N");

      check(Strings.IS_IT_A + Strings.ROCK + "?");
      say("Y");

      check(Strings.I_WIN);
      check(Strings.PLAY_AGAIN);
      say("Y");

      check(Strings.IS_IT_ALIVE);
      say("Y");

      check(Strings.IS_IT_A + Strings.DUCK + "?");
      say("N");

      check(Strings.WHAT_IS_THE_ANSWER);
      say("Penguin");

      check(Strings.NEW_QUESTION + "Duck and a Penguin");
      say("Does it like the cold?");

      check("Answering yes to Does it like the cold? means Penguin?");
      say("Y");

      check(Strings.THANKS);
      check(Strings.PLAY_AGAIN);
      say("Y");

      check(Strings.IS_IT_ALIVE);
      say("Y");

      check("Does it like the cold?");
      say("Y");

      check(Strings.IS_IT_A + "Penguin?");
      say("Y");

      check(Strings.I_WIN);

      check(Strings.PLAY_AGAIN);
      say("Y");

      check(Strings.IS_IT_ALIVE);
      say("Y");

      check("Does it like the cold?");
      say("N");

      check(Strings.IS_IT_A + "Duck?");
      say("Y");

       check(Strings.I_WIN);
      check(Strings.PLAY_AGAIN);
      say("Y");

      check(Strings.IS_IT_ALIVE);
      say("N");

      check(Strings.IS_IT_A + Strings.ROCK + "?");
      say("N");

      check(Strings.WHAT_IS_THE_ANSWER);
      say("Chair");

      check(Strings.NEW_QUESTION + "Rock and a Chair");
      say("Can you throw it?");

      check("Answering yes to Can you throw it? means Chair?");
      say("Y");

      check(Strings.THANKS);
      check(Strings.PLAY_AGAIN);
      say("Y");

      check(Strings.IS_IT_ALIVE);
      say("N");

      check("Can you throw it?");
      say("Y");

      check(Strings.IS_IT_A + "Chair?");
      say("Y");

      check(Strings.I_WIN);
      
      check(Strings.PLAY_AGAIN);
      say("Y");
      
      check(Strings.IS_IT_ALIVE);
      say("N");
      
      check("Can you throw it?");
      say("Y");
      
      check(Strings.IS_IT_A + "Chair?");
      say("N");
      
      check(Strings.WHAT_IS_THE_ANSWER);
      say("Football");

      check(Strings.NEW_QUESTION + "Chair and a Football");
      say("Can you eat it?");

      check("Answering yes to Can you eat it? means Football?");
      say("N");
      
      check(Strings.THANKS);
      check(Strings.PLAY_AGAIN);
      say("Y");
      
      check(Strings.IS_IT_ALIVE);
      say("N");
      
      check("Can you throw it?");
      say("Y");
      
      check("Can you eat it?");
      say("N");
      
      check(Strings.IS_IT_A + "Football?");
      say("Y");
      
      check(Strings.I_WIN);     
      
      
      
      
      
      
      
// 
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
//       check(Strings.IS_IT_ALIVE);
//       say("N");
// 
//       check("Can you throw it?");
//       say("N");
// 
//       check(Strings.IS_IT_A + Strings.ROCK + "?");
//       say("Y");
// 
//       check(Strings.I_WIN);
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
//       check(Strings.IS_IT_ALIVE);
//       say("Y");
// 
//       check("Does it like the cold?");
//       say("Y");
// 
//       check(Strings.IS_IT_A + "Penguin?");
//       say("Y");
// 
//       check(Strings.I_WIN);
// 
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
//       check(Strings.IS_IT_ALIVE);
//       say("Y");
// 
//       check("Does it like the cold?");
//       say("Y");
// 
//       check(Strings.IS_IT_A + "Penguin?");
//       say("N");
// 
//       check(Strings.WHAT_IS_THE_ANSWER);
//       say("Polar Bear");
// 
//       check(Strings.NEW_QUESTION + "Penguin and a Polar Bear");
//       say("Does it have fur?");
// 
//       check("Answering yes to Does it have fur? means Polar Bear?");
//       say("Y");
// 
//       check(Strings.THANKS);
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
//       check(Strings.IS_IT_ALIVE);
//       say("Y");
// 
//       check("Does it like the cold?");
//       say("Y");
// 
//       check("Does it have fur?");
//       say("Y");
// 
//       check(Strings.IS_IT_A + "Polar Bear?");
//       say("Y");
// 
//       check(Strings.I_WIN);
// 
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
//       check(Strings.IS_IT_ALIVE);
//       say("Y");
// 
//       check("Does it like the cold?");
//       say("Y");
// 
//       check("Does it have fur?");
//       say("N");
// 
//       check(Strings.IS_IT_A + "Penguin?");
//       say("Y");
// 
//       check(Strings.I_WIN);
// 
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
//       check(Strings.IS_IT_ALIVE);
//       say("Y");
// 
//       check("Does it like the cold?");
//       say("N");
// 
//       check(Strings.IS_IT_A + Strings.DUCK + "?");
//       say("N");
// 
//       check(Strings.WHAT_IS_THE_ANSWER);
//       say("Squirrel");
// 
//       check(Strings.NEW_QUESTION + "Duck and a Squirrel");
//       say("Does it like nuts?");
// 
//       check("Answering yes to Does it like nuts? means Squirrel?");
//       say("Y");
// 
//       check(Strings.THANKS);
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
//       check(Strings.IS_IT_ALIVE);
//       say("Y");
// 
//       check("Does it like the cold?");
//       say("N");
// 
//       check("Does it like nuts?");
//       say("Y");
// 
//       check(Strings.IS_IT_A + "Squirrel?");
//       say("Y");
// 
//       check(Strings.I_WIN);
//       check(Strings.PLAY_AGAIN);
//       say("Y");
// 
// 	  check(Strings.IS_IT_ALIVE);
// 	  say("N");
// 
// 	  check("Can you throw it?");
// 	  say("N");
// 
// 	  check(Strings.IS_IT_A + Strings.ROCK + "?");
// 	  say("Y");
// 
// 	  check(Strings.I_WIN);
// 	  check(Strings.PLAY_AGAIN);
// 	  say("Y");
// 
// 	  check(Strings.IS_IT_ALIVE);
//       say("Y");
// 
//       check("Does it like the cold?");
//       say("N");
// 
//       check("Does it like nuts?");
//       say("N");
// 
//       check(Strings.IS_IT_A + "Duck?");
//       say("Y");
// 
// 	  check(Strings.I_WIN);
	  check(Strings.PLAY_AGAIN);
	  say("N");

      //close the streams at the end to enrue good behavior.
		comp.close();
		me.close();
	}

	public static void main(String[] args)
	{
		try
		{
			TestTree test = new TestTree();
			test.run();
		} catch (IOException e)
		{
			e.printStackTrace();
		}


	}


}
