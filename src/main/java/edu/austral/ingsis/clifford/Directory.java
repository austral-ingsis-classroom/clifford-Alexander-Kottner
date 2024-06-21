package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory implements FileSystemComponent {

  private List<FileSystemComponent> children = new ArrayList<>();

  private Date creationDate;

  private FileSystemComponent parent;
  private String name;

  private String path;

  public Directory(String name, FileSystemComponent parentPath) {
    this.parent = parentPath;
    this.name = name;
    this.path = parentPath.getPath() + "/" + name;
    this.creationDate = new Date();
  }

  public FileSystemComponent getParent() {
    return parent;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return path;
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
  public Date getCreationDate() {
    return creationDate;
  }

  public void add(FileSystemComponent component) {
    children.add(component);
  }

  public void remove(FileSystemComponent component) {
    children.remove(component);
  }

  public List<FileSystemComponent> getChildren() {
    return children;
  }
}
