package com.bookstore;

import com.bookstore.controller.ShoppingCart;
import com.bookstore.controller.ShoppingCartImpl;
import com.bookstore.datasource.BookDataSource;
import com.bookstore.datasource.BookRepo;
import com.bookstore.model.Book;
import com.bookstore.model.CoverType;
import com.bookstore.model.PaperQuality;
import com.bookstore.model.Publisher;

public class ApplicationEntry {

    public static void main(String[] ARGV) {
        BookDataSource bookDataSource = new BookRepo();

        Publisher fooPublisher = new Publisher("foo");
        Publisher barPublisher = new Publisher("bar");

        bookDataSource.add(Book.create("foobar", PaperQuality.MEDIUM, CoverType.HARD, barPublisher, 30D));
        bookDataSource.add(Book.create("foo", PaperQuality.LOW, CoverType.SOFT, fooPublisher, 10D));
        bookDataSource.add(Book.create("bar", PaperQuality.HIGH, CoverType.HARD_WITH_DUST_JACKET, barPublisher, 20D));

        System.out.println("-- make sure books are sorted by the price --");
        bookDataSource.all().forEach(System.out::println);

        System.out.println();
        System.out.println("-- find by cover type: soft --");
        bookDataSource.findByCoverType(CoverType.SOFT).forEach(System.out::println);
        System.out.println("-- find by cover type: hard --");
        bookDataSource.findByCoverType(CoverType.HARD).forEach(System.out::println);
        System.out.println("-- find by cover type: hard with dust jacket --");
        bookDataSource.findByCoverType(CoverType.HARD_WITH_DUST_JACKET).forEach(System.out::println);


        System.out.println();
        System.out.println("-- find by paper quality: low --");
        bookDataSource.findByPaperQuality(PaperQuality.LOW).forEach(System.out::println);
        System.out.println("-- find by paper quality: medium --");
        bookDataSource.findByPaperQuality(PaperQuality.MEDIUM).forEach(System.out::println);
        System.out.println("-- find by paper quality: high --");
        bookDataSource.findByPaperQuality(PaperQuality.HIGH).forEach(System.out::println);

        ShoppingCart<Book> cart = new ShoppingCartImpl<>();

        bookDataSource.findByCoverType(CoverType.SOFT)
                .stream()
                .findFirst()
                .ifPresent(cart::add);

        bookDataSource.findByPaperQuality(PaperQuality.HIGH)
                .stream()
                .findFirst()
                .ifPresent(cart::add);

        System.out.println();
        System.out.println("Print books from shopping cart");
        cart.dump().forEach(System.out::println);
    }

}
