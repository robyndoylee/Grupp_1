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
	void test(){
		Joke joke = new Joke(10, "Title", "Family"," HEJ HEJ ROLIGT", "Lwam");
		Assertions.assertEquals(10, joke.getId());
	}

}
