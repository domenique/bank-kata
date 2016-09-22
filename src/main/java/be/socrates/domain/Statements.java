package be.socrates.domain;

import java.util.ArrayList;
import java.util.List;

public class Statements {

  private List<Statement> statements;

  public Statements() {
    this.statements = new ArrayList<>();
  }

  public void add(Statement statement) {
    this.statements.add(statement);
  }

  public void print(StatementPrinter printer) {
    printer.printHeader();
    statements.stream()
        .sorted((first, second) -> second.date.compareTo(first.date))
        .forEach(statement -> statement.print(printer));
  }
}
