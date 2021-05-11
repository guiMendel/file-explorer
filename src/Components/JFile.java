public class JFile extends JComponent {
  private String text;

  public JFile(String name, String text) {
    super(name);
    this.text = text;
  }

  public String getText() {
    return text;
  }

  // @Override
  // public JComponent copy() {
    
  // }
}
