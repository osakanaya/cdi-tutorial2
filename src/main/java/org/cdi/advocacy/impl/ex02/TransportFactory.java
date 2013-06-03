package org.cdi.advocacy.impl.ex02;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;

import org.cdi.advocacy.api.ex01.ATMTransport;

public class TransportFactory {
	@Produces
	@Factory
	public ATMTransport createTransport(InjectionPoint injectionPoint) {
		Bean<?> bean = injectionPoint.getBean();
		TransportConfig config = bean.getBeanClass().getAnnotation(TransportConfig.class);
		
		StandardAtmTransport transport = new StandardAtmTransport();
		transport.setRetries(config.retries());
			
		return transport;
	}
}
