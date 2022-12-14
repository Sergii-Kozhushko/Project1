/**
 * Main.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Dec-2022 15:57
 */

package edu.javacourse.g5152.homework0;

public class Main {
    public static void main(String[] args) {
        House house = new House(10, 5, 3, "Larchenstr, 17, 54222, Bonn","Gregor Steiner");
        house.print();
        House villa = new House("Olmuhlenweg 26, 53359 Rheinbach","Mike Mayer");
        System.out.println(villa.toString());
    }

}
