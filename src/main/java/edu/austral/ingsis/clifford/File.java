package edu.austral.ingsis.clifford;

import java.util.Date;
import java.util.List;

public class File implements FileSystemComponent {

  private String name;

  private String path;
  private Date creationDate;

  private FileSystemComponent parent;

  public File(String name, FileSystemComponent parentPath) {
    this.parent = parentPath;
    this.name = name;
    this.path = parentPath.getPath() + "/" + name;
    this.creationDate = new Date();
  }

  public FileSystemComponent getParent() {
    return parent;
  }

  @Override
  public FileSystemComponent getChild(String pathTo) {
    if (pathTo.equals(path)) {
      return this;
    }
    return null;
  }

  @Override
  public List<FileSystemComponent> getChildren() {
    return null;
  }

  @Override
  public Date getCreationDate() {
    return creationDate;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getPath() {
    return path;
  }
}
