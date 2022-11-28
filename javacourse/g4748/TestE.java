/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 25-Nov-2022 
*/

package edu.javacourse.g4748;
/*
Programmed by Sergii Kozhushko
*/

public class TestE {
    /**
     * Метод печатает сотрудников старше заданного возраста
     * @param e
     * @param age
     */
    public static void printAge(Employee[] e, int age){
        for (int i=0; i <e.length;i++){
            if (e[i].getAge() > age)
                System.out.println(e[i].toString());
        }

    }

    /**
    Метод печататет данные сотрудников, у которых имя или фамилия содержат заданную строку
     */
    public static void printNamesStr(Employee[] e, String str){
        for (int i=0; i < e.length;i++){
            if (e[i].FirstName.contains(str) || e[i].LastName.contains((str)))
                System.out.println(e[i].toString());
        }

    }

    public static void main(String[] args) {
        Employee em[];
        em = new Employee[6];

        em[0] = new Employee("Petr", "Petrov", "Boss",1000,43);
        em[1] = new Employee("Ivan","Ivanov","Manager",600,35);
        em[2] = new Employee("Maria", "Makarova", "Secretary",500,25);
        em[3] = new Employee("Jack", "Dubb", "Worker",400,23);
        em[4] = new Employee("Mark", "Twain", "Worker",350,44);
        em[5] = new Employee("Jane", "Air", "Account",650,44);
        //printAge(em, 30);
        printNamesStr(em, "ar");

    }
}
