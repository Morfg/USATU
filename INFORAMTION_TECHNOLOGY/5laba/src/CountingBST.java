
 
class CountingBST<Key extends Comparable<Key>, Value>
{
 
   // --------------------------------------------------------------------------
   public class Node
   {
      Key key;
      Value value;
      Node left, right;
      int count;
 
      public Node( Key key, Value value, int count)
      {
         this.key = key;
         this.value = value;
         this.left = this.right = null;
         this.count = count;
      }
   }
 
   private Node root;
 
   // --------------------------------------------------------------------------
   public void put( Key key, Value val )
   {
      root = put( root, key, val );
   }
 
   // --------------------------------------------------------------------------
   private Node put( Node x, Key key, Value val )
   {
      if (x == null)
         return new Node( key, val, 1 );
      int cmp = key.compareTo( x.key );
      if (cmp < 0)
         x.left = put( x.left, key, val );
      else if (cmp > 0)
         x.right = put( x.right, key, val );
      else if (cmp == 0)
         x.value = val;
      x.count = 1 + size( x.left ) + size( x.right );
      return x;
   }
 
   // --------------------------------------------------------------------------
   public Value get( Key key )
   {
      Node x = root;
      while (x != null)
      {
         int cmp = key.compareTo( x.key );
         if (cmp < 0)
            x = x.left;
         else if (cmp > 0)
            x = x.right;
         else if (cmp == 0)
            return x.value;
      }
      return null;
   }
 
   // --------------------------------------------------------------------------
   public int size()
   {
      return size( root );
   }
 
   // --------------------------------------------------------------------------
   private int size( Node x )
   {
      if (x == null)
         return 0;
      return x.count;
   }
   
   // --------------------------------------------------------------------------
   public Node min()
   {
      return min(root);
   }
   
   // --------------------------------------------------------------------------
   private Node min( Node x )
   {
      if ( x != null )
      {
         if (x.left == null)
         {
            return x;
         }
         return min( x.left );
      }
      return null;
   }
 
   // --------------------------------------------------------------------------
   public Node max()
   {
      return max(root);
   }
   
   // --------------------------------------------------------------------------
   private Node max( Node x )
   {
      if ( x != null )
      {
         if (x.right == null)
         {
            return x;
         }
         return max( x.right );
      }
      return null;
   }
 
 
   // --------------------------------------------------------------------------
   private Node deleteMin( Node x )
   {
      if ( x != null )
      {
         if (x.left == null)
            return x.right;
         x.left = deleteMin( x.left );
         x.count = 1 + size(x.left) + size(x.right);
         return x;
      }
      return null;
   }
 
   // --------------------------------------------------------------------------
   public void delete( Key key )
   {
      root = delete( root, key );
   }
 
   // --------------------------------------------------------------------------
   private Node delete( Node x, Key key )
   {
      if (x == null)
         return null;
      int cmp = key.compareTo( x.key );
      if (cmp < 0)
         x.left = delete( x.left, key );
      else if (cmp > 0)
         x.right = delete( x.right, key );
      else
      {
         if (x.right == null)
            return x.left;
         if (x.left == null)
            return x.right;
         Node t = x;
         x = min( t.right );
         x.right = deleteMin( t.right );
         x.left = t.left;
      }
      x.count = size( x.left ) + size( x.right ) + 1;
      return x;
   }
 
   // --------------------------------------------------------------------------
   private void print( Node node, int level )
   {
      if (node != null)
      {
         for( int i = 0; i<level; i++ )
         {
            System.out.print( "." );
         }
         System.out.printf( "L%d: (", level );
         System.out.print( node.key );
         System.out.print( "->" );
         System.out.print( node.value );
         System.out.print( ")" );
         System.out.printf( "/%d", node.count );
         System.out.println();
 
         print( node.left, level + 1 );
         print( node.right, level + 1 );
      }
   }
 
   // --------------------------------------------------------------------------
   public void print()
   {
      print( root, 0 );
   }
 
   // also maxKey, minKey,
 
}