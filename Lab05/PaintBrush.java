import java.util.Stack;
import javafx.scene.paint.Color;


public class PaintBrush
{

	
	Paint paint;
	int mode;

	public final static int paintMode = 1;
	public final static int fillMode = 2;
	public final static int pattern1Mode = 3;
	public final static int pattern2Mode = 4;
	
	Paint Gold = new PaintColor(Color.GOLD);
	Paint White = new PaintColor(Color.WHITE);
	
	
/**
set the "paint" for the paintbrush
*/	
	public void setPaint(Paint paint)
	{
      this.paint = paint;
	}


/*
   gets the present paint on the paint brush
*/
	public Paint getPaint()
	{
		return paint;
	}
	
   
   /*
   makes the paint on the paint brush a brigter shade.
   */
	public void setBrighter()
	{		
      this.paint = new PaintBrighter(paint);
	}


   /*
      makes the paint on the paintbrush a darker shade
   */
	public void setDarker()
	{
		this.paint = new PaintDarker(paint);
	}


   /*
      paints the mesh, usign the current paint and mode at point x,y
   */
	public void paint(int x, int y, Paint[][] mesh)
	{
      // Set the max XY that can happen
      int maxXY = mesh.length - 1;
      
      // Get the starting color for comparison
      Paint startPaint = new PaintColor(mesh[x][y].getColor());
      
      // Check for which mode the user has selected
      if(mode == 1)
      {
		   this.paintPoint(mesh, x, y);
      }
      else if(mode == 2 || mode == 3)
      {
         this.pattern2(mesh, x, y, maxXY, startPaint);
      }
      else if (mode==4)
      {
         this.pattern2(mesh,x,y,maxXY,startPaint);
      }
	}
   
   // Paints a specific point
   public void paintPoint(Paint[][] mesh, int i, int j)
   {
      // Centre College pattern if the mode is set
      if(mode == 3)
      {
         if(i % 2 != 0)
         {
            mesh[i][j] = Gold;
         }
         else
         {
            mesh[i][j] = White;
         }
      }
      else
      {
         // If not, paint the color that is set in the settings
         mesh[i][j] = new PaintColor(paint.getColor());
      }
   }
   
   // Fills around a point
   public void paintFill(Paint[][] mesh, int x, int y, int maxXY, Paint startPaint)
   {
      // Base Case
      if(x < 0 || y < 0 || x > maxXY || y > maxXY)
      {
         return;
      }
      else
      {
         if(mesh[x][y].equals(startPaint))
         {
            this.paintPoint(mesh, x, y);
            
            //Recursion for each of the pixels around the one changing
            paintFill(mesh, x + 1, y, maxXY, startPaint);
            paintFill(mesh, x - 1, y, maxXY, startPaint);
            paintFill(mesh, x, y + 1, maxXY, startPaint);
            paintFill(mesh, x, y - 1, maxXY, startPaint);
            paintFill(mesh, x + 1, y + 1, maxXY, startPaint);
            paintFill(mesh, x - 1, y + 1, maxXY, startPaint);
            paintFill(mesh, x - 1, y - 1, maxXY, startPaint);
            paintFill(mesh, x + 1, y - 1, maxXY, startPaint);
         }
      }
   }
   
   public void pattern2(Paint[][] mesh, int x, int y, int maxXY, Paint startPaint)
   {
      // Node class for storing the appropiate information
      class Node
      {
         // public to save lines of code. Also will only be used within this method
         // Not able to be misused
         public int x;
         public int y;
         public Paint p;
         public int pos=0;
         
         // Constructor
         public Node(int x, int y,Paint p)
         {
            this.x=x;
            this.y=y;
            this.p=p;
          } 
      }
      
      // Create the stack
      Stack<Node> fill=new Stack<Node>();
 
      // Push the first Node to the stack
      fill.push(new Node(x,y,mesh[x][y]));
      
      // Loop until the stack is empty
      while(!fill.empty()){
         // Pop the top off to let us work with it
         Node change=fill.pop();

         // Check the 4 pixels around the changing pixel
         // If the color remains the same, add it to the stack to continue through
         if (! (change.x+1>maxXY))
         {
            if (mesh[change.x+1][change.y].equals(startPaint))
            {
               fill.push(new Node(change.x+1,change.y,mesh[change.x+1][change.y]));
            }
         }
            
         if (! (change.x-1<0))
         { 
            if (mesh[change.x-1][change.y].equals(startPaint))
            {
               fill.push(new Node(change.x-1,change.y,mesh[change.x-1][change.y]));
            }
          }
          
          if(! (change.y+1>maxXY))
          { 
            if (mesh[change.x][change.y+1].equals(startPaint))
            {
               fill.push(new Node(change.x,change.y+1,mesh[change.x][change.y+1]));
            }
          }
          
          if(! (change.y-1<0))
          {
             if (mesh[change.x][change.y-1].equals(startPaint))
             {
                fill.push(new Node(change.x,change.y-1,mesh[change.x][change.y-1]));
             }
          }
          
          // Finally, paint the point that we're checking the adjacent pixels for
          this.paintPoint(mesh, change.x, change.y);
        }
   }
   
   

	
	
/*
   set the drawing mode of the paint brush.
*/
	public void pointMode()
	{
		mode = paintMode;
	}

	public void fillMode()
	{
		mode = fillMode;
	}

	public void pattern1Mode()
	{
		mode = pattern1Mode;
	}

	public void pattern2Mode()
	{
		mode = pattern2Mode;
	}

}
