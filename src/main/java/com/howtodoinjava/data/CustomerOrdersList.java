package com.howtodoinjava.data;

import java.util.ArrayList;
import java.util.List;

import com.howtodoinjava.pojo.CustomerDeliveryInformation;

public class CustomerOrdersList {
List<CustomerDeliveryInformation> customerOrderList = new ArrayList<CustomerDeliveryInformation>();
	
	public List<CustomerDeliveryInformation> getCustomerOrderList() {
		return customerOrderList;
	}

	public void addCustomerOrder(CustomerDeliveryInformation customerDelivery) {
		customerOrderList.add(customerDelivery);
	}
}
