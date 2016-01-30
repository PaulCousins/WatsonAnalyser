package com.kingfisher.utils;

import java.util.Vector;

public interface Handler<T> {
	public T[] handle(String text);
}
