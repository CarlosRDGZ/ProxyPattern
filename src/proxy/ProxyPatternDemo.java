package proxy;

import java.util.Scanner;

public class ProxyPatternDemo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        CommandExecutor executor;
        String option = "";
        do
        {
            System.out.println("Login to run a command.");
            System.out.println("Select an option:");
            System.out.println("\n1.- Login.\n\n2.- Exit");
            option = in.nextLine();
            switch(option)
            {
                case "1":
                {
                    String user, password;
                    System.out.print("User: ");
                    user = in.nextLine();
                    System.out.print("Password: ");
                    password = in.nextLine();
                    executor = new CommandExecutorProxy(user, password);
            		try
                    {
            			executor.runCommand(" rm -rf abc.pdf");
            		}
                    catch (Exception e) {
            			System.out.println("Exception Message::"+e.getMessage());
            		}
                }
                break;
                case "2":
                    System.out.print("Goodbye.");
                break;

                default:
                    System.out.print("Incorrect option, try again.");
            }
        }while (!option.equals("2"));
    }
}
