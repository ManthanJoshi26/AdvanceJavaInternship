package inheritance;

import java.util.Scanner;

public class Class3 extends Class2 {

    Scanner input = new Scanner(System.in);


    void Print() {
        System.out.println("Enter the String :-");
        String s2 = input.next();
        System.out.println(s2 + " Class 3");
    }

}
