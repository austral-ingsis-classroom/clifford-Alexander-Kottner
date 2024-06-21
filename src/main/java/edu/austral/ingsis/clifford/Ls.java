package edu.austral.ingsis.clifford;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Ls implements Command {
  private final String name = "ls";

  @Override
  public String execute(FileSystem fileSystem, List<String> commandSpecs) {
    List<FileSystemComponent> children = fileSystem.getCurrentDirectory().getChildren();
    if (commandSpecs.size() == 1) {
      children.sort(Comparator.comparing(FileSystemComponent::getCreationDate));
      StringBuilder childrenNames = new StringBuilder();
      for (FileSystemComponent child : children) {
        childrenNames.append(child.getName()).append(" ");
      }
      return childrenNames.toString().trim();
    }
    if (Objects.equals(commandSpecs.get(1), "--ord=asc")) {
      children.sort((o1, o2) -> o2.getCreationDate().compareTo(o1.getCreationDate()));
      StringBuilder childrenNames = new StringBuilder();
      for (FileSystemComponent child : children) {
        childrenNames.append(child.getName()).append(" ");
      }
      return childrenNames.toString().trim();
    } else {
      children.sort(Comparator.comparing(FileSystemComponent::getCreationDate));
      StringBuilder childrenNames = new StringBuilder();
      for (FileSystemComponent child : children) {
        childrenNames.append(child.getName()).append(" ");
      }
      return childrenNames.toString().trim();
    }
  }

  @Override
  public String getName() {
    return name;
  }
}
