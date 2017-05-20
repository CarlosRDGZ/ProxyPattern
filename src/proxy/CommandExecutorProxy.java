package proxy;

public class CommandExecutorProxy implements CommandExecutor
{

    private boolean isAdmin;
    private CommandExecutor executor;

    public CommandExecutorProxy(String user, String pass)
    {
        if("Daniel".equals(user) && "mendoza12".equals(pass) ||
            "Maricruz".equals(user) && "michel34".equals(pass) ||
            "Carlos".equals(user) && "rdgz56".equals(pass))
            isAdmin = true;
        else
            isAdmin = false;
        
        executor = new CommandExecutorImpl();
    }


    @Override
    public void runCommand(String cmd) throws Exception
    {
        if(isAdmin)
        {
            executor.runCommand(cmd);
	}
        else
        {
            if(cmd.trim().startsWith("rm"))
            {
		throw new Exception("rm command is not allowed for non-admin users.");
            }
            else
            {
		executor.runCommand(cmd);
            }
	}
    }
}
