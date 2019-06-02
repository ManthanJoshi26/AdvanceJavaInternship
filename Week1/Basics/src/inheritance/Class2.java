package inheritance;

public class Class2 {

    int id;
    String name;

    public void print(int id, String name) {

        this.id = id;
        this.name = name;

            System.out.println("Hello:- " + id + "  " + "Your name is:- " + name + "\n");

    }

 /*     For method overloading purpose

    public void print(double id, double name ){

        this.id1 = id;
        this.name = name;

        System.out.println("Hello " + name + " Your id is " + id );

    }
*/

}
