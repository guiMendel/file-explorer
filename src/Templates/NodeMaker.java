import montefiore.ulg.ac.be.graphics.*;

// Class for making new nodes
public class NodeMaker extends NodeHandler {
  NodeFactory factory;

  public NodeMaker(ExplorerSwingView swingView, NodeFactory factory) {
    super(swingView);
    this.factory = factory;
  }

  // Verifies all conditions for the operation
  @Override
  protected void conditionCheck(Object selectedNode) throws Exception {
    // Forbid creating children for anything other than a folder
    if (!(selectedNode instanceof FolderNode)) {
      throw new InvalidSelectedNodeException("Only folders may have children");
    }
  }

  // Returns the node on which to perform the operation
  @Override
  protected Node getNode(Object selectedNode) throws Exception {
    // We know for sure this node is a folder
    return factory.assemble((FolderNode) selectedNode);
  }

  // Perform operation
  @Override
  protected void operateNode(Node node) throws Exception {
    swingView.addNodeToSelectedNode(node);
  }
}
