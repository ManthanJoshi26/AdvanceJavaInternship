package Encapsulation;

public class C extends  B {

    C(){
        super();
    }

    public static void main(String[] args) {

        C c1 = new C();

        System.out.println(c1.name);
        System.out.println(c1.id);

    }
}
