package webservice;

import action.PIDGenerator;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import model.PIDIdResponse;

/**
 *
 * @author brechtvdv
 */
@Path("/")
public class PID {
        @GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PIDIdResponse> PIDIdRequest(@QueryParam("number") int number){            
            if (number == 0) {
                number = 1; // make sure there's at least one pid returned
            }
            
            PIDGenerator generator  = new PIDGenerator();
            List<PIDIdResponse> response = generator.getIds(number);

            return response;
	}
}
