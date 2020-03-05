package eci.ieti.proyecto.voiceBox_backend.service;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.model.Book;
import eci.ieti.proyecto.voiceBox_backend.model.Category;

public interface BookServices {
    
    public List<Book> getAllBooks();

    public Book createBook(Book book);

    public Book deleteBook(Book book);

    public Book updateBook(Book book);

    public List<Book> getBooksByName(String bookName);

    public List<Book> getBooksByAuthor(String author);

    public List<Book> getBooksByCategories(List<Category> categories); 

}