package com.servlet;

import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ClassRoom;
import com.service.RoomService;

public class RoomServlet  extends HttpServlet{
	
	private static final long serialVersionUID = -8698408024290512707L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        String method = req.getParameter("method");
        if ("add".equals(method)) {
            this.addRoom(req, resp);
        } else if ("del".equals(method)) {
            this.delRoom(req, resp);
        } else {
            this.getAllRoom(req, resp);
        }
	}

    private void getAllRoom(HttpServletRequest req, HttpServletResponse resp) {
        try {
            RoomService service = new RoomService();
            List<ClassRoom> rooms = service.getAllRoom();
            req.setAttribute("rooms", rooms);
            RequestDispatcher dispatcher = req.getRequestDispatcher("rooms.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addRoom(HttpServletRequest req, HttpServletResponse resp) {
        String number = req.getParameter("number");
        String name = req.getParameter("name");
        try {
            PrintWriter out = resp.getWriter(); 
            RoomService service = new RoomService();
            service.addRoom(Integer.parseInt(number), name);
            resp.setContentType("text/html"); 
            out.println("add successfully");
            out.println("<a href=\"/rooms\">Show All</a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void delRoom(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            PrintWriter out = resp.getWriter(); 
            RoomService service = new RoomService();
            service.delRoom(Integer.parseInt(id));
            resp.setContentType("text/html"); 
            out.println("delete successfully");
            out.println("<a href=\"/rooms\">Show All</a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
