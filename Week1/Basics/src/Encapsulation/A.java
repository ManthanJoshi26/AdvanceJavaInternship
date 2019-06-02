package Encapsulation;

import java.util.Scanner;

public class A {

    protected  String name;
    protected  int id;

    void setA(){

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Name:-");
        name = input.next();
        System.out.print("Enter ID:-");
        id = input.nextInt();


    }

}
