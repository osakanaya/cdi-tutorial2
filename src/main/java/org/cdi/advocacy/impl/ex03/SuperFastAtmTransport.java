package org.cdi.advocacy.impl.ex03;

import java.util.logging.Logger;

import org.cdi.advocacy.api.ex01.ATMTransport;

@Transport(type=TransportType.STANDARD, priorityLevel=1, name="superfast")
public class SuperFastAtmTransport implements ATMTransport {
	private static final Logger logger = Logger.getLogger(SuperFastAtmTransport.class.getName());
	
	private int retries = 0;
	
	@Override
	public void setRetries(int retries) {
		this.retries = retries;
		
	}

	@Override
	public void communicateWithBank(byte[] datapacket) {
		logger.info("communicating with bank via Super Fast transport retries=" + retries);
	}

}
