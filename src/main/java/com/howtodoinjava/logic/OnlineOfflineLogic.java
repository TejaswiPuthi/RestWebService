package com.howtodoinjava.logic;


import java.io.IOException;
import java.util.Date;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.howtodoinjava.data.CustomerList;
import com.howtodoinjava.data.CustomerOrdersList;
import com.howtodoinjava.pojo.Customer;
import com.howtodoinjava.pojo.CustomerDeliveryInformation;
//import com.fasterxml.jackson.core.JsonParser;


public class OnlineOfflineLogic {
	
	ObjectMapper mapper = new ObjectMapper();
	//converting string to object
	CustomerDeliveryInformation delivery = new CustomerDeliveryInformation();
	
	public OnlineOfflineLogic(String customerDeliveryInformation){
		try {
			System.out.println(customerDeliveryInformation);
			delivery = mapper.readValue(customerDeliveryInformation,CustomerDeliveryInformation.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//to check if the customer is valid or not
	public boolean ifValidCustomer() {
		
	//check the id of the customer;
		CustomerList customerList = new CustomerList();
		for(Customer customer:customerList.getCustomers()) {
		
			if(delivery.getCustomerId() == customer.getId()) {
				return true;
			}
		
	}
		return false;

}
	public boolean ifValidCoupon() {
		
		if (delivery.getCouponCode().equals("McDCoupon")){
			return true;
		}
		return false;
	}
	
	public int addCustomerOrder(Date date) {
		
		CustomerOrdersList list = new CustomerOrdersList();
		delivery.setOrderTime(date);
		int order_id = (list.getCustomerOrderList().size())+1;
		delivery.setOrderId(order_id);
		list.addCustomerOrder(delivery);
		return order_id;
		
	}
	

}
