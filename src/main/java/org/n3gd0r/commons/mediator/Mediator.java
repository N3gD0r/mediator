package org.n3gd0r.commons.mediator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * Mediator implementation of {@link IMediator}.
 *
 * @note
 *       <p>
 *       Marked as {@link Component} and must be scanned and configured.
 *
 * @author David Hernandez Morones
 * @see IMediator
 * @see RequestHandler
 * @see Request
 * @see Command
 * @see Query
 */
@Component
public class Mediator implements IMediator {
    private final Map<Class<?>, RequestHandler<?, ?>> handlers = new HashMap<>();

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
    @Override
    public <T extends Request<R>, R> R send(T request) throws RequestNullException, HandlerNotFoundException {
        if (request == null) {
            throw new RequestNullException();
        }
        Class<?> requestType = request.getClass();
        if (!handlers.containsKey(requestType)) {
            throw new HandlerNotFoundException(requestType);
        }
        @SuppressWarnings("unchecked")
        RequestHandler<T, R> handler = (RequestHandler<T, R>) handlers.get(requestType);
        return handler.execute(request);
    }

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
    @Override
    public <T extends Request<R>, R> void registerHandler(Class<T> requestType, RequestHandler<T, R> handler) {
        handlers.put(requestType, handler);
    }
}
