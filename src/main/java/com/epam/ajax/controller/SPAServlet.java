package com.epam.ajax.controller;


import com.epam.ajax.excel.ExcelAction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/command")
public class SPAServlet extends HttpServlet {

    //LOG
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String column = req.getParameter("row");
        String row = req.getParameter("col");
        String command = req.getParameter("command");

        if ((command != null) && (column != null)) {

            // Add or remove items from the Cart
            if ("addelem".equals(command)) {
                // cart.addItem(item);

            } else if ("delelem".equals(command)) {

            }


            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("GOOD");
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String column = req.getParameter("row");
        String row = req.getParameter("col");
        String command = req.getParameter("command");
        new ExcelAction().deleteRow("Skill Matrix","9.xls", Integer.parseInt(row),command);

        super.doPost(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String column = req.getParameter("row");
        String row = req.getParameter("col");
        String command = req.getParameter("command");
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}