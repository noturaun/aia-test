package com.noturaun.flickrtest;

import com.noturaun.flickrtest.controller.FeedController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


@SpringBootTest
class FlickrtestApplicationTests {

	@Autowired
	private WebApplicationContext context;

	@Test
	@Disabled
	void test() {
		given().standaloneSetup(FeedController.class).param("tags", "cat")
				.when().get("/feeds")
				.then()
				.statusCode(200);
	}
}
