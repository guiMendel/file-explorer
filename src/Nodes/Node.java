// Decorator for members of the Component class. Handles the node tree functionalities
public class Node implements ComponentInterface, Prototype<Node> {
  // Wrapped component
  Component component;

  // Parent folder
  FolderNode parentFolder;

  public Node(Component component, FolderNode parentFolder) throws InvalidNodeNameException {
    super();
    this.component = component;
    setParentFolder(parentFolder);
  }

  public Component getComponent() {
    return component;
  }

  public void setParentFolder(FolderNode newParent) throws InvalidNodeNameException {
    // Make sure the component's name isn't already taken
    if (newParent != null && newParent.contains(this)) {
      throw new InvalidNodeNameException(String.format("Duplicated name %s", getName()));
    }

    // If already had parent folder, unregister as it's child
    if (parentFolder != null) {
      parentFolder.remove(this);
    }

    // Update parentFolder
    parentFolder = newParent;

    // If no paren folder anymore, stop
    if (parentFolder == null)
      return;

    // Register as child of parent
    parentFolder.add(this);
  }

  // Prototype implementation
  @Override
  public Node copy() {
    // Copied component
    Component component = this.component.copy();

    // If copied component's name isn't available, add more (copy) to it until it is
    do {
      try {
        return new Node(component, parentFolder);
      } catch (InvalidNodeNameException error) {
        component = component.copy();
      }
    } while (true);
  }

  // Proxy methods

  @Override
  public String getName() {
    return component.getName();
  }

  @Override
  public void setName(String name) {
    component.setName(name);
  }

  @Override
  public String toString() {
    return component.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Node))
      return false;

    return component.equals(((Node) other).getComponent());
  }
}
