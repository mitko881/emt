package mk.ukim.finki.emt.library.lab1emt.service;

import mk.ukim.finki.emt.library.lab1emt.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookServ {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book addBook(Book book);
    void deleteById(Long id);
    Book markRent(Long id);
}
