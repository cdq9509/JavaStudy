import java.util.*;


class Solution {
  public String longestPalindrome(String s) {
    
    StringBuilder builder = new StringBuilder();
    builder.append("$#");
    for (int i = 0; i < s.length(); ++i) { 
      builder.append(s.charAt(i));
      builder.append('#');
    }
    builder.append('@');
    String t = builder.toString();
    /*System.out.println(t);*/
    
    int [] p = new int[t.length()];  // radius of palindrome center around idx i
    int mx = 0; int id = 0; // current center id and its left boundary (inclusive)
    int maxLen = 0; int maxIdx = 0; 
    for( int i = 0; i < t.length(); i++ ) {
      if (i < mx ) {
        int j = id - (i - id);     
        p[i] = Math.min(p[j], mx - i); 
      } else { p[i] = 0; }
      /*System.out.println(p[i]);*/
      while ( i+p[i]+1 < t.length() && i-p[i]-1 >= 0 && t.charAt(i+p[i]+1) == t.charAt(i-p[i]-1) ) { p[i]++; }
      if (mx < i + p[i]) { mx = i + p[i]; id = i; }
      if (maxLen < p[i]) { maxLen = p[i]; maxIdx = i; }
      /*System.out.println( t.charAt(i)+ "," + i + "," + p[i] + " , " + id + ", " + mx );
      System.out.println( t.substring( 2*id - mx , mx + 1) );
      System.out.println( t.substring( maxIdx - maxLen, maxIdx + maxLen + 1 ) );*/
      // System.out.println( t.substring(1,4));
    }
    /*System.out.println( t.substring( maxIdx - maxLen, maxIdx + maxLen ) );*/
    return s.substring( (maxIdx-maxLen)/2, (maxIdx+maxLen)/2 );
  }
}

class Tester {
  public static void main(String args[]) {
    Solution sol = new Solution();
    String s = "babadada";
    System.out.println(sol.longestPalindrome(s));
    
    int [] p = { 1, 2, 3, 4 };
    System.out.println(Arrays.toString(p));
    
    Integer [] t = { 1, 2, 3, 4 };
    System.out.println(t);
  }
}