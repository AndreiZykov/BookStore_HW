package com.bookstore.util;

import com.bookstore.model.HasPrice;

public class SortingFunctions {
    public static <T extends HasPrice> int byPrice(T left, T right) {
        if(left.getPrice() == right.getPrice()) return 0;
        return left.getPrice() > right.getPrice() ? 1 : -1;
    }
}
