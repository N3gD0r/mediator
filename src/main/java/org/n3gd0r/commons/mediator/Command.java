package org.n3gd0r.commons.mediator;

/**
 * <p>
 * Command is a write {@link Request} for {@link RequestHandler}.
 *
 * @param <R> Is the expected return type from {@link RequestHandler}.
 * 
 * @note {@link Query} and {@link Command} do not differ and are just for
 *       clarity when handling requests.
 *
 * @see Command
 * @see Query
 * @see Request
 * @see RequestHandler
 * @author David Hernandez Morones
 */
public interface Command<R> extends Request<R> {

}
