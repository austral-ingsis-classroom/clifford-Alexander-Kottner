package edu.austral.ingsis.clifford;

import java.util.List;

public class CLI {
  private final FileSystem fileSystem;

  private final List<Command> commandList =
      List.of(new Ls(), new Cd(), new Mkdir(), new Touch(), new Rm(), new Pwd());
  private final CommandParser commandParser;

  public CLI(FileSystem fileSystem, CommandParser commandParser) {
    this.fileSystem = fileSystem;
    this.commandParser = commandParser;
  }

  private String doCommand(List<String> command) {
    String primaryCommand = command.getFirst();
    for (Command c : commandList) {
      if (c.getName().equals(primaryCommand)) {
        return c.execute(fileSystem, command);
      }
    }
    return "Command not found";
  }

  public String command(String command) {
    List<String> commands = commandParser.parse(command);
    return doCommand(commands);
  }
}
