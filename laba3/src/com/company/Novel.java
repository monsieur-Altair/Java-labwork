package com.company;

import java.util.Objects;

public class Novel extends FictionBook{
    private String name;

    public Novel(String publisher, String author, int page_number, String name){
        super(publisher, author, page_number);
        this.name=name;
    }

    @Override
    public String type(){
        return "Роман";
    }

    @Override
    public void print(){
        System.out.println("Название: "+name+"\nАвтор: "+super.getAuthor()+"\nКол-во страниц: "+super.getPage_number());
        System.out.println("Издатель: "+super.getPublisher()+"\nТип: "+this.type());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PoetryCollection)) return false;
        Novel that = (Novel) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
