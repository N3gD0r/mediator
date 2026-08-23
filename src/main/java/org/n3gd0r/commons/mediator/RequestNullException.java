package org.n3gd0r.commons.mediator;

/**
 * RequestNullException thrown when a {@link Request} is null.
 *
 * @author David Hernandez Morones
 * @see Command
 * @see Query
 */
public class RequestNullException extends RuntimeException {
    public RequestNullException() {
        super("The mediator cannot send a null request");
    }
}
