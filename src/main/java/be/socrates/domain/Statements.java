package be.socrates.domain;

import java.util.ArrayList;
import java.util.List;

class Statements {

  private List<Statement> statements;

  Statements() {
    this.statements = new ArrayList<>();
  }

  void add(Statement statement) {
    this.statements.add(statement);
  }

  void print(StatementPrinter printer) {
    printer.printHeader();
    statements.stream()
        .sorted((first, second) -> second.date.compareTo(first.date))
        .forEach(statement -> statement.print(printer));
  }
}
