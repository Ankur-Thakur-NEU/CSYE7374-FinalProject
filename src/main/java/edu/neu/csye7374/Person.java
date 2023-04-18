package edu.neu.csye7374;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(int id,int age,String firstName, String lastName) {
        super();
        this.id=id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    @Override
    public String toString() {
        return "[id= "+ id+", firstName= " + firstName + ", lastName= " + lastName + ", age= " + age + "]";
    }
}
