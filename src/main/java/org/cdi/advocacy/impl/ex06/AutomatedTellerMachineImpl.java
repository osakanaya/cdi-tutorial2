package org.cdi.advocacy.impl.ex06;

import java.math.BigDecimal;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Named;

import org.cdi.advocacy.api.ex04.ATMTransport;
import org.cdi.advocacy.api.ex04.AutomatedTellerMachine;

@Named("atm")
public class AutomatedTellerMachineImpl implements AutomatedTellerMachine {
	private static final Logger logger = Logger
			.getLogger(AutomatedTellerMachineImpl.class.getName());

	@Inject
	@Any
	private Instance<ATMTransport> allTransports;
	private ATMTransport transport;

	private boolean useJSON = true;
	private boolean behindFirewall = true;

	@SuppressWarnings("serial")
	@PostConstruct
	protected void init() {
		ATMTransport soapTransport, jsonTransport, standardTransport;
		standardTransport = allTransports.select(
				new AnnotationLiteral<Default>() {
				}).get();
		jsonTransport = allTransports.select(new AnnotationLiteral<Json>() {
		}).get();
		soapTransport = allTransports.select(new AnnotationLiteral<Soap>() {
		}).get();

		logger.info(standardTransport.getClass().getName());
		logger.info(jsonTransport.getClass().getName());
		logger.info(soapTransport.getClass().getName());

		if (!behindFirewall) {
			transport = standardTransport;
		} else {
			if (useJSON) {
				transport = jsonTransport;
			} else {
				transport = soapTransport;
			}
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
