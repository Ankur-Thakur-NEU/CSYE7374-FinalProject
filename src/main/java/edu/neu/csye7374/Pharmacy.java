package edu.neu.csye7374;

import edu.neu.csye7374.StatePattern.PharmacyStateAPI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pharmacy implements PharmacyAPI {
    String name;
    public List<Medicine> itemList = new ArrayList<>();
    public List<Person> personList = new ArrayList<>();

    private PharmacyStateAPI state;
    public Pharmacy(String name) {
        super();
        this.name = name;
        //this.state = getOpenState();
    }
    @Override
    public void addMedicines() {
    }
    @Override
    public void addEmployees() {
    }
    @Override
    public void sortMedicines() {
        Collections.sort(itemList, new Comparator<Medicine>() {
            @Override
            public int compare(Medicine m1, Medicine m2) {
                return m1.getMedicineName().compareTo(m2.getMedicineName());
            }
        });
    }
    @Override
    public void sortEmployees() {
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                //Compare the employees based on their names
                return CharSequence.compare(p1.getFirstName(), p2.getFirstName());
            }
        });
    }
}
