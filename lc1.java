import java.util.*;

class Solution {
  public int[] twoSum( int [] nums, int target ) {
    int [] res = new int[2];

    Map<Integer, Integer> maps = new HashMap<Integer, Integer> (); 

    for (int i = 0; i < nums.length; i ++ ) {
      if ( maps.containsKey( target - nums[i] ) ) {
        res[1] = i; 
        res[0] = maps.get( target - nums[i] ) ; 
        break; 
      } else {
        maps.put( nums[i], i ); 
      }
    }
    
    return res; 

  }

}
