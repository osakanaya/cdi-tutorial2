package org.cdi.advocacy.impl.ex04;

import java.util.logging.Logger;

public class StandardAtmTransport /* implements ATMTransport */ {
	private static final Logger logger = Logger.getLogger(StandardAtmTransport.class.getName());
	
	public void communicateWithBank(byte[] datapacket) {
		logger.info("communicating with bank via Standard transport");
	}

}
