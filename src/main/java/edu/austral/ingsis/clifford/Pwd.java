package edu.austral.ingsis.clifford;

import java.util.List;

public class Pwd implements Command {

  private final String name = "pwd";

  @Override
  public String execute(FileSystem fileSystem, List<String> commandSpecs) {
    String path = fileSystem.getCurrentDirectory().getPath();
    if (path.startsWith("root")) {
      return path.substring(4);
    }
    return fileSystem.getCurrentDirectory().getPath();
  }

  @Override
  public String getName() {
    return name;
  }
}
