package org.cdi.advocacy.impl.ex02;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.*;
import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RUNTIME)
@Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface Factory {
}
