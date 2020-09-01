//package com.example.subscriptionservicetest;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.client.ExpectedCount;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import com.example.subscriptionservice.Subscription;
//
//
//@Test
//public class SubscriptionControllerTest extends AbstractTest{
////	 
////	@Override
////	   @Before
////	   public void setUp() {
////	      super.setUp();
////	   }
////	
////	@Autowired
////	Subscription mysubs;
//	
////	SimpleDateFormat format = new SimpleDateFormat("DD-MM-YYYY");
//	
////	Subscription subs1=new Subscription("John",format.parse("12-JUN-2020"),format.parse(""),"B1212");
////	Subscription subs2=new Subscription("John",format.parse("12-JUN-2020"),format.parse(""),"B1212");
////	Subscription subs3=new Subscription("John",format.parse("12-JUN-2020"),format.parse(""),"B1212");
//////	
////	Subscription[] subs=new Subscription[3];
//	subs[1]=new Subscription();
//
//	
//
////	  Subscription expected[3]= {new Subscription("John",format.parse("12-JUN-2020"),format.parse(""),"B1212"),
////			  new Subscription("John",format.parse("12-JUN-2020"),format.parse(""),"B1212"),
////			  new Subscription("John",format.parse("12-JUN-2020"),format.parse(""),"B1212"),};
//	  
//	  
//	  
////	   @Test
////	   public void getProductsList() throws Exception {
////	      String uri = "/subscriptions";
////	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
////	         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
////	      
////	      int status = mvcResult.getResponse().getStatus();
////	      assertEquals(200, status);
////	      String content = mvcResult.getResponse().getContentAsString();
////	      Subscription[] subslist = super.mapFromJson(content, Subscription[].class);
////	      assertTrue(subslist.length > 0);
////	   }
//
//
//}
