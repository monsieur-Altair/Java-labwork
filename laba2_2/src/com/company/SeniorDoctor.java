package com.company;

import java.util.ArrayList;

public class SeniorDoctor extends Doctor implements Internship{

    protected ArrayList<Intern> array_of_interns;

    SeniorDoctor(String surname,
                 String name,
                 int age,
                 int salary,
                 String speciality){
        super(surname, name, age, salary, speciality);
        array_of_interns = new ArrayList<>();
    }

    @Override
    public boolean isHasInterns() {
        return array_of_interns.size()!=0;
    }

    @Override
    public void print() {
        System.out.print("Старший врач");
        super.print();
        System.out.print("\nИмеет интернов: ");
        if(this.isHasInterns()){
            System.out.println("Да");
            this.printAllInterns();
        }
        else
            System.out.println("Нет");
        System.out.println("\n");
    }

    @Override
    public void printAllInterns() {
        System.out.println("\nИнтерны врача:");
        int i=1;
        for(var intern: array_of_interns){
            System.out.print(i++);
            intern.print();
            System.out.print("\n");
        }
    }

    public void setInterns(ArrayList<Intern> arr){
        for(var i:arr)
            this.array_of_interns.add(new Intern(i.surname, i.name, i.age,i.university));
    }
}
