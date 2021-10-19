package com.company;

public class Main {

    public static void main(String[] args) {
	    ObjInt[] array = new ObjInt[4];
	    array[0]=new PoetryCollection("Росмэн","А.С.Пушкин",104,"Сборник №1");
	    array[1]=new Directory("Телефонный справочник",99);
	    array[2]=new Novel("Росмэн","Л.Н.Толстой",2103,"Война и мир");
	    array[3]=new ScienceBook("В мире животных","Зоология","9/10");
	    for(var book: array){
			System.out.printf("\n");
			book.print();
        }
    }
}
