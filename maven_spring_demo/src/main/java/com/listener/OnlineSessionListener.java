package com.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.util.OnlineList;

/**
 * Application Lifecycle Listener implementation class OnlineSessionListener
 *
 */
public class OnlineSessionListener implements HttpSessionListener {
	private OnlineList ol = OnlineList.getInstance();
    /**
     * Default constructor. 
     */
    public OnlineSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("有一个人登陆了，总共"+ol.getActiveSession());
    	ol.addSession();
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         // TODO Auto-generated method stub
    	System.out.println("有一个人登出了，总共"+ol.getActiveSession());
    	ol.delSession();
    }
	
}
