package edu.austral.ingsis.clifford;

import java.util.List;

public class Touch implements Command {

  private final String name = "touch";

  @Override
  public String execute(FileSystem fileSystem, List<String> commandSpecs) {
    String name = commandSpecs.get(1);
    FileSystemComponent current = fileSystem.getCurrentDirectory();
    if (current instanceof Directory) {
      Directory currentDirectory = (Directory) current;
      currentDirectory.add(new File(name, currentDirectory));
    } else {
      return "Cannot create file in a file";
    }
    return "'" + name + "'" + " file created";
  }

  @Override
  public String getName() {
    return name;
  }
}
