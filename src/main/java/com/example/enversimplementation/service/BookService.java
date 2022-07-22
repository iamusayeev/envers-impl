package com.example.enversimplementation.service;

import com.example.enversimplementation.dao.entity.Book;
import com.example.enversimplementation.dao.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public String updateBook(Integer id, Integer pages) {
        Book book = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        book.setPages(pages);
        bookRepository.save(book);
        return "Book updated";
    }

    public String deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return "Book deleted";
    }

    public void getInfo(Integer id) {
        System.out.println(bookRepository.findLastChangeRevision(id));
    }


}

