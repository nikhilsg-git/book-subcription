package com.example.subscriptionservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@FeignClient(name="book-service")
@RibbonClient(name="book-service")
public class SubscriptionController {
	
	@Autowired
	private SubscriptionRepository subsRepo;
	
//	@Autowired
//	private SubscriptionServiceProxy proxy;
	
	@RequestMapping(value="/subscriptions",method=RequestMethod.POST,produces="application/json")
//	public @ResponseBody Subscription subscribeForBooks(@RequestBody Subscription postSubscribe)
	public ResponseEntity<?> subscribeForBooks(@RequestBody Subscription postSubscribe)
	{	
		String bookId =  postSubscribe.getBookId();
		int available_copies=0;
		int flag=0;
		ResponseEntity<MyBooks[]> response = new RestTemplate().getForEntity("http://localhost:8002/books",MyBooks[].class);
		MyBooks[] list = response.getBody();
		for(MyBooks books:list) {
			if(books.getBookId().equals(bookId))
			{
				available_copies=books.getAvailableCopies();
				if(available_copies>0) {
					available_copies-=1;
					books.setAvailableCopies(available_copies);
					subsRepo.save(postSubscribe);
					String url="http://localhost:8002/books/"+bookId+"/"+available_copies;
					String result=new RestTemplate().getForObject(url,String.class);	
					flag=1;
				}
			}
			
		}
		
		if(flag==1)
			return new ResponseEntity<>(postSubscribe, HttpStatus.OK);
		else 
			return new ResponseEntity<>("Book not available",HttpStatus.UNPROCESSABLE_ENTITY);
				
			
	}
	
	
	@RequestMapping(value="/subscriptions",method=RequestMethod.GET)
	public List<Subscription> retrieveSubscriptions(@RequestParam(value = "subscriberName", required = false) String name) {
		
		String subscriber_name=name;
		if(subscriber_name!=null) {
			Subscription subscriptionByName= subsRepo.findBySubscriberName(subscriber_name);
			List<Subscription> ret_subsc= new ArrayList<>();
			ret_subsc.add(subscriptionByName);
			return ret_subsc;
			
		}
		else
		{
			List<Subscription> subscriptions = subsRepo.findAll();		
     		return subscriptions;
		}
		
		
	}
	
	
}
