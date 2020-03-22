package ieti.voicebox.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ieti.voicebox.model.Book;
import ieti.voicebox.service.BookService;


@Controller
@RequestMapping("books")
public class BookController {

    @Autowired
    BookService bookServices;


    @GetMapping
    public ResponseEntity<List<Book>> all(){
        List<Book> books = bookServices.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Book>> getBooksByName(@PathVariable String name){
        List<Book> books = bookServices.getBooksByName(name);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Book> add(@RequestBody Book book ){
        Book newBook = bookServices.createBook(book);
        return new ResponseEntity<>(newBook, HttpStatus.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book){
        Book updatedBook = bookServices.updateBook(book);
        return new ResponseEntity<>(updatedBook,HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity<Book> delete(@RequestBody Book book){
        Book deletedBook = bookServices.deleteBook(book);
        return new ResponseEntity<>(deletedBook,HttpStatus.ACCEPTED);
    }

}