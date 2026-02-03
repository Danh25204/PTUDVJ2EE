package Service;

import Model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> bookList = new ArrayList<>();

    public List<Book> getAllBooks(){
        return bookList;
    }

    public Book getBookById(int id){
        return bookList.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    public void addBook(Book book){
        bookList.add(book);
    }

    public void deleteBook(int id){
        bookList.removeIf(book -> book.getId() == id);
    }

    public void updateBook(int id, Book updateBook){
        bookList.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .ifPresent(book -> {
                    book.setTitle(updateBook.getTitle());
                    book.setAuthor(updateBook.getAuthor());
                });
    }
}
