import montefiore.ulg.ac.be.graphics.*;

// Class for duplicating nodes
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
    if (!(selectedNode instanceof Node)) {
      throw new InvalidSelectedNodeException("Cannot copy an alias");
    }
  }

  // Returns the node on which to perform the operation
  @Override
  protected Node getNode(Object selectedNode) throws Exception {
    // At this point we know for sure selectedNode is a Node
    Node node = (Node) selectedNode;

    // Copy the node
    return node.copy();
  }

  // Perform operation
  @Override
  protected void operateNode(Node node) throws Exception {
    return;
    // swingView.addNodeToParentNode(node);
  }
}
