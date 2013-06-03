package org.cdi.advocacy.impl.ex01;

import java.util.logging.Logger;

import org.cdi.advocacy.api.ex01.ATMTransport;

public class JsonRestAtmTransport implements ATMTransport {
	private static final Logger logger = Logger.getLogger(JsonRestAtmTransport.class.getName());

	private int retries;
	
	public void setRetries(int retries) {
		this.retries = retries;
	}

	@Override
	public void communicateWithBank(byte[] datapacket) {
		logger.info("communicating with bank via JSON REST transport retries=" + retries);
	}

}
