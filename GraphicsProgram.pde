public class GraphicsProgram {
  ArrayList<GObject> screenItems;
 
  GraphicsProgram() {
    screenItems = new ArrayList<GObject>();
  }
  
  void display() {
    for (GObject object : screenItems) {
      object.display();
    }
  }
  
  void addObject(GObject object) {
    if (screenItems.indexOf(object) == -1) {
      screenItems.add(object); 
    }
  }
  
  void removeObject(GObject object) {
    screenItems.remove(object);
  }
}
