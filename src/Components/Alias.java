public class Alias implements FileInterface {
  // Component this alias refers to
  FileComponent subject;

  public Alias(FileComponent subject) {
    super();
    this.subject = subject;
  }

  @Override
  public String getText() {
    return subject.getText();
  }

  @Override
  public String getName() {
    return subject.getName() + " (alias)";
  }

  @Override
  public String toString() {
    return getName();
  }

  // Allow comparing two different components
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Alias))
      return false;

    Alias castOther = (Alias) other;

    return getName().equals(castOther.getName()) && getClass().equals(castOther.getClass());
  }

  // Prototype implementation
  @Override
  public Alias copy() {
    return new Alias(subject);
  }
}
