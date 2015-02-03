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

public class GSprite extends GObject {
	public static final int NO_TINT = -1;

	PImage image;
	int tintColor;

	public GSprite(PApplet papplet, String imageName, float initX, float initY, float initWidth, float initHeight) {
		super(papplet, initX, initY, initWidth, initHeight);

		setImage(imageName);
		tintColor = NO_TINT;
	}

	public void display() {
		super.display();
		parentApplet.imageMode(CENTER);

		if (tintColor != NO_TINT) parentApplet.tint(tintColor);

		parentApplet.image(image, 0, 0, getWidth(), getHeight()); 

		parentApplet.resetMatrix();
	} 

	public void setImage(String newImageName) {
		image = parentApplet.loadImage(newImageName); 
	}

	public int getTintColor() {
		return tintColor; 
	}

	public void setTintColor(int newTintColor) {
		tintColor = newTintColor; 
	}
}