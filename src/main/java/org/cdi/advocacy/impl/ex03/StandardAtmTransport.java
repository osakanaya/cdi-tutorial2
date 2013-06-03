package org.cdi.advocacy.impl.ex03;

import java.util.logging.Logger;

import org.cdi.advocacy.api.ex01.ATMTransport;

@Transport(type=TransportType.STANDARD, priorityLevel=2, name="standard")
public class StandardAtmTransport implements ATMTransport {
	private static final Logger logger = Logger.getLogger(StandardAtmTransport.class.getName());
	
	private int retries = 0;
	
	@Override
	public void setRetries(int retries) {
		this.retries = retries;
		
	}

	@Override
	public void communicateWithBank(byte[] datapacket) {
		logger.info("communicating with bank via Standard transport retries=" + retries);
	}

}
