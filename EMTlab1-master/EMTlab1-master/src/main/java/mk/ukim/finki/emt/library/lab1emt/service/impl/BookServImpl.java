package mk.ukim.finki.emt.library.lab1emt.service.impl;

import mk.ukim.finki.emt.library.lab1emt.model.Book;
import mk.ukim.finki.emt.library.lab1emt.repository.BookRepo;
import mk.ukim.finki.emt.library.lab1emt.service.BookServ;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServImpl implements BookServ {

    private final BookRepo bookRepository;

    public BookServImpl(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    public Book markRent(Long id) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setAvailableCopies(book.getAvailableCopies() - 1);
        return bookRepository.save(book);
    }
}

