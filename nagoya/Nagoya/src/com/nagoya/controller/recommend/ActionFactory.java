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
	}else if(command.equals("root_view")) {
		action = new RootViewAction();
	}else if(command.equals("root_delete")) {
		action = new RootDeleteAction();
	}else if(command.equals("root_modify")) {
		action = new RootModifyAction();
	}else if(command.equals("root_update")) {
		action = new RootUpdateAction();
	}
	else if(command.equals("notice_list")) {
		action = new NoticeListAction();
	}else if(command.equals("notice_write_form")) {
		action = new NoticeWriteFormAction();
	}else if(command.equals("notice_write")) {
		action = new NoticeWriteAction();
	}
	return action;
	}
}	
