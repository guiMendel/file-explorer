import montefiore.ulg.ac.be.graphics.*;

public class NodeReplicator extends NodeHandler {
  public NodeReplicator(ExplorerSwingView swingView) {
    super(swingView);
  }

  // Verifies all conditions for the operation
  @Override
  protected void conditionCheck(Object selectedNode) throws Exception {
    // Forbid copying root folder
    if (swingView.isRootNodeSelected()) {
      throw new InvalidSelectedNodeException("Cannot copy root folder");
    }

    // Forbid copying alias
    if (!(selectedNode instanceof Component)) {
      throw new InvalidSelectedNodeException("Cannot copy an alias");
    }
  }

  // Returns the component on which to perform the operation
  @Override
  protected Component getComponent(Object selectedNode) throws Exception {
    // At this point we know for sure selectedNode is a Component
    Component component = (Component) selectedNode;

    // Copy the node
    return component.copy();
  }

  // Perform operation
  @Override
  protected void operateComponent(Component component) throws Exception {
    swingView.addNodeToParentNode(component);
  }
}
