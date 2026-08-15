package org.n3gd0r.commons.mediator;

/**
 * Mediator
 * 
 * @author David Hernandez Morones
 */
public interface IMediator {
    /**
     * <p>
     * Sends a <em>request</em> to a {@link RequestHandler}.
     *
     * <p>
     * The {@link RequestHandler} must implement the execute method to handle that
     * request. The {@link IMediator} must know the {@link RequestHandler} to send
     * requests.
     * 
     * @param <T>     Type of {@link Request}.
     *
     * @param <R>     Return type that the {@link RequestHandler} returns, must be
     *                the same
     *                parameterized type for {@link Request}.
     *
     * @param request The {@link Request} to pass to a known {@link RequestHandler}.
     *
     * @return The {@link RequestHandler} response type from its implemented execute
     *         method.
     *
     * @throws RequestNullException     if the request is null.
     *
     * @throws HandlerNotFoundException if the mediator does not have the
     *                                  RequestHandler for that <em>request</em>.
     * @see Command
     * @see Query
     */
    <T extends Request<R>, R> R send(T request) throws RequestNullException, HandlerNotFoundException;

    /**
     * <p>
     * Registers a {@link RequestHandler} for a {@link Request} type.
     * 
     * @param <T>         Type of {@link org.n3gd0r.commons.mediator.Request
     *                    Request}.
     *
     * @param <R>         Return type that the handler returns, must be the same
     *                    parameterized type for
     *                    {@link org.n3gd0r.commons.mediator.Request Request}.
     *
     * @param requestType Type of the
     *                    {@link org.n3gd0r.commons.mediator.Request Request} to
     *                    register for a
     *                    {@link org.n3gd0r.commons.mediator.RequestHandler
     *                    RequestHandler}.
     *
     * @param handler     The {@link org.n3gd0r.commons.mediator.RequestHandler
     *                    RequestHandler} that handles a request of type
     *                    {@link org.n3gd0r.commons.mediator.Request Request}
     * @see Command
     * @see Query
     * @see RequestHandler
     * @see Mediator
     */
    <T extends Request<R>, R> void registerHandler(Class<T> requestType, RequestHandler<T, R> handler);
}
