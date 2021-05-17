import montefiore.ulg.ac.be.graphics.*;

// Abstract mother class for node handling
abstract public class NodeHandler {
  protected ExplorerSwingView swingView;

  public NodeHandler(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  // Verifies all conditions for the operation
  abstract protected void conditionCheck(Node node) throws Exception;

  // Performs operation
  abstract protected void operateNode(Node node) throws Exception;

  public void handle(Object selectedNode) throws Exception {
    // We know it's a node for sure
    Node node = (Node) selectedNode;
    
    // Check all conditions
    conditionCheck(node);

    // Perform operation
    operateNode(node);

    // Refresh tree
    swingView.refreshTree();
  }
}
