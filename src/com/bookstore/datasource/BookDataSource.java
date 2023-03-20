package com.bookstore.datasource;

import com.bookstore.model.Book;
import com.bookstore.model.CoverType;
import com.bookstore.model.PaperQuality;
import com.bookstore.model.Publisher;

import java.util.List;

public interface BookDataSource {

    void add(Book book);
    List<Book> all();
    List<Book> findByPublisher(Publisher publisher);
    List<Book> findByPaperQuality(PaperQuality paperQuality);
    List<Book> findByCoverType(CoverType coverType);
}
