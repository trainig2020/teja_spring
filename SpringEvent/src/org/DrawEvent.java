package org;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

public class DrawEvent extends ApplicationEvent {

	public DrawEvent(Object source) {
		super(source);
		
	}
public String toString() {
	return "Draw Event Occured";
}
}
