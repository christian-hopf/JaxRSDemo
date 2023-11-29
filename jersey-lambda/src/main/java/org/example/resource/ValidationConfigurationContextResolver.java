package org.example.resource;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.ContextResolver;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import jakarta.validation.ParameterNameProvider;
import jakarta.validation.Validation;
import javax.ws.rs.container.ResourceContext;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

@Provider
public class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {
    @Context
    private ResourceContext resourceContext;

    /**Get a context*/
    @Override
    public ValidationConfig getContext(Class<?> type) {
        final ValidationConfig config = new ValidationConfig();
        config.constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class));
        config.parameterNameProvider(new CustomParameterNameProvider());
        return config;
    }

    private class CustomParameterNameProvider implements ParameterNameProvider {
        private final ParameterNameProvider nameProvider;
        public CustomParameterNameProvider() {
            nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
        }

        @Override
        public List<String> getParameterNames(final Constructor<?> constructor) {
            return nameProvider.getParameterNames(constructor);
        }

        @Override
        public List<String> getParameterNames(final Method method) {
            return nameProvider.getParameterNames(method);
        }
    }
}