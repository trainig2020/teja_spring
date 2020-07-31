package org;

import java.awt.Point;
import java.util.List;

public class Triangle {
	private List<Point> points;
	
	
public List<Point> getPoints() {
		return points;
	}


	public void setPoints(List<Point> points) {
		this.points = points;
	}


public void draw() {
	for(Point point:points) {
	System.out.println();
	
	System.out.println("Point A=("+point.getX()+",  "+ point.getY() +")");
	System.out.println("Point B=("+point.getX()+",  "+ point.getY() +")");
	System.out.println("Point C=("+point.getX()+",  "+ point.getY() +")");
	
}
}

}
