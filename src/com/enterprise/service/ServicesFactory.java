package com.enterprise.service;

import java.util.Map;

public class ServicesFactory {
	
	private static String USER_SER = "userService";
	private static String MANAGER_SER = "managerService";
	private static String OWNER_SER = "ownerService";
	private Map services;
	private static ServicesFactory instance = new ServicesFactory();
	
	private ServicesFactory(){
		services.put(USER_SER, new UserServiceImpl());
		services.put(MANAGER_SER, new ManagerServiceImpl());
		services.put(OWNER_SER, new OwnerServiceImpl());
	}
	
	
	public static ServicesFactory getInstance(){
		return instance;
	}
	
	public UserServiceImpl getUserService(){
		return (UserServiceImpl) services.get(USER_SER);
	}
	
	public ManagerServiceImpl getManaerService(){
		return (ManagerServiceImpl) services.get(MANAGER_SER);
	}
	
	public OwnerServiceImpl getOwnerService(){
		return (OwnerServiceImpl) services.get(OWNER_SER);
	}
}
