package com.sdb.price;

public class SoftwareDevelopmentBookSetDiscount {

	 private int differentCopies;
	    private int discount;

	    public SoftwareDevelopmentBookSetDiscount(int differentCopies, int discount){
	        this.differentCopies = differentCopies;
	        this.discount = discount;
	    }

	    public int getDifferentCopies(){
	        return differentCopies;
	    }

	    public int getDiscount(){
	        return discount;
	    }

}
