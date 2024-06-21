package edu.austral.ingsis.clifford;

import java.util.List;

public class CommandParser {

  public List<String> parse(String command) {
    return List.of(command.split(" "));
  }
}
