package demos; // Declar this file/class belongs to package demos.
               // We do not need to declar this is a package for it to work.
               // In another file, we can declar it beongs to demos package too
               // and that file too can have public static void main
               // We distinguish by java demos.Demo
               // To compile the Java programs with package statements 
               // you have to do use -d option as shown below so that
               // compiler creates a directory for package

class Demo{

  public static void main( String [] args ) {

    // Why this works? This is because string conversion rules. http://docs.oracle.com/javase/specs/jls/se7/html/jls-5.html#jls-5.1.11 
    System.out.println( 9 + "foo" );

    System.out.println("Hello World");

    Car car = new Car();
    System.out.println(car); 

    for ( int i = 0; i < args.length; i++ ) {
      System.out.println( args[i] ) ; 
     }

    if ( args[1] != null && args[0] != null ) {
      car.setName( args[1] );
      car.setName( args[0] );
    }

    System.out.println(car); 
  }

  
}


class Car {

  private String name; 
  private int id;

  public void setName( String in ) {
    name = in; 
  }

  public void setID ( int in ) {
    id = in;
  }

  // @override
  public String toString() {
    String str =  this.getClass().getName() + "@" + Integer.toHexString(hashCode());
    str += ( ", name = " + name ); 
    str += ( ", id = " + id ); 
    return str; 
  }
}


