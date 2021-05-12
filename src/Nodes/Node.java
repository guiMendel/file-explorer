// Decorator for members of the Component class. Handles the node tree functionalities
public class Node implements ComponentInterface, PrototypeInterface {
  // Wrapped component
  Component component;

  // Parent folder
  FolderNode parentFolder;

  public Node(Component component, FolderNode parentFolder) {
    super();
    this.component = component;
    this.parentFolder = parentFolder;
  }

  public Component getComponent() {
    return component;
  }

  // Prototype implementation
  @Override
  public Node copy() {
    return new Node(component.copy(), parentFolder);
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

}
