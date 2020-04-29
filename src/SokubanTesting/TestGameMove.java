package SokubanTesting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Sokuban.*;

class TestGameMove {

	Game game;

	@BeforeEach
	void SetUp() throws Exception {
		this.game = new Game();
		game.addLevel("Test1", 5, 6, "######" + "#+x+.#" + "#..w.#" + "#....#" + "######");
	}

	@Test
	void testGameMove_moveLeft() {
		game.move(Direction.LEFT);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#.w..#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_moveDown() {
		game.move(Direction.DOWN);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#....#" + "\n" + "#..w.#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_moveRight() {
		game.move(Direction.RIGHT);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#...w#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_moveUp() {
		game.move(Direction.RIGHT);
		game.move(Direction.UP);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+w#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 2" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_attemptMoveRightIntoWall() {
		game.move(Direction.RIGHT);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#...w#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_attemptMoveLeftIntoWall() {
		game.move(Direction.LEFT);
		game.move(Direction.LEFT);
		game.move(Direction.LEFT);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#w...#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 3" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_attemptMoveDownIntoWall() {
		game.move(Direction.DOWN);
		game.move(Direction.DOWN);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+.#" + "\n" + "#....#" + "\n" + "#..w.#" + "\n"
				+ "######" + "\n" + "move 2" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_attemptMoveUpIntoWall() {
		game.move(Direction.RIGHT);
		game.move(Direction.UP);
		game.move(Direction.UP);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+x+w#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 3" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_moveToEmptyTarget() {
		game.move(Direction.UP);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#+xW.#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 1" + "\n" + "completed 0 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}

	@Test
	void testGameMove_pushCrateToTarget() {
		game.move(Direction.UP);
		game.move(Direction.LEFT);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#Xw+.#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 2" + "\n" + "completed 1 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);
	}
	
	@Test
	void testGameMove_pushCrateToWall() {
		game.move(Direction.UP);
		game.move(Direction.LEFT);
		game.move(Direction.LEFT);
		String expectedLevel = "Test1" + "\n" + "######" + "\n" + "#Xw+.#" + "\n" + "#....#" + "\n" + "#....#" + "\n"
				+ "######" + "\n" + "move 3" + "\n" + "completed 1 of 2" + "\n";
		String actualLevel = this.game.toString();
		assertEquals(expectedLevel, actualLevel);

	}
}
