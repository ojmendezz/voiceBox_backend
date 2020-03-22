package ieti.voicebox.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Book {
    private long bookId;
    private String Name;
    private String Author;
    private String sinopsis;
    private List<Category> categories;
    
    public Book(String name, String author, String sinopsis, List<Category> categories) {
        Name = name;
        Author = author;
        this.sinopsis = sinopsis;
        this.categories = categories;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book [Author=" + Author + ", Name=" + Name + ", bookId=" + bookId + ", sinopsis=" + sinopsis + "]";
    }
    
}