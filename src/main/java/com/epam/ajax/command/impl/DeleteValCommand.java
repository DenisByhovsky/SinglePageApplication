package com.epam.ajax.command.impl;

import com.epam.ajax.command.ActionCommand;
import com.epam.ajax.exception.ServiceException;
import com.epam.ajax.service.ValueService;
import com.epam.ajax.service.impl.ValueServiceImpl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** DeleteValCommand
 * @author Denis Byhovsky
 */
public class DeleteValCommand implements ActionCommand {

    private ValueService valueService = ValueServiceImpl.getInstance();

    @Override
    public String execute(HttpServletRequest req,HttpServletResponse resp) throws ServiceException {
        int row = Integer.parseInt(req.getParameter("row"));
        int column = Integer.parseInt(req.getParameter("col"));
        try {
            valueService.delete(row,column,req.getServletContext().getRealPath("/")+PATH_XLS);
            valueService.parseToJSON();
        } catch (IOException e) {
            throw new ServiceException(e);
        }
        return null;
    }
}
