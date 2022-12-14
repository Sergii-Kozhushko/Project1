/**
 * House.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 14-Dec-2022 15:48
 */

package edu.javacourse.g5152.homework0;

public class House {
    private int length;// длинна дома
    private int width;// ширина дома
    public int height;// высота дома
    private String address; // Адрес дома
    public String owner; // владелец дома, имя

    public House() {
        address = "Unknown address";
        owner = "Unknown owner";
    }

    public House(int length, int width, int height, String address, String owner) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.address = address;
        this.owner = owner;
    }

    public House(String address, String owner) {
        this.address = address;
        this.owner = owner;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void print(){
        System.out.println("House: " + address);
        System.out.println("Owner: " + owner);
        System.out.printf("Height, width, length: %s, %s, %s m%n", height, width, length);
    }

    @Override
    public String toString() {
        return "House: " + address + ", " + owner + " (HxWxL) (" + height + "x" + width + "x" + length + ") m";
    }

}
