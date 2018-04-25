package com.epam.ajax.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ActionCommand {
    String PATH_XLS = "SkillMatrix.xls";
    String PATH_JSON = "runner.json";
    String execute(HttpServletRequest req ,HttpServletResponse res) ;
}
