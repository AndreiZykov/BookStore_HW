package com.bookstore.controller;

import com.bookstore.model.HasPrice;

import java.util.List;

public interface ShoppingCart<T extends HasPrice> {
    void add(T item);
    List<T> dump();
}
