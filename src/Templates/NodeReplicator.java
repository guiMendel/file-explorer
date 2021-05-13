import montefiore.ulg.ac.be.graphics.*;

// Class for duplicating nodes
public class NodeReplicator extends NodeHandler {
  public NodeReplicator(ExplorerSwingView swingView) {
    super(swingView);
  }

  // Verifies all conditions for the operation
  @Override
  protected void conditionCheck(Node node) throws Exception {
    // Forbid copying root folder
    if (swingView.isRootNodeSelected()) {
      throw new InvalidSelectedNodeException("Cannot copy root folder");
    }

    // Forbid directly copying alias
    if (node.getComponent() instanceof Alias) {
      throw new InvalidSelectedNodeException("Cannot copy an alias");
    }
  }

  // Perform operation
  @Override
  protected void operateNode(Node node) throws Exception {
    // Copy the node
    node.copy();
  }
}