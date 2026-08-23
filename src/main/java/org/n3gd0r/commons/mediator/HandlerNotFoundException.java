package org.n3gd0r.commons.mediator;

/**
 * <p>
 * HandlerNotFoundException thrown when the {@link RequestHandler} has not been
 * registered by the {@link IMediator}.
 *
 * @author David Hernandez Morones
 * @see Mediator
 * @see IMediator
 * @see RequestHandler
 * @see Request
 */
public class HandlerNotFoundException extends RuntimeException {
    public HandlerNotFoundException(Class<?> requestType) {
        super("This mediator does not know RequestHandler of type %s".formatted(requestType));
    }

}
