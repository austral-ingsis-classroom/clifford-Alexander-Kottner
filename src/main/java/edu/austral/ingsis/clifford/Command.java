package edu.austral.ingsis.clifford;

import java.util.List;

public interface Command {
  String execute(FileSystem fileSystem, List<String> commandSpecs);

  String getName();
}
