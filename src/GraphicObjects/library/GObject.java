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
import java.util.ArrayList;

public class GObject implements PConstants {
	PApplet parentApplet;
	GraphicsProgram parentGraphicsProgram;
	float xPos;
	float yPos;
	float heightVal;
	float widthVal;
	float xVel;
	float yVel;
	int fillColor;
	int strokeColor;
	float strokeSize;
	float rotation;
	int zIndex;
	
	// Debugging
	boolean showBoundingBox;

	public static final int NO_STROKE = -1;

	public GObject(PApplet pApplet, float initX, float initY, float initWidth, float initHeight) {
		parentApplet = pApplet;
		xPos = initX;
		yPos = initY;
		widthVal = initWidth;
		heightVal = initHeight;

		rotation = 0;
		fillColor = parentApplet.color(255);
		strokeColor = parentApplet.color(0);
		xVel = 0;
		yVel = 0;
		strokeSize = NO_STROKE;
		showBoundingBox = false;
		zIndex = 0;
	}

	// override this and use super() to get the basic GObject styles
	public void display() {
		parentApplet.translate(getX(), getY());
		parentApplet.rotate(getRotation()); 

		if (showBoundingBox) {
			parentApplet.fill(parentApplet.color(127));
			parentApplet.rectMode(CENTER);
			parentApplet.rect(0, 0, getWidth(), getHeight());
		}

		parentApplet.fill(getFillColor());
		parentApplet.stroke(getStrokeColor());
		if (getStrokeSize() == NO_STROKE) {
			parentApplet.noStroke();  
		} else {
			parentApplet.strokeWeight(getStrokeSize());
		}
		
		// intentially don't reset matrix, do it in subclasses
	}

	public void setVel(float newXVel, float newYVel) {
		setXVel(newXVel);
		setYVel(newYVel); 
	}

	public float getXVel() {
		return xVel; 
	}

	public void setXVel(float newXVel) {
		xVel = newXVel;
	}

	public float getYVel() {
		return yVel;
	}

	public void setYVel(float newYVel) {
		yVel = newYVel;
	}

	public void move() {
		xPos += xVel;
		yPos += yVel;  
	}

	public void moveBy(float xDiff, float yDiff) {
		xPos += xDiff;
		yPos += yDiff; 
	}

	public void moveTo(float newX, float newY) {
		xPos = newX;
		yPos = newY; 
	}

	public float getX() {
		return xPos; 
	}

	public void setX(float newX) {
		xPos = newX; 
	}

	public float getY() {
		return yPos; 
	}

	public void setY(float newY) {
		yPos = newY; 
	}

	public float getLeft() {
		return xPos - widthVal/2;
	}

	public void setLeft(float newLeft) {
		setX(newLeft + getWidth()/2);
	}

	public float getRight() {
		return xPos + widthVal/2;
	}

	public void setRight(float newRight) {
		setX(newRight - getWidth()/2);
	}

	public float getTop() {
		return yPos - heightVal/2;
	}

	public void setTop(float newTop) {
		setY(newTop + getHeight()/2);
	}

	public float getBottom() {
		return yPos + heightVal/2;
	}

	public void setBottom(float newBottom) {
		setY(newBottom - getHeight()/2);
	}

	public float getWidth() {
		return widthVal; 
	}

	public void setWidth(float newWidth) {
		widthVal = newWidth; 
	}

	public float getHeight() {
		return heightVal; 
	}

	public void setHeight(float newHeight) {
		heightVal = newHeight; 
	}

	public int getFillColor() {
		return fillColor; 
	}

	public void setFillColor(int newFill) {
		fillColor = newFill;
	}

	public int getStrokeColor() {
		return strokeColor; 
	}

	public void setStrokeColor(int newStroke) {
		strokeColor = newStroke;
	}

	public float getStrokeSize() {
		return strokeSize; 
	}

	public void setStrokeSize(float newStrokeSize) {
		strokeSize = newStrokeSize; 
	}

	public void removeStroke() {
		strokeSize = NO_STROKE; 
	}

	public float getRotation() {
		return rotation; 
	}

	public void setRotation(float newRotation) {
		rotation = newRotation * (PI/180); 
	}

	public int getZIndex() {
		return zIndex; 
	}

	public void setZIndex(int newZIndex) {
		zIndex = newZIndex; 
		if (parentGraphicsProgram != null) parentGraphicsProgram.updateZIndex(this);
	}
	
	public void setParentGraphicsProgram(GraphicsProgram newGP) {
		parentGraphicsProgram = newGP;
	}
	
	public void setShowBoundingBox(boolean show) {
		showBoundingBox = show;
	}
}
