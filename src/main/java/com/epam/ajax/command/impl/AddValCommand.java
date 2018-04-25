package com.epam.ajax.command.impl;

import com.epam.ajax.command.ActionCommand;
import com.epam.ajax.exception.ServiceException;
import com.epam.ajax.service.ValueService;
import com.epam.ajax.service.impl.ValueServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** AddValCommand
 * @author Denis Byhovsky
 */
public class AddValCommand implements ActionCommand {

    private ValueService valueService = ValueServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req,HttpServletResponse resp)  {
        int row = Integer.parseInt(req.getParameter("row"));
        int column = Integer.parseInt(req.getParameter("col"));
        String name= req.getParameter("name");
        try {
            valueService.create(row,column,name,PATH_XLS);
            valueService.parseToJSON();
        } catch (IOException e) {
            new ServiceException(e);
        }
        return null;
    }
}
