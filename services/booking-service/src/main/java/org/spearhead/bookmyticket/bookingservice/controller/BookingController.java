package org.spearhead.bookmyticket.bookingservice.controller;

import org.spearhead.bookmyticket.bookingservice.client.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/booking")
public class BookingController {

	private SearchClient searchClient;

	@Autowired
	public void setSearchClient(SearchClient searchClient) {
		this.searchClient = searchClient;
	}

	@GetMapping
	public String bookTicket(@RequestParam String user) {
		StringBuilder builder = new StringBuilder();
		builder.append(searchClient.search(user)).append(", your ticket booking is confirmed");
		return builder.toString();
	}
}
