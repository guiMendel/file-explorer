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
  protected void conditionCheck(Node node) throws Exception {
    // Forbid creating children for anything other than a folder
    if (!(node instanceof FolderNode)) {
      throw new InvalidSelectedNodeException("Only folders may have children");
    }
  }

  // Perform operation
  @Override
  protected void operateNode(Node node) throws Exception {
    // We know for sure this node is a folder
    factory.assemble((FolderNode) node);
  }
}
