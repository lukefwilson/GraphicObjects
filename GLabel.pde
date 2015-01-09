public class GLabel extends GObject {
  String text;
  int textAlignX;
  int textAlignY;

  GLabel(String initText, float initX, float initY, float initWidth, float initHeight) {
    super(initX, initY, initWidth, initHeight);
    text = initText;
    textAlignX = CENTER;
    textAlignY = CENTER;
  }

  void display() {
    rectMode(CENTER);
    textAlign(textAlignX, textAlignY);
    fill(getFillColor());
    stroke(getStrokeColor());
    strokeWeight(getStrokeSize());
    translate(getX(), getY());
    rotate(getRotation());
    
    text(text, 0, 0, getWidth(), getHeight());     
    
    resetMatrix();
  } 
}
