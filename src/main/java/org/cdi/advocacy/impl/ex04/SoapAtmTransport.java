package org.cdi.advocacy.impl.ex04;

import java.util.logging.Logger;

import org.cdi.advocacy.api.ex04.ATMTransport;

@Soap
public class SoapAtmTransport implements ATMTransport {
	private static final Logger logger = Logger.getLogger(SoapAtmTransport.class.getName());

	@Override
	public void communicateWithBank(byte[] datapacket) {
		logger.info("Qualifiers - communicating with bank via Soap transport");
	}

}
