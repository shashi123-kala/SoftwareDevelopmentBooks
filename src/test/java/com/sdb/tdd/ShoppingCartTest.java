package com.sdb.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sdb.cart.ShoppingCart;
import com.sdb.cart.SoftwareDevelopmentBook;
import com.sdb.price.PriceCalculatorByBooksSetDiscount;
import com.sdb.price.SoftwareDevelopmentBookSetDiscount;
import com.sdb.price.SoftwareDevelopmentBooksSetFactory;

public class ShoppingCartTest {
	ShoppingCart shoppingCart;

	@BeforeEach
	public void setup() {
		List<SoftwareDevelopmentBookSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();

		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(2, 5));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(3, 10));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(4, 20));
		byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(5, 25));
		SoftwareDevelopmentBooksSetFactory booksSetFactory = new SoftwareDevelopmentBooksSetFactory(
				byDifferentCopiesDiscountList);
		shoppingCart = new ShoppingCart(new PriceCalculatorByBooksSetDiscount(booksSetFactory));

	}

	@Test
	public void buyingOneBookWithNormalPrice() {
		SoftwareDevelopmentBook sdbI = Catalog.GivenASoftwareDevelopmentIBook();
		shoppingCart.Add(sdbI);
		assertEquals(50.0, shoppingCart.getTotalPrice());
	}

	@Test
	public void buyingTwoCopiesOfSameBookWithNormalPrice() {
		SoftwareDevelopmentBook sdbI = Catalog.GivenASoftwareDevelopmentIBook();
		shoppingCart.Add(sdbI);
		shoppingCart.Add(sdbI);
		assertEquals(100.0, shoppingCart.getTotalPrice());
	}

	@Test
	public void buyingTwoCopiesOfDifferentBookWithFivePercentDiscount() {
		SoftwareDevelopmentBook sdbI = Catalog.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbII = Catalog.GivenASoftwareDevelopmentIIBook();
		shoppingCart.Add(sdbI);
		shoppingCart.Add(sdbII);
		assertEquals(95, shoppingCart.getTotalPrice());
	}

	@Test
	public void buyingThreeCopiesOfDifferentBookWithTenPercentDiscount() {
		SoftwareDevelopmentBook sdbI = Catalog.GivenASoftwareDevelopmentIBook();
		SoftwareDevelopmentBook sdbII = Catalog.GivenASoftwareDevelopmentIIBook();
		SoftwareDevelopmentBook sdbIII = Catalog.GivenASoftwareDevelopmentIIIBook();
		shoppingCart.Add(sdbI);
		shoppingCart.Add(sdbII);
		shoppingCart.Add(sdbIII);
		assertEquals(135, shoppingCart.getTotalPrice());

	}

}
