package com.howtodoinjava.rest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.howtodoinjava.logic.OnlineOfflineLogic;
import com.howtodoinjava.pojo.Response;

//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//
//import javax.ws.rs.FormParam;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//
@Path("Order")
public class OrderService {
	
	@Path("/Check")
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String checkMethod() {
		return "Hello World";
	}
	
	
	Response response = new Response();
	@Path("/Online")
	@Produces("application/json")
	@POST
	public Response onlineOrder(@FormParam("CustomerDeliveryInformation") String customerDeliveryInformation) {
		
	
	//check if the customer is valid customer
		OnlineOfflineLogic logic = new OnlineOfflineLogic(customerDeliveryInformation);
		if(logic.ifValidCustomer()) {
			//get current time 
			Date date = new Date();   
			Calendar calendar = GregorianCalendar.getInstance(); 
			calendar.setTime(date);
			int current_hour = calendar.get(Calendar.HOUR_OF_DAY);
			if(current_hour > 8 && current_hour <10) {
				if(logic.ifValidCoupon()) {
					int order_id = logic.addCustomerOrder(date);
					
					response.setCode(200);
					response.setMessage("Order ID" + order_id);
					return response;
				}
			}
			else {
				response.setCode(401);
				response.setMessage("Invalid coupon code");
				return response;
			}
			
		}
		
		response.setCode(401);
		response.setMessage("Customer not registered");
		return response;
		
	}

}
