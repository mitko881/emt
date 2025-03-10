package mk.ukim.finki.emt.library.lab1emt.repository;

import mk.ukim.finki.emt.library.lab1emt.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {};
