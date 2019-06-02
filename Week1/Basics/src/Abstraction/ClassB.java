package Abstraction;

import java.util.Scanner;

public class ClassB extends ClassA implements If1 {

    static int radius;
    static float area;

    public void Area(){

        area = (float) (Math.PI * Math.pow(radius, 2));
        System.out.println(area);
    }

    @Override
    public void area() {

        area = (float) (Math.PI * Math.pow(radius, 2));
        System.out.println(area);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        radius = input.nextInt();

        ClassB b = new ClassB();
        b.area();
        b.Area();
        System.out.println(b.name);

    }

}
