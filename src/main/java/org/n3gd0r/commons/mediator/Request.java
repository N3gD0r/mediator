package org.n3gd0r.commons.mediator;

/**
 * Request abstraction for {@link RequestHandler}, represents any type of
 * request.
 * 
 * @param <R> Is the expected return type from {@link RequestHandler}.
 *
 * @see Command
 * @see Query
 * @see RequestHandler
 * @author David Hernandez Morones
 */
public interface Request<T> {

}
