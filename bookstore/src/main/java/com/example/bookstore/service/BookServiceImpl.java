package com.example.bookstore.service;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        try {
            entityManager.persist(book);
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Book> findAll() {
        try {
            return entityManager.createQuery("from Book", Book.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
