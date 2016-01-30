package com.kingfisher.utils;

public class BaseUtils {

	/**
	 * Remove all CRs, LFs, Commas etc
	 * @param input
	 * @return
	 */
	public String cleanse(String input, boolean trim){
		input = input.replaceAll(","," ").
				replaceAll("\r"," ").
				replaceAll("\n", " ").
				replaceAll("&"," ").
				replaceAll(";"," ");
		
		if(trim && input.length()>50)
			return input.substring(0,50);
		else
			return input;
	}
}
