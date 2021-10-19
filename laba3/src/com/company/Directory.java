package com.company;

public class Directory implements Book, ObjInt{
    private String name;
    private int page_number;

    public Directory(String name, int page_number){
        this.page_number=page_number;
        this.name=name;
    }
    @Override
    public void print(){
        System.out.println("Название: "+name+"\nКол-во страниц: "+page_number+"\nТип: "+this.type());
    }
    @Override
    public String type(){
        return "Справочник";
    }
}
