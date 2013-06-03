package org.cdi.advocacy.api.ex01;

public interface ATMTransport {
	public void communicateWithBank(byte[] datapacket);
	public void setRetries(int retries);
}
