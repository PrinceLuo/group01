
package com.enterprise.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author group01
 * Simple interface of all commands
 */
public interface Command {
	String execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException;
}
