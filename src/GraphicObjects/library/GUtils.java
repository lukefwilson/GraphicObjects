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

public class GUtils {

	public static float difference(float first, float second) {
		return PApplet.abs(first - second);
	}

	public static PVector midpoint(float x1, float y1, float x2, float y2) {
		return new PVector(average(x1, x2), average(y1, y2));
	}

	public static float distance(float x1, float y1, float x2, float y2) {
		return PApplet.sqrt(PApplet.pow(x2-x1, 2) + PApplet.pow(y2-y1, 2));
	}

	public static float average(float num1, float num2) {
		return (num1+num2)/2;
	}

	public static boolean objectsAreColliding(GObject obj1, GObject obj2) {
		// Check if one object is on the left side of the other
		if (obj1.getLeft() > obj2.getRight() || obj2.getLeft() > obj1.getRight()) {
			return false;
		}

		// Check is one object is below the other
		if (obj1.getTop() > obj2.getBottom() || obj2.getTop() > obj1.getBottom()) {
			return false;
		} 

		return true;
	}
}
