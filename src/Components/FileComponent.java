public class FileComponent extends Component implements FileInterface {
  private String text;

  public FileComponent(String name, String text) {
    super(name);
    this.text = text;
  }

  @Override
  public String getText() {
    return text;
  }

  @Override
  public Component copy() {
    return new FileComponent(name + " (copy)", text);
  }
}
