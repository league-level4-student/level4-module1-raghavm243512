package _06_Snake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
	public static final Color SNAKE_COLOR = Color.BLUE;
	public static final int BODY_SIZE = 50;

	private SnakeSegment head;
	private ArrayList<SnakeSegment> snake;

	private Direction currentDirection;

	private boolean canMove = true;

	public Snake(Location location) {
		snake = new ArrayList<SnakeSegment>();
		head = new SnakeSegment(location, BODY_SIZE);
		snake.add(head);

		currentDirection = Direction.RIGHT;
	}

	public void feed() {
		//1. add a new SnakeSegment object to the snake
		snake.add(new SnakeSegment(snake.get(0).getLocation(), BODY_SIZE));
		
	}

	public Location getHeadLocation() {
		//2. return the location of the snake's head
		return snake.get(0).getLocation();
	}

	public void update() {
		//1. use a switch statement to check on the currentDirection
		//   of the snake and calculate its next x and y position.
		int x = snake.get(0).getLocation().x;
		int y = snake.get(0).getLocation().y;
		switch (currentDirection) {
		case UP: {
			y--;
			break;
		}
		case DOWN: {
			y++;
			break;
		}
		case LEFT: {
			x--;
			break;
		}
		case RIGHT: {
			x++;
			break;
		}
		}
		
		//2. Iterate through the SnakeSegments in reverse order
		//2a. Update each snake segment to the location of the segment 
		//    in front of it.
		for (int i = snake.size()-1;i>=1;i--) {
			snake.get(i).setLocation(snake.get(i-1).getLocation());
		}
		
		//3. set the location of the head to the new location calculated in step 1
		snake.get(0).setLocation(new Location(x,y));

		//4. set canMove to true
		canMove=true;
	}

	public void setDirection(Direction d) {
		//1. set the current direction equal to the passed in Direction only if canMove is true.
		//   set canMove equal to false.
		//   make sure the snake cannot completely reverse directions.
		currentDirection=d;
	}

	public void reset(Location loc) {
		//1. clear the snake
		snake = new ArrayList<SnakeSegment>();
		//2. set the location of the head
		head = new SnakeSegment(loc, BODY_SIZE);
		//3. add the head to the snake
		snake.add(head);
		
	}

	public boolean isOutOfBounds(int w, int h) {
		//1. complete the method so it returns true if the head of the snake is outside of the window
		//   and false otherwise
		if (getHeadLocation().x>w||getHeadLocation().x<0||getHeadLocation().y<0||getHeadLocation().y>h)
			return true;
		return false;
	}
	
	public boolean isHeadCollidingWithBody() {
		//1. complete the method so it returns true if the head is located
		//   in the same location as any other body segment
		for (int i = 2;i<snake.size();i++) {
			if (snake.get(i).getLocation().equals(getHeadLocation()))
				return true;
		}
		return false;
	}

	public boolean isLocationOnSnake(Location loc) {
		//1. complete the method so it returns true if the passed in
		//   location is located on the snake
		for (int i = 0;i<snake.size();i++) {
			if (snake.get(i).getLocation().equals(loc))
				return true;
		}
		return false;
	}

	public void draw(Graphics g) {
		for (SnakeSegment s : snake) {
			System.out.println(s.getLocation().x + " " + s.getLocation().y);
			s.draw(g);
		}
	}
}
