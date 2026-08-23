package org.n3gd0r.commons.mediator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

/**
 * <p>
 * Mediator implementation of {@link IMediator}.
 * <p>
 * Marked as {@link Component} and must be scanned.
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
    private final Map<Class<?>, RequestHandler<?, ?>> handlers = new ConcurrentHashMap<>();

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

    @Override
    public <T extends Request<R>, R> void registerHandler(Class<T> requestType, RequestHandler<T, R> handler) {
        handlers.put(requestType, handler);
    }
}
