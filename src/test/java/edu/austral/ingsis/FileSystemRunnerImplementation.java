package edu.austral.ingsis;

import edu.austral.ingsis.clifford.CLI;
import java.util.ArrayList;
import java.util.List;

public class FileSystemRunnerImplementation implements FileSystemRunner {

  private final CLI client;

  public FileSystemRunnerImplementation(CLI client) {
    this.client = client;
  }

  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> result = new ArrayList<>();
    for (String command : commands) {
      result.add(client.command(command));
    }
    return result;
  }
}
