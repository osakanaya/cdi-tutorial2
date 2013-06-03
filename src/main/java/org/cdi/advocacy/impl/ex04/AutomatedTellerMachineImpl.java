package org.cdi.advocacy.impl.ex04;

import java.math.BigDecimal;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.inject.Named;

import org.cdi.advocacy.api.ex04.ATMTransport;
import org.cdi.advocacy.api.ex04.AutomatedTellerMachine;

@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {
	private static final Logger logger = Logger.getLogger(AutomatedTellerMachineImpl.class.getName());
	
	@Inject @Soap
	private Instance<ATMTransport> soapTransport;
	
	@Inject @Json
	private Instance<ATMTransport> jsonTransport;
	
	@Inject @Default
	private Instance<ATMTransport> defaultTransport;
	
	private ATMTransport transport;

	@PostConstruct
	protected void init() {
		if (!defaultTransport.isUnsatisfied()) {
			logger.info("picked defualt");
			transport = defaultTransport.iterator().next();
		} else if (!jsonTransport.isUnsatisfied()) {
			logger.info("picked JSON");
			transport = jsonTransport.iterator().next();
		} else if (!soapTransport.isUnsatisfied()) {
			logger.info("picked SOAP");
			transport = soapTransport.iterator().next();
		}
	}
	
	@Override
	public void deposit(BigDecimal bd) {
		logger.info("deposit called");
		transport.communicateWithBank(null);
	}

	@Override
	public void withdraw(BigDecimal bd) {
		logger.info("withdraw called");
		transport.communicateWithBank(null);
	}

}
