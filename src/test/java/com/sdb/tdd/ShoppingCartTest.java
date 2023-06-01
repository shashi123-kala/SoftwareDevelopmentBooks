package com.sdb.tdd;
import java.util.ArrayList;
import java.util.List;
import com.sdb.price.SoftwareDevelopmentBookSetDiscount;



public class ShoppingCartTest {
	    public void setup(){
	        List<SoftwareDevelopmentBookSetDiscount> byDifferentCopiesDiscountList = new ArrayList<>();

	        byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(2,5));
	        byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(3,10));
	        byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(4,20));
	        byDifferentCopiesDiscountList.add(new SoftwareDevelopmentBookSetDiscount(5,25));       
	        
	        
	    }
	 
	 
	


}
