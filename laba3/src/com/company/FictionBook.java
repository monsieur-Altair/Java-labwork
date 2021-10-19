package com.company;

abstract public class FictionBook implements Book, ObjInt {
    private String publisher;
    private String author;
    private int page_number;

    public FictionBook(String publisher, String author, int page_number){
        this.author=author;
        this.page_number=page_number;
        this.publisher=publisher;
    }

    public int getPage_number() {
        return page_number;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }
}
