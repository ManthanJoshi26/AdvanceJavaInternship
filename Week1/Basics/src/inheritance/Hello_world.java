package inheritance;

import java.util.Scanner;

public class Hello_world extends Class2 implements print1,print2{

    static int id;
    static String name;

    public void print1(){

        System.out.println("in first interface");
        String s2 = "Manthan";
        System.out.println(s2);


    }

    public void print2(int id, String name){

        System.out.println("In 2nd interface");
        System.out.println("Hello:- " + id + "  " + "Your name is:- " + name + "\n");


    }

    Hello_world(int id, String name) {

       // super.print(id,name);
        Hello_world.id = id;
        Hello_world.name = name;

    }

//    @Override
//    public  void print(int id, String name) {
//
//        System.out.println("your name is :- " + name);
//        System.out.println("your id is :- " + id);
//
//    }

    public static void main(String[] args) {

        Scanner ip = new Scanner(System.in);

        System.out.print("Enter your ID:- ");
        id = ip.nextInt();

        System.out.print("Enter your Name:- ");
        name = ip.next();

        Hello_world h1 = new Hello_world(id, name);

        h1.print1();
        h1.print2(id, name);

    }





}



