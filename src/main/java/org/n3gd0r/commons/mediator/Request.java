package org.n3gd0r.commons.mediator;

/**
 * Request abstraction for {@link RequestHandler}, represents any type of
 * request.
 * 
 * @param <T> Is the expected return type that the {@link RequestHandler} must
 *            return.
 *
 * @see Command
 * @see Query
 * @see RequestHandler
 * @author David Hernandez Morones
 */
public interface Request<T> {

}
