/*You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
*/
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
// public class Solution extends VersionControl {
class Solution {
    public int firstBadVersion(int n, boolean [] isBadVersion) {
      
      // use [] boundary.
      int left = 0, right = n - 1; 
      
      // loop invariant: target idx >= left.
      // so left is what we want at the end. 
      while ( left <= right ) {
        int mid = left + (right - left)/2; 
        System.out.println(mid + ", " + right + "," + left ); 
        if ( isBadVersion[mid] ) { right = mid - 1; }
        // due to our loop invariant: move left only it is what we want. 
        else { left = mid + 1 ; }
      }
      return left + 1; 
    }
}


// corner case:
// 1.

class Tester {
  public static void main( String [] args ) {
      Solution sol = new Solution();
      
      boolean [] isBadVersion = { true };
      
      System.out.println("*" + sol.firstBadVersion( isBadVersion.length, isBadVersion ) ); 
      
  }
}