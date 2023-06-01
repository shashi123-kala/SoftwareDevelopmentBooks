package com.sdb.price;

import java.util.List;

import com.sdb.cart.SoftwareDevelopmentBook;

import com.sdb.cart.*;



public class PriceCalculatorByBooksSetDiscount implements ShoppingCart.PriceCalculator{

	


	private SoftwareDevelopmentBooksSetFactory booksSetFactory;
	public PriceCalculatorByBooksSetDiscount(SoftwareDevelopmentBooksSetFactory booksSetFactory){
        this.booksSetFactory = booksSetFactory;
    }

	@Override
	public Double calculate(List<ShoppingCartItem> shoppingCartItems) {
        List<SoftwareDevelopmentBookSet> setsOfDifferentBooks =
                booksSetFactory.getDifferentBooksSetsWithMaxTotalDiscount(shoppingCartItems);

        double totalPrice =0.0;
        double setPrice =0.0;

        for (SoftwareDevelopmentBookSet booksSet:setsOfDifferentBooks){
            for (SoftwareDevelopmentBook book:booksSet.getBooks()) {
                setPrice += book.getPrice();
            }

            setPrice = setPrice * (1.0 - (booksSet.getDiscount()/100.0));
            totalPrice +=setPrice;
            setPrice = 0;
        }

        return totalPrice;
    }





}
