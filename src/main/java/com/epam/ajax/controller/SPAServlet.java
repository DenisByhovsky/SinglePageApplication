package com.epam.ajax.controller;


import com.epam.ajax.excel.ExcelAction;
import com.epam.ajax.json.JSONRunner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/command")
public class SPAServlet extends HttpServlet {

    //Add element
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int column = Integer.parseInt(req.getParameter("row"));
        int row = Integer.parseInt(req.getParameter("col"));
        String name= req.getParameter("name");
        new ExcelAction().sheetOperation(row,column,"add",name);
        new JSONRunner().createJSON();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("good");
    }

    //Delete element
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //int column = Integer.parseInt(req.getParameter("row"));
        //int row = Integer.parseInt(req.getParameter("col"));
        String name= req.getParameter("name");
        //new ExcelAction().sheetOperation(row,column,"delete",name);
        new JSONRunner().createJSON();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("good");;
    }

    //Change element
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int row = Integer.parseInt(req.getParameter("row"));
        int column = Integer.parseInt(req.getParameter("col"));
        new ExcelAction().sheetOperation(row,column,"change",name);
        new JSONRunner().createJSON();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write("good");
    }

}