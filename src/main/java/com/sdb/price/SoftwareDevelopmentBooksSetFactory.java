package com.sdb.price;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.sdb.cart.ShoppingCartItem;
import com.sdb.cart.SoftwareDevelopmentBook;



public class SoftwareDevelopmentBooksSetFactory {
	


	List<SoftwareDevelopmentBookSetDiscount> discounts;

    public SoftwareDevelopmentBooksSetFactory(List<SoftwareDevelopmentBookSetDiscount> discounts){
        this.discounts = discounts;
    }

    public List<SoftwareDevelopmentBookSet> getDifferentBooksSetsWithMaxTotalDiscount(List<ShoppingCartItem> shoppingCartItems) {
        List<SoftwareDevelopmentBookSet> optimizeSetList;
        optimizeSetList = getBestCombinationBooksSets(shoppingCartItems);
        return optimizeSetList;
    }

    private List<SoftwareDevelopmentBookSet> getBestCombinationBooksSets(List<ShoppingCartItem> shoppingCartItems) {
        List<List<SoftwareDevelopmentBookSet>> differentBooksSetsCombinations = new ArrayList<>();

        for (int i = shoppingCartItems.size();i>=1;i--){
            differentBooksSetsCombinations.add(calculateDifferentBooksSetsByMaxSize(shoppingCartItems,i));
        }

        List<SoftwareDevelopmentBookSet> optimizeSetList;

        if(differentBooksSetsCombinations.size() > 1)
            optimizeSetList = selectBooksSetsWithMaxDiscount(differentBooksSetsCombinations);
        else
            optimizeSetList = differentBooksSetsCombinations.get(0);
        return optimizeSetList;
    }

    private List<SoftwareDevelopmentBookSet> calculateDifferentBooksSetsByMaxSize(List<ShoppingCartItem> shoppingCartItems, int maxSizeSet) {
        List<ShoppingCartItem> remainingShoppingCartItems = cloneShoppingCartItems(shoppingCartItems);
        List<SoftwareDevelopmentBookSet> setsOfDifferentBooks = new ArrayList<>();

        while (remainingShoppingCartItems.size() > 0) {
            final SoftwareDevelopmentBookSet oneSetOfDifferentBooks = createNextSet(remainingShoppingCartItems,maxSizeSet);
            setsOfDifferentBooks.add(oneSetOfDifferentBooks);
        }

        return setsOfDifferentBooks;
    }

    private SoftwareDevelopmentBookSet createNextSet(List<ShoppingCartItem> remainingShoppingCartItems, int maxSizeSet) {
        HashSet<SoftwareDevelopmentBook> books = new HashSet<>();

        for (ShoppingCartItem item:new ArrayList<>(remainingShoppingCartItems)) {

            books.add(item.getBook());

            if (item.getQuantity() == 1)
                remainingShoppingCartItems.remove(item);
            else
                item.changeQuantity(item.getQuantity() - 1);

            if (books.size() == maxSizeSet)
                break;
        }

        SoftwareDevelopmentBookSet booksSet = new SoftwareDevelopmentBookSet(books,getDiscount(books.size()));

        return booksSet;
    }

    private List<SoftwareDevelopmentBookSet> selectBooksSetsWithMaxDiscount(List<List<SoftwareDevelopmentBookSet>> booksSetsCombinations) {
        List<SoftwareDevelopmentBookSet> maxDiscountBooksSets = null;
        int maxBooksSetsDiscount = 0;
        int totalBooksSetsDiscount = 0;
        for (List<SoftwareDevelopmentBookSet> booksSets:booksSetsCombinations) {
            for (SoftwareDevelopmentBookSet booksSet:booksSets) {
                totalBooksSetsDiscount += booksSet.getDiscount();
            }
            if (maxBooksSetsDiscount < totalBooksSetsDiscount) {
                maxDiscountBooksSets = booksSets;
                maxBooksSetsDiscount = totalBooksSetsDiscount;
            }
            totalBooksSetsDiscount = 0;
        }
        return maxDiscountBooksSets;
    }


    private List<ShoppingCartItem> cloneShoppingCartItems (List<ShoppingCartItem> shoppingCartItems){
        List<ShoppingCartItem> shoppingCartItemsCopy = new ArrayList<>();
        for (ShoppingCartItem item:shoppingCartItems) {
            shoppingCartItemsCopy.add(new ShoppingCartItem(item.getBook(), item.getQuantity()));
        }
        return shoppingCartItemsCopy;
    }

    private int getDiscount(int differentBooksCount){
        int defaultDiscount = 0;
        for (SoftwareDevelopmentBookSetDiscount discount:discounts){
            if (differentBooksCount == discount.getDifferentCopies())
                return discount.getDiscount();
        }
        return defaultDiscount;
    }





}
