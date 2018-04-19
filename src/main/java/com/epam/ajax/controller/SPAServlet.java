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

    public static final String EX_PATH ="7.xls";

    //Add element
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xlsPath = req.getServletContext().getRealPath("/")+EX_PATH ;
        int row = Integer.parseInt(req.getParameter("row"));
        int column = Integer.parseInt(req.getParameter("col"));
        String name= req.getParameter("name");
        new ExcelAction().sheetOperation(row,column,"add",name,xlsPath);
        new JSONRunner().createJSON();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(name);
    }

    //Delete element
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xlsPath = req.getServletContext().getRealPath("/")+EX_PATH ;
        int row = Integer.parseInt(req.getParameter("row"));
        int column = Integer.parseInt(req.getParameter("col"));
        String name= req.getParameter("name");
        new ExcelAction().sheetOperation(row,column,"delete",name,xlsPath);
        new JSONRunner().createJSON();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(req.getParameter(name));
    }

    //Change element
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String xlsPath = req.getServletContext().getRealPath("/")+EX_PATH ;
        String name = req.getParameter("name");
        int row = Integer.parseInt(req.getParameter("row"));
        int column = Integer.parseInt(req.getParameter("col"));
        new ExcelAction().sheetOperation(row,column,"change",name,xlsPath);
        new JSONRunner().createJSON();
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(name);
    }

}