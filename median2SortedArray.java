import java.util.*;

class Solution {
    private int findKthSmallest( int k, int [] nums1, int s1, int len1, int [] nums2, int s2, int len2 ) {
      /** nums1 should be the larger of two */
      if ( len2 > len1) return findKthSmallest( k, nums2, s2, len2, nums1, s1, len1 ); 
  
      System.out.println( "#" + k + "," + len1 + "," + len2); 
      if (len2 == 0) { return nums1[s1 + k - 1]; }
      if (k == 1) { return Math.min( nums1[s1], nums2[s2] ); }
      
      int k1 = Math.min(s1 + len1 - 1, s1 + k/2-1);
      int k2 = Math.min(s2 + len2 - 1, s2 + k/2-1);       
      if ( nums1[k1] < nums2[k2] ) {
        int step = (k1-s1+1);
        return findKthSmallest( k - step, nums1, k1+1, len1 - step, nums2, s2, len2 );       
      }  else {
        int step = (k2-s2+1);
        return findKthSmallest( k - step, nums1, s1, len1, nums2, k2+1, len2 - step );                 
      }      
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int sz =  nums1.length + nums2.length;
      if ( sz % 2 == 0 ) {
        int s1 = findKthSmallest( sz/2, nums1, 0, nums1.length, nums2, 0, nums2.length );
        int s2 = findKthSmallest( sz/2 + 1, nums1, 0, nums1.length, nums2, 0, nums2.length );
        return (s1+s2)/2.0; 
      } else {
        return findKthSmallest( sz/2 + 1, nums1, 0, nums1.length, nums2, 0, nums2.length );
      }    
    }
}

class Tester {
  public static void main(String [] args) {
    Solution sol = new Solution();
    int [] n1 = { 1, 2, 7, 8 };
    int [] n2 = { 3, 4, 5, 6 };
    
    double s = sol.findMedianSortedArrays(n1, n2);
    System.out.println( s );
  }
}