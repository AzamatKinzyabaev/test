package com.example.restservice;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    ArrayList<Book> books = new ArrayList<Book>();
    
    Library lib = new Library(books);

    @GetMapping("/")
    public Library get(){
        return lib;
    }

    @PostMapping("/")
    public String create(@RequestParam int id, String title, String author, double price){
        lib.setBook(new Book(id, title, author, price));
        return "OK";
    }

    @PutMapping("/")
    public String update(){
        return "OK";
    }

    
    @DeleteMapping("/")
    public String delete(@RequestParam int id){
        lib.removeBook(id);
        return "OK";
    }

    @GetMapping("filterPrice")
    public ArrayList<Book> getFilteredByPrice(@RequestParam String type, double price){
        return lib.filterByPrice(type, price);
    }

    @GetMapping("filterName")
    public ArrayList<Book> getFilteredByName(@RequestParam String author){
        return lib.filterByAuthor(author);
    }

}
