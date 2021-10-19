package com.company;

import java.util.Objects;

abstract public class Staff {
    protected String surname;
    protected String name;
    protected int age;
    protected int salary;

    public Staff(String surname, String name, int age, int salary){
        this.name=name;
        this.age=age;
        this.salary=salary;
        this.surname=surname;
    }

    protected void print(){
        System.out.print("\nФамилия: "+surname+"\nИмя: "+name);
        System.out.print("\nВозраст: "+age+"\nЗарплата: "+salary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return age == staff.age && salary == staff.salary && Objects.equals(surname, staff.surname) && Objects.equals(name, staff.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, age, salary);
    }

    @Override
    public String toString() {
        return "\nФамилия: "+surname+"\nИмя: "+name+"\nВозраст: "+age+"\nЗарплата: "+salary;
    }
}
