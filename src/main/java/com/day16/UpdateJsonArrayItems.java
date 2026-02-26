package com.day16;

import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateJsonArrayItems {

	public static void main(String[] args) {
		// Assignment to change the value of wireless mouse to laptop
		// Json Array will start and end with [] and also contains similar kind of JSON
		// objects

		String jsonPayload = """
				{
						  "orderId": "ORD-2025-12345",
						  "orderDate": "2025-01-15T10:30:00Z",
						  "customer": {
						    "customerId": 5678,
						    "name": "Michael Chen",
						    "email": "michael.chen@example.com"
						  },
						  "items": [
						    {
						      "productId": "PROD-001",
						      "name": "Wireless Mouse",
						      "quantity": 2,
						      "price": 29.99
						    },
						    {
						      "productId": "PROD-002",
						      "name": "USB Cable",
						      "quantity": 3,
						      "price": 9.99
						    }
						  ],
						  "shipping": {
						    "method": "Express",
						    "cost": 15.00,
						    "address": {
						      "street": "789 Pine Street",
						      "city": "Seattle",
						      "state": "WA",
						      "zipCode": "98101"
						    }
						  },
						  "payment": {
						    "method": "credit_card",
						    "last4": "4242",
						    "status": "paid"
						  },
						  "subtotal": 89.95,
						  "tax": 8.10,
						  "total": 113.05,
						  "status": "processing"
						}
					""";

		JSONObject jsonObject = new JSONObject(jsonPayload);
//		
//		System.out.println(jsonObject.toString(3));

		JSONArray itemsArray = jsonObject.getJSONArray("items");

		// the below code is hard coding to chnage the value of one product name but we
		// have to chnage where ever we see mouse so please iterate the array
//		System.out.println(itemsArray.getJSONObject(0).toString(2));
////		System.out.println(itemsArray.get(0));
//		itemsArray.getJSONObject(0).put("name", "Wired HeadSet");
//		System.out.println("The JSON array after update of product name: \n" + itemsArray.getJSONObject(0).toString(2));

		for (int index = 0; index < itemsArray.length(); index++) {
			JSONObject item = itemsArray.getJSONObject(index);
			if (item.getString("name").equalsIgnoreCase("Wireless Mouse")) {
				item.put("name", "Wired HeadSet");
			}
		}

		System.out.println("The JSON payload after update of product name: \n" + jsonObject.toString(3));

	}

}
