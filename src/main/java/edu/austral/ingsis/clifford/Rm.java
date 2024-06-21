package edu.austral.ingsis.clifford;

import java.util.List;

public class Rm implements Command {

  private final String name = "rm";

  @Override
  public String execute(FileSystem fileSystem, List<String> commandSpecs) {
    if (commandSpecs.size() == 2) {
      String name = commandSpecs.get(1);
      FileSystemComponent current = fileSystem.getCurrentDirectory();
      if (current instanceof Directory) {
        Directory currentDirectory = (Directory) current;
        FileSystemComponent toRemove = currentDirectory.getChild(current.getPath() + "/" + name);
        if (toRemove instanceof File) {
          currentDirectory.remove(toRemove);
        } else {
          return "cannot remove directory without --recursive";
        }
      } else {
        return "Not a directory";
      }
      return "'" + name + "'" + " removed";
    } else if (commandSpecs.size() == 3) {
      String name = commandSpecs.get(2);
      FileSystemComponent current = fileSystem.getCurrentDirectory();
      if (current instanceof Directory) {
        Directory currentDirectory = (Directory) current;
        FileSystemComponent toRemove = currentDirectory.getChild(current.getPath() + "/" + name);
        if (toRemove instanceof File) {
          currentDirectory.remove(toRemove);
        } else {
          if (commandSpecs.get(1).equals("--recursive")) {
            currentDirectory.remove(toRemove);
          } else {
            return "Cannot remove a directory without --recursive";
          }
        }
      } else {
        return "Not a directory";
      }
      return "'" + name + "'" + " removed";
    }
    return "Invalid command";
  }

  @Override
  public String getName() {
    return name;
  }
}
