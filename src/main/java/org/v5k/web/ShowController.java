package org.v5k.web;

import org.springframework.stereotype.Controller;
import org.v5k.domain.Show;
import org.v5k.service.ShowService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Controller
@Path("/")
public class ShowController {

    private final ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GET
    @Path("/subscribed")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Show> subscribedShows() {
        return showService.subscribedShows();
    }

    @GET
    @Path("/available")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> availableShows() {
        return showService.availableShows();
    }
}
