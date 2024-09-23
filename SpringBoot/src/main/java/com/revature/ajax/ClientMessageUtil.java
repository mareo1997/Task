package com.revature.ajax;

public class ClientMessageUtil {
	public static final ClientMessage REGISTRATION_SUCCESSFUL = new ClientMessage("REGISTRATION SUCCESSFUL");
	public static final ClientMessage UPDATE_SUCCESSFUL = new ClientMessage("UPDATE SUCCESSFUL");
	public static final ClientMessage SOMETHING_WRONG = new ClientMessage("SOMETHING WENT WRONG");
	public static final ClientMessage INVALID_DATA = new ClientMessage("INVALID FORM DATA");
	public static final ClientMessage TASK_NOT_FOUND = new ClientMessage("TASK NOT FOUND IN THE DB");
}