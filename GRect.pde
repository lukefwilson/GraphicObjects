public class GRect extends GObject {
  GRect(float initX, float initY, float initWidth, float initHeight) {
    super(initX, initY, initWidth, initHeight);
  }

  void display() {
    rectMode(CENTER);
    fill(getFillColor());
    stroke(getStrokeColor());
    strokeWeight(getStrokeSize());
    translate(getX(), getY());
    rotate(getRotation());
    
    rect(0, 0, widthVal, heightVal); 
    
    resetMatrix();
  } 
}
