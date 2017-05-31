package com.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.util.UserList;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
public class UserListener implements HttpSessionAttributeListener {

	// 用户登录身份证
	private String userName;
	private UserList u1 = UserList.getInstance();

	// 判断用户是否存在
	public boolean IsExist(String sfz) throws Exception {
		try {

			return u1.IsExist(sfz);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public String getUSERNAME() {
		return this.userName;
	}

	public void setUSERNAME(String username) {
		this.userName = username;
	}

	/**
	 * Default constructor.
	 */
	public UserListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
		try{
			//这里要保证用户登录信息的键为userName
			if("userName".equals(se.getName())){
				  u1.addUser((String)se.getValue());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		try{
			if("userName".equals(event.getName())){
				u1.RemoveUser((String)event.getValue());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub
	}

}
