package com.bookstore.model;

import java.util.Objects;

public class Book implements HasPrice {
    private final String title;
    private final PaperQuality paperQuality;
    private final CoverType coverType;
    private final Publisher publisher;

    private final double price;

    private Book(String title, PaperQuality paperQuality, CoverType coverType, Publisher publisher, double price) {
        this.title = title;
        this.paperQuality = paperQuality;
        this.coverType = coverType;
        this.publisher = publisher;
        this.price = price;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public PaperQuality getPaperQuality() {
        return paperQuality;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public static Book create(String title, PaperQuality paperQuality, CoverType coverType, Publisher publisher, double price) {
        return new Book(title, paperQuality, coverType, publisher, price);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Double.compare(book.price, price) == 0
                && Objects.equals(title, book.title)
                && paperQuality == book.paperQuality
                && coverType == book.coverType
                && Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, paperQuality, coverType, publisher, price);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", paperQuality=" + paperQuality +
                ", coverType=" + coverType +
                ", publisher=" + publisher +
                ", price=" + price +
                '}';
    }
}
