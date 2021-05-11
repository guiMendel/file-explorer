public class JFolder extends JComponent {
  JFolder(String name) {
    super(name);
  }

  @Override
  public JComponent copy() {
    return new JFolder(name + " (copy)");
    // TODO recursive copying of children
  }
}
