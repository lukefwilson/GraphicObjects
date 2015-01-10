public static class GUtils {
 
   public static float difference(float first, float second) {
    return abs(first - second);
  }
  
  public static PVector midpoint(float x1, float y1, float x2, float y2) {
    return new PVector(average(x1, x2), average(y1, y2));
  }
  
  public static float average(float num1, float num2) {
    return (num1+num2)/2; 
  }
  
}
