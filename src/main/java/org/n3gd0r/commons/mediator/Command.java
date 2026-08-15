package org.n3gd0r.commons.mediator;

/**
 * <p>
 * Command is an implementation of {@link Request} for {@link RequestHandler}.
 * <p>
 * Represents a write operation request.
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
public abstract class Command<R> implements Request<R> {

}
