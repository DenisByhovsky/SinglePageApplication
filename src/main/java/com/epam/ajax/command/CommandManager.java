package com.epam.ajax.command;

import com.epam.ajax.command.impl.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

import static com.epam.ajax.command.Operation.convert;

/** CommandManager
 * @author Denis Byhovsky
 */
public class CommandManager {

    private static final Logger LOGGER = LogManager.getLogger(CommandManager.class.getName());

    private static Map<Operation, ActionCommand> map =  new HashMap<Operation, ActionCommand>();

    private CommandManager() { }

    static {
        map.put(Operation.ADD_VAL, new AddValCommand());
        map.put(Operation.DELETE_VAL, new DeleteValCommand());
        map.put(Operation.CHANGE_VAL, new ChangeValCommand());
    }

    public static ActionCommand takeActionCommand(String command){
        Operation operation= convert(command);
        LOGGER.log(Level.INFO,"Converted action command");
        if (operation== null) {
            throw new UnsupportedOperationException();
        }
        return map.get(operation);
    }
}
