package com.nagoya.controller.recommend;

import com.nagoya.controller.action.*;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {
		super();
	}
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
	Action action = null;
	if(command.equals("root_write_form")) {
		action = new RootWriteFormAction();
	}else if(command.equals("root_write")) {
		action = new RootWriteAction();
	}else if(command.equals("root_list")) {
		action = new RootListAction();
	}
	return action;
	}
}	
