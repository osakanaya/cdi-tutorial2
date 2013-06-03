package org.cdi.advocacy.impl.ex01;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

@Retention(RUNTIME)
@Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface TransportConfig {
	int retries() default 5;
}
