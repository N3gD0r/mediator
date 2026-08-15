package org.n3gd0r.commons.mediator;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Automatically discovers and registers all {@link RequestHandler} beans that
 * are annotated with {@link HandlerFor}.
 * 
 * <p>
 * Uses {@link ContextRefreshedEvent} to guarantee all application beans are
 * fully initialized before registration occurs.
 * 
 * @see HandlerFor
 * @see RequestHandler
 * @see IMediator
 * @author David Hernandez Morones
 */
@Component
public class HandlerRegistrar implements ApplicationListener<ContextRefreshedEvent> {
    private final ApplicationContext applicationContext;
    private final IMediator mediator;

    public HandlerRegistrar(ApplicationContext applicationContext, IMediator mediator) {
        this.applicationContext = applicationContext;
        this.mediator = mediator;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            registerHandlers();
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private void registerHandlers() {
        Map<String, Object> handlers = applicationContext.getBeansWithAnnotation(HandlerFor.class);

        for (Object handler : handlers.values()) {
            if (handler instanceof RequestHandler<?, ?> requestHandler) {
                HandlerFor annotation = AnnotationUtils.findAnnotation(handler.getClass(), HandlerFor.class);
                if (annotation != null) {
                    Class<? extends Request<?>> requestType = annotation.value();
                    mediator.registerHandler((Class) requestType, requestHandler);
                }
            }
        }
    }
}
