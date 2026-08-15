package org.n3gd0r.commons.mediator;

/**
 * <p>
 * Query is an implementation of {@link Request} for {@link RequestHandler}.
 * <p>
 * Represents a query operation request.
 *
 * @note {@link Query} and {@link Command} do not differ and are just for
 *       clarity when handling requests.
 *
 * @param <R> Is the expected return type from {@link RequestHandler}.
 * 
 * @see Command
 * @see Query
 * @see Request
 * @see RequestHandler
 * @author David Hernandez Morones
 */
public abstract class Query<R> implements Request<R> {

}
