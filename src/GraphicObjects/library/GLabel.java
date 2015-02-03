/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      ##author##
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */


package GraphicObjects.library;

import processing.core.*;

public class GLabel extends GObject {
  String text;
  int textAlignX;
  int textAlignY;
  String fontName;
  float fontSize;
  PFont font;
  float lineHeight;
  
  public static final int DEFAULT_LINE_HEIGHT = -1;
  public static final int UNSET_SIZE = -1;

  private boolean fixedHeight;
  private boolean fixedWidth;

  // use this constructor to have a text box with fixed yet mutable height and width.
  // call wrapBoundingBox() to start dynamically setting height and width, based on the text 
  public GLabel(PApplet papplet, String initText, float initX, float initY, float initWidth, float initHeight) {
    super(papplet, initX, initY, initWidth, initHeight);
    text = initText;
    fixedHeight = true;
    fixedWidth = true;
    setDefaults();
  }

  // use this constructor to have free form text, the height and width are computed
  public GLabel(PApplet papplet, String initText, float initX, float initY) {
    super(papplet, initX, initY, UNSET_SIZE, UNSET_SIZE);
    text = initText;
    fixedHeight = false;
    fixedWidth = false;
    setDefaults();
  }

  private void setDefaults() {
    textAlignX = CENTER;
    textAlignY = CENTER;
    lineHeight = DEFAULT_LINE_HEIGHT;
    fontName = "SansSerif";
    fontSize = 16;
    setFont(fontName);
  }

  public void display() {
    super.display();
    parentApplet.rectMode(CENTER);
    parentApplet.textAlign(textAlignX, textAlignY);
    parentApplet.textFont(font);
    parentApplet.textSize(fontSize);
    parentApplet.textLeading(getLineHeight());

    if (fixedWidth && fixedHeight) {
    	parentApplet.text(text, 0, 0, getWidth(), getHeight());
    } else {
    	parentApplet.text(text, 0, 0);
    }    

    parentApplet.resetMatrix();
  }

  public String getText() {
    return text;
  }

  public void setText(String newText) {
    text = newText;
    updateSize();
  }

  public void setFont(String newFontName) {
    fontName = newFontName;
    font = parentApplet.createFont(fontName, 72, true);
    updateSize();
  }

  public float getFontSize() {
    return fontSize;
  }

  public void setFontSize(float newFontSize) {
    fontSize = newFontSize; 
    updateSize();
  }

  // assumes the current font and size have already been set for generating the line height 
  public float getLineHeight() {
    if (lineHeight != DEFAULT_LINE_HEIGHT) return lineHeight;
    return parentApplet.textAscent() + parentApplet.textDescent();
  }

  public void setLineHeight(float newLineHeight) {
    lineHeight = newLineHeight;
    updateSize();
  }

  public void resetLineHeight() {
    lineHeight = DEFAULT_LINE_HEIGHT;
    updateSize();
  }

  public void wrapBoundingBox() {
    fixedWidth = false;
    fixedHeight = false;
    updateSize();
  }

  public void setWidth(float newWidth) {
    super.setWidth(newWidth);
    fixedWidth = true;
  }

  public void setHeight(float newWidth) {
    super.setHeight(newWidth);
    fixedHeight = true;
  }

  private void updateSize() {
    if (fixedWidth && fixedHeight) return;
    parentApplet.textFont(font);
    parentApplet.textSize(fontSize);
    parentApplet.textLeading(getLineHeight());

    if (!fixedWidth) {
      super.setWidth(parentApplet.textWidth(text));
    }

    if (!fixedHeight) {
      int numLines = text.split("\n", -1).length;
      super.setHeight(numLines * getLineHeight());
    }
  }

  // Not available for now b/c it will affect bounding box
  //  int getTextAlignX() {
  //    return textAlignX;
  //  }
  //
  //  void setTextAlignX(int newTextAlignX) {
  //    textAlignX = newTextAlignX;
  //  }
  //
  //  int getTextAlignY() {
  //    return textAlignY;
  //  }
  //
  //  void setTextAlignY(int newTextAlignY) {
  //    textAlignY = newTextAlignY;
  //  }
}
