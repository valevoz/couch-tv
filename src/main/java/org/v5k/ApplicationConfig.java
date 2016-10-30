package org.v5k;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import org.v5k.web.ShowController;

@Component
public class ApplicationConfig extends ResourceConfig {

    public ApplicationConfig() {
        register(ShowController.class);
    }

}