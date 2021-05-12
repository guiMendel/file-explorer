public class FolderComponent extends Component {
  FolderComponent(String name) {
    super(name);
  }

  @Override
  public Component copy() {
    return new FolderComponent(name + " (copy)");
  }
}
