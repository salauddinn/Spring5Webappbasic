package com.example.demo.controller;

import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class bookController {
    private final BookRepository bookRepository;

    public bookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",bookRepository.findAll());
      return "books";
    }
}
