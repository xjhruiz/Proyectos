package com.java8.java8;

public @interface AnotacionCustom {

	String nombre();
	boolean habilitado() default true;
}
