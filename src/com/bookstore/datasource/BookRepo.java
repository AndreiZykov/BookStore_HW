package com.bookstore.datasource;

import com.bookstore.model.Book;
import com.bookstore.model.CoverType;
import com.bookstore.model.PaperQuality;
import com.bookstore.model.Publisher;
import com.bookstore.util.SortingFunctions;

import java.util.ArrayList;
import java.util.List;

public class BookRepo implements BookDataSource {

    private final List<Book> data = new ArrayList<>();

    @Override
    public void add(Book book) {
        data.add(book);
    }

    @Override
    public List<Book> all() {
        return data.stream()
                .sorted(SortingFunctions::byPrice)
                .toList();
    }

    @Override
    public List<Book> findByPublisher(Publisher publisher) {
        return data.stream()
                .filter(book -> publisher.equals(book.getPublisher()))
                .sorted(SortingFunctions::byPrice)
                .toList();
    }

    @Override
    public List<Book> findByPaperQuality(PaperQuality paperQuality) {
        return data.stream()
                .filter(book -> paperQuality.equals(book.getPaperQuality()))
                .sorted(SortingFunctions::byPrice)
                .toList();
    }

    @Override
    public List<Book> findByCoverType(CoverType coverType) {
        return data.stream()
                .filter(book -> coverType.equals(book.getCoverType()))
                .sorted(SortingFunctions::byPrice)
                .toList();
    }
}
