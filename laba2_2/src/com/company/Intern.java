package com.company;

public class Intern extends Staff{
    protected String university;

    public Intern(String surname, String name, int age, String university)
    {
        super(surname, name, age, 0);
        this.university=university;
    }

    public Intern(Intern obj){
        super(obj.surname, obj.name, obj.age, obj.salary);
        this.university=obj.university;
    }

    @Override
    protected void print() {
        System.out.print("\nИнтерн");
        super.print();
        System.out.println("\nУниверситет: "+this.university);
    }


}
