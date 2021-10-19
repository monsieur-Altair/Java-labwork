package com.company;

import java.util.Objects;

public class ScienceBook implements Book,ObjInt{
    private String name;
    private String difficulty;
    private String theme;
    public ScienceBook(String name, String theme, String difficulty){
        this.difficulty=difficulty;
        this.name=name;
        this.theme=theme;
    }

    @Override
    public void print(){
        System.out.println("Название: "+name+"\nСложность: "+difficulty+"\nТема: "+theme);
        System.out.println("Тип: "+this.type());
    }
    @Override
    public String type(){
        return "Научная книга";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ScienceBook)) return false;
        ScienceBook that = (ScienceBook) o;
        return name.equals(that.name) && difficulty.equals(that.difficulty) && theme.equals(that.theme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, difficulty, theme);
    }
}
