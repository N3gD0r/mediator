package org.n3gd0r.commons.mediator;

/**
 * RequestNullException thrown when a {@link Request} is null.
 * 
 * @see Command
 * @see Query
 * @author David Hernandez Morones
 */
public class RequestNullException extends RuntimeException {
    public RequestNullException() {
        super("The mediator cannot send a null request");
    }
}
