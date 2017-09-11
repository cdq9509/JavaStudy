import java.util.*;

class FriendCircle2Sigma {

  public static void main ( String [] args ) {
    char [][] M = { {'Y','Y','N','N'}, 
      {'Y','Y','Y','N'},
      {'N','Y','Y','N'},
      {'N','N','N','Y'}
    };

    FriendCircle2Sigma sol = new FriendCircle2Sigma();

    int n = sol.cntNumFriendCircles( M ); 
  }


  private int numCircles; 

  // matrix M which consists of characters Y or N. 
  // If M[i][j]=Y, then ith and jth students are friends with each other, otherwise not.
  private int cntNumFriendCircles( char [][] M ) {
    int n = M.length;

    for ( int i = 0; i < n ; i ++ ) {
      if ( M[i][i] == 'Y' ) {
        System.out.println("numCircles " + numCircles ); 
        bfs( M, i ); 
        numCircles++; 
        System.out.println("numCircles " + numCircles ); 
      }
    }
    return numCircles; 
  }

  // Breath first search on graph M 
  private void bfs ( 
      char [][] M, 
      int s // starting indexi
      )
  {
    int n = M.length;

    Queue<Integer> Q = new LinkedList<Integer> ();

    Q.add( s );
    M[s][s] = '#'; // special char to indicate this is visited. 

    System.out.println("Vertex " + s + "in circle " + numCircles); 

    while ( ! Q.isEmpty() ) {
      int v = Q.remove( ); 

      // Find adjacent vertices
      for ( int i = 0; i < n ; i++ ) {
        if ( M[v][i] == 'Y' ) {

          Q.add( i ); 
          M[i][i] = '#'; // visited
          M[v][i] = '#';
          M[i][v] = '#'; 

          System.out.println("Vertex " + i + "in circle " + numCircles); 
        } // primitive type can use == 
      }
    }

  }

}
