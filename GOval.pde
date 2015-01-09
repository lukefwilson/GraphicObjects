public class GOval extends GObject {
  GOval(float initX, float initY, float initWidth, float initHeight) {
    super(initX, initY, initWidth, initHeight);
  }

  void display() {
    ellipseMode(CENTER);
    fill(getFillColor());
    stroke(getStrokeColor());
    strokeWeight(getStrokeSize());
    translate(getX(), getY());
    rotate(getRotation());
    
    ellipse(0, 0, getWidth(), getHeight());     
    
    resetMatrix();
  } 
}
