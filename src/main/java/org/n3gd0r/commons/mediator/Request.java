package org.n3gd0r.commons.mediator;

/**
 * <p>
 * Request abstraction for {@link RequestHandler}, represents any type of
 * request.
 *
 * @param <T> Is the expected return type that the {@link RequestHandler} must
 *            return.
 *
 * @author David Hernandez Morones
 * @see Command
 * @see Query
 * @see RequestHandler
 */
public interface Request<T> {

}
