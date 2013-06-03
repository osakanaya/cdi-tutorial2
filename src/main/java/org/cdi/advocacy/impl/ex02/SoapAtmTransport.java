package org.cdi.advocacy.impl.ex02;

import java.util.logging.Logger;

import org.cdi.advocacy.api.ex01.ATMTransport;

public class SoapAtmTransport implements ATMTransport {
	private static final Logger logger = Logger.getLogger(SoapAtmTransport.class.getName());

	private int retries;
	
	public void setRetries(int retries) {
		this.retries = retries;
	}

	@Override
	public void communicateWithBank(byte[] datapacket) {
		logger.info("Qualifiers - communicating with bank via Soap transport retries=" + retries);
	}

}
