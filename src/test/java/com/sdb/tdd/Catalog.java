package com.sdb.tdd;

import com.sdb.cart.SoftwareDevelopmentBook;

public class Catalog {

	public static SoftwareDevelopmentBook GivenASoftwareDevelopmentIBook(){
        SoftwareDevelopmentBook book = new SoftwareDevelopmentBook("Clean Code (Robert Martin, 2008)");
        return book;
    }

    public static SoftwareDevelopmentBook GivenASoftwareDevelopmentIIBook(){
        SoftwareDevelopmentBook book = new SoftwareDevelopmentBook("The Clean Coder (Robert Martin, 2011)");
        return book;
    }

    public static SoftwareDevelopmentBook GivenASoftwareDevelopmentIIIBook(){
        SoftwareDevelopmentBook book = new SoftwareDevelopmentBook("Clean Architecture (Robert Martin, 2017)");
        return book;
    }

    public static SoftwareDevelopmentBook GivenASoftwareDevelopmentIVBook(){
        SoftwareDevelopmentBook book = new SoftwareDevelopmentBook("Test Driven Development by Example (Kent Beck, 2003)");
        return book;
    }

    public static SoftwareDevelopmentBook GivenASoftwareDevelopmentVBook(){
        SoftwareDevelopmentBook book = new SoftwareDevelopmentBook("Working Effectively With Legacy Code (Michael C. Feathers, 2004)");
        return book;
    }




}
