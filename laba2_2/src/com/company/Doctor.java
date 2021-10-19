package com.company;

public class Doctor extends Staff{

    protected String speciality;

    public Doctor(String surname,
                  String name,
                  int age,
                  int salary,
                  String speciality){
        super(surname,name,age,salary);
        this.speciality=speciality;
    }
    @Override
    public void print(){
        System.out.print("\nДоктор");
        super.print();
        System.out.print("\nСпециальность: "+speciality);
    }

}
