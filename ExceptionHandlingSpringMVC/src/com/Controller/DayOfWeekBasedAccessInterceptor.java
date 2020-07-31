package com.Controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar cal=Calendar.getInstance();
		int dayOfWeek=cal.get(cal.DAY_OF_WEEK);//geting day whic req made
		if(dayOfWeek==1) {
			response.getWriter().write("the website isclosed on sunday:please try accessing it"+
		              "on any other week day!!");
			return false;
			
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("HandlerInterceptorAdapter: SpringMVC called postHandle method for"
			+request.getRequestURI().toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HandlerInterceptorAdapter: SpringMVC called afterCompletion method for"
				+request.getRequestURI().toString());
	}
	

}
