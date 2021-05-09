public class JFile {
  private String name;
  private String text;

  public JFile(String name, String text) {
    super();
    this.name = name;
    this.text = text;
  }

  public String getName() {
    return name;
  }

  public String getText() {
    return text;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
