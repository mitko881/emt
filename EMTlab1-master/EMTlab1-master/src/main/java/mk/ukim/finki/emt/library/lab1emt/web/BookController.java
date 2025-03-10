package mk.ukim.finki.emt.library.lab1emt.web;

import mk.ukim.finki.emt.library.lab1emt.model.Book;
import mk.ukim.finki.emt.library.lab1emt.model.dto.BookDTO;
import mk.ukim.finki.emt.library.lab1emt.service.BookServ;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookServ bookService;

    public BookController(BookServ bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PostMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        return bookService.addBook(book);
    }
    @PostMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/{id}/rent")
    public Book markAsRented(@PathVariable Long id) {
        return bookService.markRent(id);
    }
}

/*@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Convert Book entity to BookDTO
    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setAvailableCopies(book.getAvailableCopies());
        return bookDTO;
    }

    // Convert list of Book entities to list of BookDTOs
    private List<BookDTO> convertToDTOList(List<Book> books) {
        return books.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<Book> books = bookService.findAll();
        List<BookDTO> bookDTOs = convertToDTOList(books);
        return ResponseEntity.ok(bookDTOs);
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setCategory(bookDTO.getCategory());
        book.setAuthor(bookDTO.getAuthor());
        book.setAvailableCopies(bookDTO.getAvailableCopies());

        Book savedBook = bookService.save(book);
        BookDTO savedBookDTO = convertToDTO(savedBook);

        return ResponseEntity.status(201).body(savedBookDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book existingBook = bookService.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setName(bookDTO.getName());
        existingBook.setCategory(bookDTO.getCategory());
        existingBook.setAuthor(bookDTO.getAuthor());
        existingBook.setAvailableCopies(bookDTO.getAvailableCopies());

        Book updatedBook = bookService.save(existingBook);
        BookDTO updatedBookDTO = convertToDTO(updatedBook);

        return ResponseEntity.ok(updatedBookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/rent")
    public ResponseEntity<BookDTO> markAsRented(@PathVariable Long id) {
        Book rentedBook = bookService.markAsRented(id);
        BookDTO rentedBookDTO = convertToDTO(rentedBook);
        return ResponseEntity.ok(rentedBookDTO);
    }
}*/