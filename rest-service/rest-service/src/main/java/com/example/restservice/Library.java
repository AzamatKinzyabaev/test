package com.example.restservice;

import java.util.ArrayList;

public class Library {

    public ArrayList <Book> books;

    public Library(ArrayList<Book> books) {
        this.books = books;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book){
        this.books.remove(book);
    }

    public ArrayList <Book> filterByPrice(String type, double price){
        ArrayList <Book> filtered = new ArrayList <Book>();
        for (Book book : books) {
            if(type.equals("higher")){
                if(book.getPrice() >= price) filtered.add(book);
            } else if (type.equals("lower")){
                if(book.getPrice() <= price) filtered.add(book);
            }
            
        }
        return filtered;
    }

    public ArrayList<Book> filterByAuthor(String author) {
        ArrayList <Book> filtered = new ArrayList <Book>();
        for (Book book : books) {
            if(book.getAuthor().equals(author)) filtered.add(book);
        }
        return filtered;
    }

    public void removeBook(int id){
        for (Book book : this.books) {
            if(book.getId() == id){
               this.books.remove(book);
               return;
            } 
        }
    }
    
}
