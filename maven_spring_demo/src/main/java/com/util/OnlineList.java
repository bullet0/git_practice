package com.util;

public class OnlineList {
	private static final OnlineList onlineList = new OnlineList();
	private int maxSession;
	private int activeSession;

	private OnlineList() {}

	public static OnlineList getInstance() {
		return onlineList;
	}

	public void addSession() {
		activeSession++;
		if (activeSession >= maxSession) {
			maxSession = activeSession;
		}
	}

	public void delSession() {
		if (activeSession > 0)
			activeSession--;
	}

	public int getActiveSession() {
		return activeSession;
	}

	public int getmaxSession() {
		return maxSession;
	}
}

