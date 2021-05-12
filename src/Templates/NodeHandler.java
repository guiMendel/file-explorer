import montefiore.ulg.ac.be.graphics.*;

// Abstract mother class for node handling
abstract public class NodeHandler {
  protected ExplorerSwingView swingView;

  public NodeHandler(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  // Verifies all conditions for the operation
  abstract protected void conditionCheck(Object selectedNode) throws Exception;

  // Returns the node on which to perform the operation
  abstract protected Node getNode(Object selectedNode) throws Exception;

  // Perform operation
  abstract protected void operateNode(Node node) throws Exception;

  public void handle(Object selectedNode) throws Exception {
    // Check all conditions
    conditionCheck(selectedNode);

    // Get the handled node
    Node handledNode = getNode(selectedNode);

    // If no node, stop
    if (handledNode == null)
      return;

    // Perform operation
    operateNode(handledNode);

    // Refresh tree
    swingView.refreshTree();
  }
}
