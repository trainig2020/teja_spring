package org;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public class Circle implements Shape,ApplicationEventPublisherAware{
private Point center;
private ApplicationEventPublisher publisher;




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
		System.out.println("drawing circle");
		System.out.println("Circle point  is:" +center.getX()+"," +center.getY()+")");
		DrawEvent drawEvent=new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}
@PostConstruct
public void initializeCircle() {
	System.out.println("initialize circle");
}
@PreDestroy
public void destroyCircle() {
	System.out.println("initialize circle");
}
@Override
public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
	this.publisher=publisher;
	
}
}
