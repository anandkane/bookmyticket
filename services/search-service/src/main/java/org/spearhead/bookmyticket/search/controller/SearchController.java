package org.spearhead.bookmyticket.search.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/search")
public class SearchController {
	private boolean showUser;

	private int port;

	@Value("${show.user.name}")
	public void setShowUser(boolean showUser) {
		this.showUser = showUser;
	}

	@Value("${server.port}")
	public void setPort(int port) {
		this.port = port;
	}

	@GetMapping
	public String search(@RequestParam String user) {
		System.out.println("Serving request by service running at " + port);
		user = showUser ? user : "";
		return new StringBuilder().append("Welcome ").append(user).append(" to Book My Ticket").toString();
	}
}
