package org.spearhead.bookmyticket.search.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController("/search")
public class SearchController {
	@Value("${show.user.name}")
	private boolean showUser;

	@GetMapping
	public String welcome(@RequestParam String user) {
		user = showUser ? user : "";
		return new StringBuilder().append("Welcome ").append(user).append(" to Book My Ticket").toString();
	}
}
