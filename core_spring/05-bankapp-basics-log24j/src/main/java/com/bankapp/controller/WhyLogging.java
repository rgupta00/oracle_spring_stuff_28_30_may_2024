package com.bankapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhyLogging {
	private static Logger logger=LoggerFactory.getLogger(WhyLogging.class);
	
	public static void main(String[] args) {
		
		
		logger.info("code is working till line 12");
		
		
		try {
			String val="54A";
			Integer v=Integer.parseInt(val);
			
		}catch(Exception e) {
			logger.error("can not parse");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
