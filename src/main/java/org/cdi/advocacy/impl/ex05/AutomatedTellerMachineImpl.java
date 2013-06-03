package org.cdi.advocacy.impl.ex05;

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
	
	@Inject
	private Instance<ATMTransport> allTransports;
	
	@PostConstruct
	protected void init() {
		logger.info("Is this ambiguous? " + allTransports.isAmbiguous());
		logger.info("Is this unsatisfied? " + allTransports.isUnsatisfied());
	}
	
	@Override
	public void deposit(BigDecimal bd) {
		logger.info("deposit called");
		
		for(ATMTransport transport : allTransports) {
			transport.communicateWithBank(null);
		}
	}

	@Override
	public void withdraw(BigDecimal bd) {
		logger.info("withdraw called");

		for(ATMTransport transport : allTransports) {
			transport.communicateWithBank(null);
		}
	}

}
