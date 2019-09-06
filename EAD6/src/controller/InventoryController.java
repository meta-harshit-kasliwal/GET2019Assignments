package controller;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.map.ObjectMapper;

import services.Inventory;
import util.Response;

import com.google.gson.Gson;

import dao.InventoryDAO;
import enums.Status;

@Path("/inventory")
public class InventoryController {
   
	InventoryDAO dao = new InventoryDAO();

	@Path("/getall")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllInventory() throws Exception{
		Gson gson = new Gson();
		return gson.toJson(dao.getAllInventory());
	
	}
	
	@Path("/getone/{name}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getInventory(@javax.ws.rs.PathParam("name") String name) throws ClassNotFoundException, Exception{
		Gson gson = new Gson();
		return gson.toJson(dao.getInventoryByName(name));
	}
	
	@Path("/deleteall")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteallInventory() throws Exception{
		Gson gson = new Gson();
		Response response = new Response();
		if(dao.deleteall()==Status.DELETED){
			response.setCode(200);
			response.setMessage("DELETED");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return gson.toJson(response);
	}

	@Path("/updateall")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateAll(String json) throws Exception{
		Gson gson = new Gson();
		ObjectMapper mapper = new ObjectMapper();
		List<Inventory> inventory_list = Arrays.asList(mapper.readValue(json, Inventory[].class));
		Response response = new Response();
		
		for(Inventory obj : inventory_list){
			if(dao.updateInventory(obj.getName(), obj.getQuantity()) != Status.UPDATED){
				response.setCode(405);
				response.setMessage("Not Updated");
				response.setStatus(false);
				return gson.toJson(response);
			}
		}
		response.setCode(200);
		response.setMessage("UPDATED");
		response.setStatus(true);
		return gson.toJson(response);
	}
	
	
	
	@Path("/insert")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String insert(String json)throws Exception{
		Gson gson = new Gson();
		Inventory inventory_obj = gson.fromJson(json, Inventory.class);
		Response response = new Response();
		if(dao.insertInventory(inventory_obj.getName(), inventory_obj.getQuantity()) == Status.INSERTED){
			response.setCode(200);
			response.setMessage("Inserted");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return gson.toJson(response);
	}
	
	@Path("/delete/{name}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String deleteInventory(@javax.ws.rs.PathParam("name") String name) throws Exception{
		Gson gson = new Gson();
		Response response = new Response();
		if(dao.deleteInventory(name)==Status.DELETED){
			response.setCode(200);
			response.setMessage("DELETED");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		return gson.toJson(response);
	}
	

	@Path("/update/{itemname}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String replace(@PathParam("itemname") String itemname,String json) throws Exception{
		Gson gson = new Gson();
		Inventory inventory_obj = gson.fromJson(json, Inventory.class);
		Response response = new Response();
		if(dao.updateInventory(itemname, inventory_obj.getQuantity()) == Status.UPDATED){
			response.setCode(200);
			response.setMessage("UPDATED");
			response.setStatus(true);
			return gson.toJson(response);
		}
		response.setCode(405);
		response.setMessage("NOT FOUND");
		response.setStatus(false);
		
		return gson.toJson(response);
	}
}
	