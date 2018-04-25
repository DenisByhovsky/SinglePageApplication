package com.epam.ajax.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** ActionCommand
 * @author Denis Byhovsky
 */
public interface ActionCommand {

    String PATH_XLS = "SkillMatrix.xls";

    String execute(HttpServletRequest req ,HttpServletResponse res) ;
}
