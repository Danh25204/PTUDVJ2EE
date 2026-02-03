package Controller;

import Model.Book;
import Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBook() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(int id){
        return bookService.getBookById(id);
    }

    @PostMapping
    public String addBook(@RequestBody Book book){
        bookService.addBook(book);
        return "Add book successful";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book){
        bookService.updateBook(id, book);
        return "Update book successful";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return "Delete book successful";
    }
}
