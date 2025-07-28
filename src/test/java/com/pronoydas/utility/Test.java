package com.pronoydas.utility;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		String boolVal=PropertyLoader.getPropertyValue("selenuim.grid.enable");
		System.out.println(boolVal);
		
	}

}
