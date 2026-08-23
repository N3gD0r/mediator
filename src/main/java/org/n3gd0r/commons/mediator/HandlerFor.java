package org.n3gd0r.commons.mediator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * HandlerFor {@link Request}.
 *
 * <p>
 * Marks the {@link RequestHandler} with the specified {@link Request} type so
 * the Mediator can register them.
 *
 * @author David Hernandez Moones
 * @see RequestHandler
 * @see Request
 * @see IMediator
 * @see Mediator
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface HandlerFor {
    Class<? extends Request<?>> value();
}
