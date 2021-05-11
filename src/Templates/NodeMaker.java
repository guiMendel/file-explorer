import montefiore.ulg.ac.be.graphics.*;

public class NodeMaker extends NodeHandler {
  JComponentFactory factory;
  
  public NodeMaker(ExplorerSwingView swingView, JComponentFactory factory) {
    super(swingView);
    this.factory = factory;
  }

  // Verifies all conditions for the operation
  @Override
  protected void conditionCheck(Object selectedNode) throws Exception {
    // Forbid creating children for a file
    if (selectedNode instanceof JFile) {
      throw new InvalidSelectedNodeException("Files cannot have children nodes");
    }
  }

  // Returns the component on which to perform the operation
  @Override
  protected JComponent getComponent(Object selectedNode) throws Exception {
    return factory.assemble();
  }

  // Returns the component on which to perform the operation
  @Override
  protected void operateComponent(JComponent component) throws Exception {
    swingView.addNodeToSelectedNode(component);
  }
}
