package RunProgram;

public class Runner {

    private String[] commands;

    public Runner(String[] commands) {
        if (commands.length == 0){
            new FrontEnd();
        } else {
            this.commands = commands;
            Run();
        }
    }

    public void Run() {
        if (commands[0].equals("ENCRYPT") || commands[0].equals("DECRYPT") || commands[0].equals("BRUTE_FORCE")) {
            new GuiInConsole(commands);
        } else {
            new GuiInConsole();
        }
    }
}
