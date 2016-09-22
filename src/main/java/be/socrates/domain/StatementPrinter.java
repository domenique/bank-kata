package be.socrates.domain;

public interface StatementPrinter {

  void printHeader();

  void print(Statement statement);

  void printSummary(Money amount);
}
