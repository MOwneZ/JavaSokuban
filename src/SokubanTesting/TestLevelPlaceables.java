package SokubanTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Sokuban.*;

class TestLevelPlaceables {

	Level level;

	@BeforeEach
	void setUp() {
		this.level = new Level("Level1", 5, 6, "######" + "#+x..#" + "#..w.#" + "#....#" + "######");
	}

	@Test
	void testLevelWidth() {
		assertEquals(6, level.getWidth());
	}

}
