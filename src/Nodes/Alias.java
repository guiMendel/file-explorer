public class Alias extends Node {
  public Alias(Node subject, FolderNode parentFolder) throws InvalidNodeNameException, InvalidSelectedNodeException {
    super(subject, parentFolder);

    // Prevent creating alias of alias
    if (subject instanceof Alias) {
      // Delete references to self
      setParentFolder(null);
      throw new InvalidSelectedNodeException("Only files may have aliases");
    }
  }

  // Alias mimics it's subject's behavior
  @Override
  public ComponentInterface getComponent() {
    return ((Node) component).getComponent();
  }

  @Override
  public String getName() {
    return component.getName() + " (alias)";
  }

  // Allow comparing two different components
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Alias))
      return false;

    Alias castOther = (Alias) other;

    return getName().equals(castOther.getName()) && getClass().equals(castOther.getClass());
  }

  // Create another alias that points to same component
  @Override
  public Node copyTo(FolderNode parentFolder) throws Exception {
    Alias clone = new Alias((Node) component, parentFolder);

    // Report that this node was copied
    reportCopy(clone);
    return clone;
  }
}
