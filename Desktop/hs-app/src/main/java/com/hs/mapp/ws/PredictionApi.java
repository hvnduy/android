package com.hs.mapp.ws;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hs.mapp.service.PredictionService;
import com.hs.mapp.service.UserService;
import com.hs.mapp.vo.PredictionVO;
import com.hs.mapp.vo.WSVO;

/**
 * The Class PredictionApi.
 */
@Component
@Path("horo-api/tables")
public class PredictionApi {

    /** The service. */
    @Autowired
    private UserService service;

    /** The prediction service. */
    @Autowired
    private PredictionService predictionService;

    /** The gson. */
    private Gson gson;
    
	@Autowired
	public void setGson(){
		gson = new GsonBuilder().setPrettyPrinting()
			    .disableHtmlEscaping()
			    .create();
	}

    /**
     * Gets the prediction by daily.
     * @param horoId
     *            the horo id
     * @param postDate
     *            the post date
     * @param lgg
     *            the lgg
     * @return the prediction by daily
     */
    @GET
    @Path("/pre/query/prediction")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getPredictionByDaily(@QueryParam("horo_id") int horoId, @QueryParam("post_date") String postDate, @DefaultValue("en-us") @QueryParam("lgg") String lgg) {
	WSVO<PredictionVO> wsvo = new WSVO<PredictionVO>();
	try {
	    wsvo.setStatus("successfully");
	    wsvo.setResult(predictionService.getPredictionByDaily(horoId, postDate, lgg));
	} catch (Exception e) {
	    wsvo.setStatus(e.getMessage());
	}
	return Response.status(200).entity(gson.toJson(wsvo)).build();
    }

    /**
     * Gets the list of prediction by daily.
     * @param postDate
     *            the post date
     * @param lgg
     *            the lgg
     * @return the list of prediction by daily
     */
    @GET
    @Path("/pre/query/listpredict")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getListOfPredictionByDaily(@QueryParam("post_date") String postDate, @DefaultValue("en-us") @QueryParam("lgg") String lgg) {
	WSVO<List<PredictionVO>> wsvo = new WSVO<List<PredictionVO>>();

	try {
	    
	    List<PredictionVO> list = predictionService.getListPredictionByDaily(postDate, lgg);
	    if(list != null && list.size() == 0){
		 wsvo.setStatus("failed");
	    }else{
		 wsvo.setResult(list);
		 wsvo.setStatus("successfully");
	    }
	   
	} catch (SQLException e) {
	    wsvo.setStatus(e.getMessage());
	    e.printStackTrace();
	}
	return Response.status(200).entity(gson.toJson(wsvo)).build();
    }
    
    @GET
    @Path("/predictdaily")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    public Response getPredictionDaily(@QueryParam("post_date") String postDate, @DefaultValue("en-us") @QueryParam("lgg") String lgg) {
	WSVO<List<PredictionVO>> wsvo = new WSVO<List<PredictionVO>>();

	try {
	    
	    List<PredictionVO> list = predictionService.getPredictionDaily(postDate, lgg);
	    if(list != null && list.size() == 0){
		 wsvo.setStatus("failed");
	    }else{
		 wsvo.setResult(list);
		 wsvo.setStatus("successfully");
	    }
	   
	} catch (SQLException e) {
	    wsvo.setStatus(e.getMessage());
	    e.printStackTrace();
	}
	return Response.status(200).entity(gson.toJson(wsvo)).build();
    }
}
