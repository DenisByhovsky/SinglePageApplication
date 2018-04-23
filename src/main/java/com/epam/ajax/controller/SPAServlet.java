package com.epam.ajax.controller;

import com.epam.ajax.excel.ExcelAction;
import com.epam.ajax.json.JSONRunner;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** SPAServlet
 * @author Denis Byhovsky
 */
@WebServlet("/command")
public class SPAServlet extends HttpServlet {

    public static final String EX_PATH ="SkillMatrix.xls";
    /**
     * Add element method.
     */
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

    /**
     * Delete element method.
     */
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

    /**
     * Change element method.
     */
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

    @Override
    public void destroy() {
        super.destroy();
    }
}