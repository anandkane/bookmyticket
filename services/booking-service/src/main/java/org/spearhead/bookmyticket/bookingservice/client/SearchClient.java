package org.spearhead.bookmyticket.bookingservice.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="search-service-client")
@RibbonClient(name = "just-anything")
public interface SearchClient {
	@RequestMapping(value = "/bookmyticket/v1/search", method = RequestMethod.GET)
	String search(@RequestParam(value = "user") String user);
}
