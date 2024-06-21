package edu.austral.ingsis.clifford;

import java.util.List;

public class Cd implements Command {

  private final String name = "cd";

  @Override
  public String execute(FileSystem fileSystem, List<String> commandSpecs) {
    String changeTo = fileSystem.getCurrentDirectory().getPath() + "/" + commandSpecs.get(1);
    if (commandSpecs.get(1).equals("..")) {
      fileSystem.changePath(fileSystem.getCurrentDirectory().getParent());
      return "moved to directory " + fileSystem.getCurrentDirectory().getName();
    } else if (commandSpecs.get(1).equals(".")) {
      return "Already in current directory";
    } else if (commandSpecs.get(1).charAt(0) == '/') {
      if (commandSpecs.get(1).equals("/")) {
        fileSystem.changePath(fileSystem.getRoot());
        return "moved to directory " + fileSystem.getCurrentDirectory().getName();
      }
      FileSystemComponent child = fileSystem.getRoot().getChild(commandSpecs.get(1));
      if (child == null) {
        return "'" + commandSpecs.get(1) + "'" + " directory does not exist";
      }
      fileSystem.changePath(child);
      return "moved to directory:" + fileSystem.getCurrentDirectory().getName();
    } else {
      FileSystemComponent child = fileSystem.getCurrentDirectory().getChild(changeTo);
      if (child == null) {
        return "'" + commandSpecs.get(1) + "'" + " directory does not exist";
      }
      fileSystem.changePath(child);
      return "moved to directory " + "'" + fileSystem.getCurrentDirectory().getName() + "'";
    }
  }

  @Override
  public String getName() {
    return name;
  }
}
