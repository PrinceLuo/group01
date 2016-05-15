
package com.enterprise.service;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;

import com.enterprise.beans.UserBean;
import com.enterprise.jdbc.customerDTO;
import com.enterprise.jdbc.DAO.customerDAOImpl;

/**
 * @author group01
 * Methods that call the DAOs to access into the Database 
 * So you need a factory and extract the UserDAO from it
 * Also remember to add methods that inherit from interface
 */
public class UserServiceImpl extends Service {

	private customerDAOImpl customerDAO;
	/* (non-Javadoc)
	 * @see com.enterprise.business.Service#login(java.lang.String, java.lang.String)
	 */
	
	public UserServiceImpl(){
		customerDAO = new customerDAOImpl();
	}
	
	@Override
	public customerDTO customerlogin(String username, String password) {
		// TODO Auto-generated method stub
		// Shall call the tb_userDAO
		customerDTO customer = null;
		customer = customerDAO.find(username);
		if(!customer.getPassword().equals(password)){
			customer = null;
		}
		
		return customer;
	}
	

	public String register(String newuser, String newpassword, String newemail){
		String registerInfo = null; // if return the customer, success; else fail because duplicate
		customerDTO exist = customerDAO.find(newuser);
		if(exist!=null){
			// exist
			registerInfo = "The user already exists!"; //  User Existed! => The user already exists!
			return registerInfo;
		}
		
		customerDTO newcustomer = new customerDTO(0, newuser, newpassword, newemail);	

		/**
		 * Send E-mail here
		 */
		String to = newcustomer.getEmail();
		String from = "zealotshotelbooking@gmail.com";
		String host = "localhost";
		Properties properties = System.getProperties();
		//properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.user", "zealotshotelbooking@gmail.com"); // User name
		properties.put("mail.smtp.password", "COMP9321group03"); // password
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(
	                "zealotshotelbooking@gmail.com", "COMP9321group03");// Specify the Username and the PassWord
	        }
		});
		try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

	         // Set Subject: header field
	         message.setSubject("Registration");

	         // Now set the actual message
	         message.setText("Please click: http://localhost:8080/group01/activation.jsp?register=activate&username="+newcustomer.getUsername());

	         // Send message
	         Transport.send(message);
	         
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
		
		customerDAO.insertCustomer(newcustomer);
		exist = customerDAO.find(newuser);
		if(exist==null){
			registerInfo = "Registration fail!";
		} else {
			registerInfo = exist.getUsername();
		}
		return registerInfo;
	}
	
	public customerDTO editProfile(customerDTO old){
		
		customerDAO.updateCustomer(old);
		customerDTO change = customerDAO.find(old.getUsername());
		return change;
	}
	/**
	 * Methods that inherit from the interface Service
	 */
}
