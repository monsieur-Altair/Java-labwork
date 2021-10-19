package com.company;

public class Stock{
    private String name;
    private int cost;
    private boolean isExist;

    public Stock(String name, int cost, boolean isExist){
        this.cost=cost;
        this.isExist=isExist;
        this.name=name;
    }
    public Stock() {
        this.cost = 0;
        this.isExist = false;
        this.name = "n/a";
    }
    public void Print(){
        System.out.print("\nТовар: "+name+"\nЦена: "+cost);
        System.out.println("\nПрисутствие на складе: "+this.getExist()+"\n-------------------------");
    }
    public String getExist(){
        return (this.isExist)?"да":"нет";
    }
    public int getCost(){
        return this.cost;
    }
    public String getName(){
        return this.name;
    }
}
