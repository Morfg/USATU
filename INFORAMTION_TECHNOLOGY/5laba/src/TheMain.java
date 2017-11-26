
 
import java.util.*;
 
public class TheMain
{
 
   // parse text line into tokens, e.g. "put salary 120.22" to "put" "salary" "120.22"
   public static Vector<String> parseTextToTokens( String text )
   {
      Vector<String> tokens = new Vector<String>();
      StringTokenizer st = new StringTokenizer(text);        
      while (st.hasMoreTokens())
      {
         tokens.add(st.nextToken());
      }
      return tokens;
   }
 
   // helper function: converts string to double if possible or returns null
   public static Double strToDouble( String s )
   {
      Double x = null;
      try
      {
         x = Double.parseDouble( s );
      }
      catch( NumberFormatException e )
      {
      }
      return x;
   }
 
   // print content of one node into human readable form
   public static void printTreeNode( CountingBST<String,Double>.Node node )
   {
      if ( node != null )
      {
         System.out.print( "(" );
         System.out.print( node.key );
         System.out.print( "->" );
         System.out.print( node.value );
         System.out.print( ")/" );
         System.out.print( node.count );
         System.out.println();
      }
      else
      {
         System.out.println("null");
      }
   }
   
   // main method with command line interpreter
   public static void main(String[] args)
   {
      CountingBST<String,Double> tree = new CountingBST<String,Double>(); 
      
      Scanner in = new Scanner(System.in);
      
      for(;;)
      {
        String inputLine = in.nextLine();
        if ( inputLine.isEmpty() )
        {
           continue;  
        }
        
        String cmd = null;
        String arg1 = null;
        String arg2 = null;
       
        {
           Vector<String> inputTokens = parseTextToTokens( inputLine );
           if ( inputTokens.size() > 0 ) cmd  = inputTokens.get(0);
           if ( inputTokens.size() > 1 ) arg1 = inputTokens.get(1);
           if ( inputTokens.size() > 2 ) arg2 = inputTokens.get(2);
        }
        
        if ( cmd.equals("exit") )
        {
           break;  
        }
        else
        if ( cmd.equals("print") )
        {
           tree.print();
        }
        else 
        if (cmd.equals("size"))
        {
           System.out.println(tree.size());
        }
        else
        if ( cmd.equals("put") )
        {
           String key   = ( arg1 != null && !arg1.isEmpty()) ? arg1 : null ;
           Double value = ( arg2 != null ) ? strToDouble( arg2 ) : null ;
           if ( key == null || value == null )
           {
              System.out.printf("*** ERROR: wrong arguments: <%s> <%s> <%s>\n",cmd,arg1,arg2);
              continue;
           }
           tree.put( key, value );
           System.out.println("Ok");
        }
        else if ( cmd.equals("get") )
        {
           String key   = ( arg1 != null && !arg1.isEmpty()) ? arg1 : null ;
           if ( key == null )
           {
              System.out.printf("*** ERROR: wrong arguments: <%s> <%d>\n",cmd,arg1);
              continue;
           }
           Double value = tree.get( key );
           System.out.println(value);
        }
        else if ( cmd.equals("delete") )
        {
           String key   = ( arg1 != null && !arg1.isEmpty()) ? arg1 : null ;
           if ( key == null )
           {
              System.out.printf("*** ERROR: wrong arguments: <%s> <%d>\n",cmd,arg1);
              continue;
           }
           tree.delete( key );
           System.out.println("Ok");
        }
        else if ( cmd.equals("min") )
        {
           printTreeNode( tree.min() );
        } 
        else if ( cmd.equals("max") )
        {
           printTreeNode( tree.max() );
        }
        
      }
      
      in.close();
 
  } 
   
}