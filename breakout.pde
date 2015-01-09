GraphicsProgram screen;

GOval ball;
GRect paddle;

int livesLeft;

ArrayList<GRect> bricks;

void setup() {
  size(600, 600);
  screen = new GraphicsProgram();
  
  livesLeft = 2;

  ball = new GOval(width/2, height-100, 20, 20);
  randomizeBallVelocity();
  screen.addObject(ball);

  paddle = new GRect(width/2, height-50, 100, 10);
  screen.addObject(paddle);

  setUpBricks();
}

void draw() {
  background(150);

  positionPaddle();
  
  if (livesLeft >= 0) moveBall();

  checkPaddleCollision();
  checkBrickCollisions();
  checkDeadBall();

  screen.display();
}

void resetBall() {
  ball.moveTo(width/2, height-100);
  randomizeBallVelocity();
}

void randomizeBallVelocity() {
  ball.xVel = random(2, 4);
  ball.yVel = random (2, 4); 
}

void setUpBricks() {
  bricks = new ArrayList<GRect>();

  int bricksInARow = 10;
  int numRows = 5;
  float brickHeight = 25;
  float brickWidth = 50;
  float horizontalSpacePerBrick = width/bricksInARow;
  float verticalSpacePerBrick = brickHeight + 15;

  for (int row = 0; row < numRows; row++) {
    for (int column = 0; column < bricksInARow; column++) {
      float xPos = column * horizontalSpacePerBrick + (brickWidth/2) + (horizontalSpacePerBrick-brickWidth)/2;
      float yPos = row * verticalSpacePerBrick + (brickHeight/2) + (verticalSpacePerBrick-brickHeight)/2;

      GRect brick = new GRect(xPos, yPos, brickWidth, brickHeight);
      screen.addObject(brick);
      bricks.add(brick);
    }
  }
}

void positionPaddle() {
  paddle.setX(mouseX);
  fixOffscreenPaddle();
}

void fixOffscreenPaddle() {
  if (paddle.getLeft() < 0) {
    paddle.setLeft(0);
  } else if (paddle.getRight() > width) {
    paddle.setRight(width);
  }
}

void moveBall() {
  if (shouldBounceX()) bounceX();
  if (shouldBounceY()) bounceY();
  ball.move();
}

void bounceX() {
  ball.setXVel(-ball.getXVel());
}

void bounceY() {
  ball.setYVel(-ball.getYVel());
}

boolean shouldBounceY() {
  return ball.getTop() < 0;
}

boolean shouldBounceX() {
  return ball.getRight() > width || ball.getLeft() < 0;
}

void checkPaddleCollision() {
  if (objectsAreColliding(ball, paddle)) {
    bounceY();
  }
}

void checkBrickCollisions() {
  for (int i = bricks.size ()-1; i >= 0; i--) {
    GRect brick = bricks.get(i);
    if (objectsAreColliding(ball, brick)) {
      bounceY();
      screen.removeObject(brick);
      bricks.remove(brick);
    }
  }
}

void checkDeadBall() {
  if (ball.getBottom() > height) {
     livesLeft--;
     resetBall();
  }
}

boolean objectsAreColliding(GObject obj1, GObject obj2) {
  // Check if one object is on the left side of the other
  if (obj1.getLeft() > obj2.getRight() || obj2.getLeft() > obj1.getRight()) {
    return false;
  }

  // Check is one object is below the other
  if (obj1.getTop() > obj2.getBottom() || obj2.getTop() > obj1.getBottom()) {
    return false;
  } 

  return true;
}

