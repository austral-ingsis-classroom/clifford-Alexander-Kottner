package edu.austral.ingsis.clifford;

import java.util.Date;
import java.util.List;

public interface FileSystemComponent {
  String getName();

  String getPath();

  FileSystemComponent getParent();

  FileSystemComponent getChild(String path);

  List<FileSystemComponent> getChildren();

  Date getCreationDate();
}
