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

public class GLine extends GObject {
	PVector first;
	PVector second;
	int strokeCap;

	public GLine(PApplet papplet, float initX1, float initY1, float initX2, float initY2) {
		super(papplet, GUtils.average(initX1, initX2), GUtils.average(initY1, initY2), GUtils.difference(initX1, initX2), GUtils.difference(initY1, initY2));

		first = new PVector(initX1, initY1);
		second = new PVector(initX2, initY2);
		strokeCap = ROUND;
		setStrokeSize(1);
	}

	public void display() {
		super.display();

		parentApplet.strokeCap(strokeCap);

		float avgX = GUtils.average(first.x, second.x);
		float avgY = GUtils.average(first.y, second.y);

		parentApplet.line(first.x-avgX, first.y-avgY, second.x-avgX, second.y-avgY); 

		parentApplet.resetMatrix();
	}

	public void setPoints(float x1, float y1, float x2, float y2) {
		first.x = x1;
		first.y = y1;
		second.x = x2;
		second.y = y2;

		setX(GUtils.average(x1, x2));
		setY(GUtils.average(y1, y2));
		setWidth(GUtils.difference(x1, x2));
		setHeight(GUtils.difference(y1, y2));
	}

	public PVector getFirstPoint() {
		return first; 
	}

	public PVector getSecondPoint() {
		return second;
	}

	public int getStrokeCap() {
		return strokeCap; 
	}

	public void setStrokeCap(int newStrokeCap) {
		strokeCap = newStrokeCap;
	}
}
