package com.example.enversimplementation.controller;

import com.example.enversimplementation.dao.entity.Book;
import com.example.enversimplementation.dao.repository.BookRepository;
import com.example.enversimplementation.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.history.Revision;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @PostMapping("/saveBook")
    public Book saveBook(@RequestBody Book book) {
        return bookService.save(book);
    }


    @PutMapping("/update/{id}/{pages}")
    public String updateBook(@PathVariable Integer id, @PathVariable Integer pages) {
        return bookService.updateBook(id, pages);
    }


    @DeleteMapping("delete/{id}")
    public String deleteBook(@PathVariable Integer id) {
        return bookService.deleteBook(id);
    }


    @GetMapping("/getInfo/{id}")
    public void getInfo(@PathVariable Integer id) {
        bookService.getInfo(id);
    }

}
