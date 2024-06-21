package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Root implements FileSystemComponent {

  private List<FileSystemComponent> children = new ArrayList<>();

  private final String path = "root";

  private final Date creationDate = new Date();

  private final String name = "root";

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return name;
  }

  @Override
  public FileSystemComponent getParent() {
    return this;
  }

  @Override
  public FileSystemComponent getChild(String pathTo) {
    if (pathTo.equals(path)) {
      return this;
    }
    for (FileSystemComponent component : children) {
      FileSystemComponent child = component.getChild(pathTo);
      if (child != null) {
        return child;
      }
    }
    return null;
  }

  @Override
  public List<FileSystemComponent> getChildren() {
    return children;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  public void add(FileSystemComponent component) {
    children.add(component);
  }

  public void remove(FileSystemComponent component) {
    children.remove(component);
  }
}
