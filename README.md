# [GraphicObjects](https://github.com/lukefwilson/GraphicObjects/raw/master/distribution/GraphicObjects-1/download/GraphicObjects.zip): for [Processing](https://www.processing.org)
This library allows you to hold objects of 2d primitives for object oriented drawing and basic game building. Each GObject holds its own properties (position, color, rotation, etc.). You then add the GObjects to your GraphicsProgram, which handles drawing them.

GObjects are designed with 2d games in mind. They have `xVel`ocity and `yVel`ocity fields, and convenience functions for moving them.

This library was built to teach object oriented programming at [StreetCode Academy](http://www.liveinpeace.org/streetcode-academy/). 


1. [Download the .zip](https://github.com/lukefwilson/GraphicObjects/raw/master/distribution/GraphicObjects-1/download/GraphicObjects.zip)
2. Put it in `Processing/libraries`
3. Reference it in your sketch using: `import GraphicObjects.library.*`
4. Look at the Breakout example for usage

### Currently implemented:
- GraphicsProgram
- GObject
  - GOval
  - GRect
  - GLabel
  - GLine
  - GSprite
- GUtil
  - average
  - difference
  - midpoint
  - distance
  - objectCollision (bounding rect over rect)

### Should have:
- GPoly
- GTriangle
- GObjects --> scale
- GObjects --> anchor points

### Cool to have: (future)
- GObject.addChild() [add children to other GObjects, allowing multi-shape objects]
- Perfect (and optimized) collision detection for each main type of GObject (Rect, Circle, Line to start)
- Animation tweening
