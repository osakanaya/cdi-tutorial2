package org.cdi.advocacy.impl.ex01;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.InjectionPoint;

import org.cdi.advocacy.api.ex01.ATMTransport;

public class TransportFactory {
	@Produces
	@Factory
	public ATMTransport createTransport(InjectionPoint injectionPoint) {
		Annotated annotated = injectionPoint.getAnnotated();
		TransportConfig config = annotated.getAnnotation(TransportConfig.class);
		
		StandardAtmTransport transport = new StandardAtmTransport();
		transport.setRetries(config.retries());
			
		return transport;
	}
}
