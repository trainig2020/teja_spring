package org;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
//@Component
//@Service
//@Repository
@Controller
public class Circle implements Shape{
private Point center;




public Point getCenter() {
	return center;
}
//@Required
//@Qualifier
@Resource(name="pointC")
public void setCenter(Point center) {
	this.center = center;
}

public void draw() {
		
		System.out.println("Circle point  is:" +center.getX()+"," +center.getY()+")");
		
	}
@PostConstruct
public void initializeCircle() {
	System.out.println("initialize circle");
}
@PreDestroy
public void destroyCircle() {
	System.out.println("initialize circle");
}
}
