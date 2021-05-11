import montefiore.ulg.ac.be.graphics.*;

public class NodeMaker extends NodeHandler {
  ComponentFactory factory;
  
  public NodeMaker(ExplorerSwingView swingView, ComponentFactory factory) {
    super(swingView);
    this.factory = factory;
  }

  // Verifies all conditions for the operation
  @Override
  protected void conditionCheck(Object selectedNode) throws Exception {
    // Forbid creating children for a file
    if (selectedNode instanceof FileComponent) {
      throw new InvalidSelectedNodeException("Files cannot have children nodes");
    }
  }

  // Returns the component on which to perform the operation
  @Override
  protected Component getComponent(Object selectedNode) throws Exception {
    return factory.assemble();
  }

  // Returns the component on which to perform the operation
  @Override
  protected void operateComponent(Component component) throws Exception {
    swingView.addNodeToSelectedNode(component);
  }
}
