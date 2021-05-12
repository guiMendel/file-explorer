import java.util.List;
import java.util.ArrayList;

public class FolderNode extends Node {
  // All children nodes of this folder
  List<Node> children;

  public FolderNode(Component component, FolderNode parentFolder) {
    super(component, parentFolder);
    children = new ArrayList<Node>();
  }

  // Prototype implementation
  @Override
  public FolderNode copy() {
    return new FolderNode(component.copy(), parentFolder);
  }
}
