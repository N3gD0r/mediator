package org.n3gd0r.commons.mediator;

/**
 * <p>
 * Query is query {@link Request} for {@link RequestHandler}.
 *
 * <p>
 * {@link Query} and {@link Command} do not differ and are just for
 * clarity when handling requests.
 *
 * @param <R> Is the expected return type from {@link RequestHandler}.
 *
 * @author David Hernandez Morones
 * @see Command
 * @see Query
 * @see Request
 * @see RequestHandler
 */
public interface Query<R> extends Request<R> {

}
