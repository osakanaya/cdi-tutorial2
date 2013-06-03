package org.cdi.advocacy.api.ex04;

import java.math.BigDecimal;

public interface AutomatedTellerMachine {
	public abstract void deposit(BigDecimal bd);
	public abstract void withdraw(BigDecimal bd);
}
