package mk.ukim.finki.emt.library.lab1emt.repository;

import mk.ukim.finki.emt.library.lab1emt.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {};
