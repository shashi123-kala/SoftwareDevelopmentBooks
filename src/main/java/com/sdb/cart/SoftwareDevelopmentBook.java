package com.sdb.cart;


public class SoftwareDevelopmentBook {

	 private String title;
	    private int price;

	    public SoftwareDevelopmentBook (String title){
	        this.title = title;
	        this.price = 50;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public int getPrice() {
	        return price;
	    }

	    public boolean equals(Object o){
	        if(o == null) return false;
	        if(!(o instanceof SoftwareDevelopmentBook)) return false;

	        SoftwareDevelopmentBook other = (SoftwareDevelopmentBook) o;
	        return this.title == other.getTitle();
	    }

	    public int hashCode(){
	        return title.hashCode();
	    }



}
