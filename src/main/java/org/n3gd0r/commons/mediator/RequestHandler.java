package org.n3gd0r.commons.mediator;

/**
 * <p>
 * RequestHandler handles a specified {@link Request}.
 *
 * @param <T> represents the {@link Request} that this Handler que execute.
 *
 * @param <R> represents the Return type expected from this handler given a
 *            {@link Request}
 *
 * @author David Hernandez Morones
 * @see Request
 * @see Command
 * @see Query
 * @see Mediator
 * @see IMediator
 */
public interface RequestHandler<T extends Request<R>, R> {
    /**
     * <p>
     * Returns R object given a Request T.
     *
     * <p>
     * The execute process must be implemented and is responsible for the return
     * object.
     *
     * @param request Represents the {@link Request}.
     *
     * @return Any object of parameterized type from {@link Request}.
     *
     * @see Request
     * @see Command
     * @see Query
     * @see Mediator
     * @see IMediator
     */
    R execute(T request);
}
