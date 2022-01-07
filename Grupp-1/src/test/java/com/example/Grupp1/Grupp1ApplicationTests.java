package com.example.Grupp1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Grupp1ApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testId() {

		Joke joke = new Joke(10, "Title", "Family", "Hej hej ", "Lwam");
		Assertions.assertEquals(10, joke.getId());
	}

	@Test
	void test(){
		Joke joke = new Joke(10, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam");
		Assertions.assertEquals("Title", joke.getTitle());
	}

}
