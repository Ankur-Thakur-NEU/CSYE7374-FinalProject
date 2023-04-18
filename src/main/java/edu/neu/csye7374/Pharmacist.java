package edu.neu.csye7374;

public class Pharmacist extends Person{
    private double wage;
    public Pharmacist(int id, int age, String firstName, String lastName) {
        super(id, age, firstName, lastName);
    }
    @Override
    public String toString() {
        return "\nEmployee ["+ super.toString() +", wage= "+ wage +"]";
    }
}
