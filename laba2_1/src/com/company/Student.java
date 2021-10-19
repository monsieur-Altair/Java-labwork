package com.company;

public class Student{
    public String surname;
    public int age;
    public boolean isDebtor;

    public Student(){
        this.surname="n/a";
        this.age=0;
        this.isDebtor=false;
    }

    public Student(String surname, int age, boolean isDebtor){
        this.isDebtor=isDebtor;
        this.age=age;
        this.surname=surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDebtor(boolean debtor) {
        isDebtor = debtor;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public String getSurname() {
        return surname;
    }

    public String getDebtor(){
        return this.isDebtor?"Есть":"Нет";
    }

    public void printInf(){
        System.out.println("\nФамилия: "+this.surname+"\nВозраст: "+this.age);
        System.out.println("Задолженность: "+getDebtor()+"\n-----------------------------");
    }

    public static double calculateAverageAge(Student[] array){
        double sum_of_age=0, count=0;
        for(Student st:array){
            count++;
            sum_of_age+=st.age;
        }
        return sum_of_age/count;
    }

    public static int calculateDebtor(Student[] array){
        int count=0;
        for(Student st:array)
            if(st.isDebtor)
                count++;
        return count;
    }
}
