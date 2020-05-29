package java2novice;

/*
Singleton class means you can create only one object for the given class.
You can create a singleton class by making its constructor as private,
so that you can restrict the creation of the object.
Provide a static method to get instance of the object,
 wherein you can handle the object creation inside the class only.
 In this example we are creating object by using static block.
 */

public class MySingleton {
    private static MySingleton myObj;

    static {
        System.out.println("in static method");
        myObj = new MySingleton();
    }

    private MySingleton() {
        System.out.println("in constructor");
    }

    public static MySingleton getInstance(){
        System.out.println("calling getInstance()");
        return myObj;
    }

    public void testMe(){
        System.out.println("Hey... it is working!!");
    }

    public static void main(String a[]){
        MySingleton ms = getInstance();
        ms.testMe();
        MySingleton ms2 = getInstance();
        ms2.testMe();
        MySingleton ms3 = getInstance();
        ms3.testMe();
        MySingleton ms4 = getInstance();
        ms4.testMe();
    }
}
