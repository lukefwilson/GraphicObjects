# graphic-objects: for [Processing](https://www.processing.org)
This library allows you to hold objects of 2d primitives for object oriented drawing and basic game building. Each GObject holds its own properties (position, color, rotation, etc.). You then add the GObjects to your GraphicsProgram, which handles drawing them.

GObjects are designed with 2d games in mind. They have `xVel`ocity and `yVel`ocity fields, and convenience functions for moving them.

___This is a work in progress, and not currently set up as a library. The main file is `breakout.pde`; run it to see a simple implementation of breakout using the library-in-progress___

### Currently implemented:
- GraphicsProgram
- GObject
  - GOval
  - GRect
  - GLabel
  - GLine
  - GSprite

### Need to have:
- GObjects --> z-index
- add simple collision function to GraphicsProgram

### Should have:
- GPoly
- GTriangle
- GObjects --> scale
- GObjects --> anchor points

### Cool to have: (future)
- GObject.addChild() [add children to other GObjects, allowing multi-shape objects]
- Perfect (and optimized) collision detection for each main type of GObject (Rect, Circle, Line to start)
- Animation tweening
