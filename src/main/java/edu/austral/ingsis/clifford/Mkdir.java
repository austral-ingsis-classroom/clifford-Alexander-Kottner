package edu.austral.ingsis.clifford;

import java.util.List;

public class Mkdir implements Command {

  private final String name = "mkdir";

  @Override
  public String execute(FileSystem fileSystem, List<String> commandSpecs) {
    String name = commandSpecs.get(1);
    FileSystemComponent current = fileSystem.getCurrentDirectory();
    if (current instanceof Directory) {
      Directory currentDirectory = (Directory) current;
      currentDirectory.add(new Directory(name, currentDirectory));
    } else if (current instanceof Root) {
      Root currentDirectory = (Root) current;
      currentDirectory.add(new Directory(name, currentDirectory));
    } else {
      return "Not a directory";
    }
    return "'" + name + "'" + " directory created";
  }

  @Override
  public String getName() {
    return name;
  }
}
