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

public class GraphicsProgram {

	// parentApplet is a reference to the parent sketch
	PApplet parentApplet;

	int myVariable = 0;

	ArrayList<GObject> screenItems;

	public final static String VERSION = "##library.prettyVersion##";


	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 * 
	 * @example Breakout
	 * @param parent
	 */
	public GraphicsProgram() {
        checkNotNull(null, "You didn't pass 'this' when you created your GraphicsProgram.", "Correct usage: new GraphicsProgram(this);");
	}
	
	public GraphicsProgram(PApplet parent) {
		parentApplet = parent;
        screenItems = new ArrayList<GObject>();
        parent.registerMethod("draw", this);
	}
	
	public void draw() {
		display();
	}


	public void display() {
		for (int i = 0; i < screenItems.size (); i++) {
			screenItems.get(i).display();
		}
	}


	// adds new GObjects to screenItems based on their zIndex
	// objects with the same zIndex are displayed based on the order in which they were added
	public void addObject(GObject newObject) {
		if (screenItems.indexOf(newObject) == -1) {
			newObject.setParentGraphicsProgram(this);
			if (screenItems.size() == 0) {
				screenItems.add(newObject);
			} else {
				sortedInsert(newObject);
			}
		}
	}

	public void removeObject(GObject object) {
		object.setParentGraphicsProgram(null);
		screenItems.remove(object);
	}
	
	public void updateZIndex(GObject object) {
		if (screenItems.indexOf(object) != -1) {
			screenItems.remove(object);
			addObject(object);
		}
	}

	private void sortedInsert(GObject newObject) {
		for (int i = 0; i < screenItems.size (); i++) {
			GObject item = screenItems.get(i);
			if (compareGObjects(newObject, item) < 0) {
				screenItems.add(i, newObject);
				break;
			}
			if (i == screenItems.size()-1) {
				screenItems.add(newObject);
				break;
			}
		}
	}

	private int compareGObjects(GObject obj1, GObject obj2) {
		return obj1.getZIndex() - obj2.getZIndex();
	}


    private static void checkNotNull(final Object value, final String errorMessage, final String printMessage) {
        if (value == null) {
        	System.out.println(printMessage);
            throw new NullPointerException(errorMessage);
        }
    }

	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}
}