package eci.ieti.proyecto.voiceBox_backend.service.imp;

import java.util.List;

import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.model.Book;
import eci.ieti.proyecto.voiceBox_backend.model.Category;
import eci.ieti.proyecto.voiceBox_backend.service.BookServices;

@Service
public class BookServiceImpl implements BookServices {

	@Override
	public List<Book> getAllBooks() {
		return null;
	}

	@Override
	public List<Book> getBooksByName(String bookName) {
		return null;
	}

	@Override
	public List<Book> getBooksByAuthor(String author) {
		return null;
	}

	@Override
	public Book createBook(Book book) {
		return null;
	}

	@Override
	public Book deleteBook(Book book) {
		return null;
	}

	@Override
	public Book updateBook(Book book) {
		return null;
	}

	@Override
	public List<Book> getBooksByCategories(List<Category> categories) {
		return null;
	}

}