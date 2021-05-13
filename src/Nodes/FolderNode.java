import java.util.List;
import java.util.ArrayList;

public class FolderNode extends Node {
  // All children nodes of this folder
  List<Node> children;

  public FolderNode(ComponentInterface component, FolderNode parentFolder) throws InvalidNodeNameException {
    super(component, parentFolder);
    children = new ArrayList<Node>();
  }

  // Add a new node as child
  public void add(Node child) {
    children.add(child);
  }

  // Remove a child
  public void remove(Node child) {
    children.remove(child);
  }

  // Verifies if the provided node is already present among the children
  public boolean contains(Node node) {
    return children.contains(node);
  }

  // Prototype implementation
  @Override
  public FolderNode copy() {
    // Copied component
    ComponentInterface component = (ComponentInterface) this.component.copy();

    // Copied node
    FolderNode clone = null;

    // Indicates whether the copied component has a valid name
    boolean componentValid = false;

    // If copied component's name isn't available, add more (copy) to it until it is
    do {
      try {
        clone = new FolderNode(component, parentFolder);
        componentValid = true;
      } catch (InvalidNodeNameException error) {
        component = component.copy();
      }
    } while (!componentValid);

    return clone;
    // TODO recursive copying of children
  }

  // Adds a copy of all nodes in the provided list to the given FolderNode
  
}
