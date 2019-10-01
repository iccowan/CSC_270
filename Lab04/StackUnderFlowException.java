import java.lang.RuntimeException;

public class StackUnderFlowException extends RuntimeException
{


   public StackUnderFlowException()
   {
      super();
   }


   public StackUnderFlowException(String message)
   {
      super(message);
   }

}
