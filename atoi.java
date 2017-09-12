/*
$ java Test.class
Error: Could not find or load main class Test.class

dchen2@dchen2-THINK /cygdrive/d/work/JavaStudy
$ java Test
test

*/

class Test {
  public static void main(String[] args) {
    Solution sol = new Solution();
    sol.myAtoi("test");
    System.out.println("test\n");
  }
}

class Solution {
  enum State { 
  INIT,
  PROCESS,
  DONE}
  private    boolean checkOverflow(long  num, boolean is_pos) 
    {
      if (is_pos && num >= Integer.MAX_VALUE) return true;
      else if (!is_pos && num >= ((long )(-1))*(Integer.MIN_VALUE)) return true; 
      else return false; 
    }

  public int myAtoi(String str) {
      long num = 0; 
      State state = State.INIT;
      boolean is_pos = true; 
      boolean is_overflow = false; 

      for (int i = 0; i < str.length(); ++i) {
        char c = str.charAt(i);
        //cout << "state = " << (int)state << endl;

        if (state == State.INIT) {
          if (c == ' ') { continue;}

          boolean is_bad = false;
          if (c == '+') { is_pos = true; }
          else if ( c == '-') { is_pos = false; }
          else if ( c >= '0' && c <= '9') { num = c - '0'; }
          else { is_bad = true; }

          if (is_bad) { state = State.DONE;}
          else {state = State.PROCESS;}          
        }
        else if (state == State.PROCESS) {
          if ( c >= '0' && c <= '9') {
            num = (num *10) + ( c - '0'); 
            is_overflow = checkOverflow(num, is_pos);
            if (is_overflow) {
              if (is_pos)  num = Integer.MAX_VALUE;
              else num = ((long )(-1))*Integer.MIN_VALUE;
            }
          } else {
            state = State.DONE;
          }
        } // end of state machine

        if ( state == State.DONE ) { break; }
      }

      if (is_pos) return (int) num;
      else return (int)(-1*num);
  }
}

