package edu.austral.ingsis.clifford;

public class FileSystem {

  private FileSystemComponent root;

  public FileSystem() {
    this.root = new Root();
    this.currentPath = root;
  }

  private FileSystemComponent currentPath;

  public void changePath(FileSystemComponent path) {
    this.currentPath = path;
  }

  public FileSystemComponent getRoot() {
    return root;
  }

  public FileSystemComponent getCurrentDirectory() {
    return currentPath;
  }
}
