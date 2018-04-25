package com.epam.ajax.controller;

import com.epam.ajax.command.ActionCommand;
import com.epam.ajax.command.CommandManager;
import com.epam.ajax.excel.ExcelAction;
import com.epam.ajax.excel.Processing;
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
@WebServlet("/controller")
public class SPAServlet extends HttpServlet {

    static final String COMMAND = "command";

    public SPAServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter(COMMAND);
        ActionCommand command = CommandManager.takeActionCommand(action);
        command.execute(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}