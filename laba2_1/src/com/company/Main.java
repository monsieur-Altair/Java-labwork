package com.company;

public class Main {

    public static void main(String[] args) {
	    Student[] array=new Student[4];

    	array[0]=new Student();
	    array[0].setAge(19);
	    array[0].setDebtor(true);
	    array[0].setSurname("Марамыгин");

    	array[1]=new Student("Раскольников", 19, false);
    	array[2]=new Student("Коржаков",21,true);
	    array[3]=new Student("Родкин",19,true);

	    System.out.println("Все студенты:\n");
	    for(Student st:array){
	        st.printInf();
        }

        System.out.println("\nСредний возраст: "+Student.calculateAverageAge(array));
        System.out.println("\nКоличество должников: "+Student.calculateDebtor(array));

    }
}
