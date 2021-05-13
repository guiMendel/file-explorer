// Decorator for members of the Component class. Handles the node tree functionalities
public class Node implements ComponentInterface {
  // Wrapped component
  ComponentInterface component;

  // Parent folder
  FolderNode parentFolder;

  public Node(ComponentInterface component, FolderNode parentFolder) throws InvalidNodeNameException {
    super();
    this.component = component;
    setParentFolder(parentFolder);
  }

  public ComponentInterface getComponent() {
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

  // Copies this node into another folder
  public Node copyTo(FolderNode parentFolder) throws Exception {
    // Copied component
    ComponentInterface component = (ComponentInterface) this.component.copy();

    // If copied component's name isn't available, add more (copy) to it until it is
    do {
      try {
        Node node = new Node(component, parentFolder);

        // Report that this node was copied
        reportCopy(node);
        return node;

      } catch (InvalidNodeNameException error) {
        component = component.copy();
      }

    } while (true);
  }

  // Reports that this node has created a copy
  protected void reportCopy(Node node) throws Exception {
    NodeInsertionChannel channel = NodeInsertionChannel.getChannel();
    channel.nodeCopiedEvent(node);
  }

  // Prototype implementation
  @Override
  public Node copy() throws Exception {
    return copyTo(this.parentFolder);
  }

  // Proxy methods

  @Override
  public String getName() {
    return component.getName();
  }

  @Override
  public String toString() {
    return getName();
  }

  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Node))
      return false;

    return component.equals(((Node) other).getComponent());
  }
}
