public class GSprite extends GObject {
  PImage image;
  
  GSprite(String imageName, float initX, float initY, float initWidth, float initHeight) {
    super(initX, initY, initWidth, initHeight);
    
    image = loadImage(imageName);
    
    resetMatrix();
  }

  void display() {
    super.display();
    imageMode(CENTER);
    
    image(image, 0, 0, getWidth(), getHeight()); 
    
    resetMatrix();
  } 
  
  void setImage(String newImageName) {
    image = loadImage(newImageName); 
  }
}
