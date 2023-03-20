package com.bookstore.controller;

import com.bookstore.model.HasPrice;
import com.bookstore.util.SortingFunctions;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartImpl<T extends HasPrice> implements ShoppingCart<T> {

    List<T> data = new ArrayList<>();
    @Override
    public void add(T item) {
        data.add(item);
    }

    public List<T> dump() {
        return data.stream()
                .sorted(SortingFunctions::byPrice)
                .toList();
    }

}
