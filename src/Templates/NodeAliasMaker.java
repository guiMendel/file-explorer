import montefiore.ulg.ac.be.graphics.*;

// Class for making new nodes
public class NodeAliasMaker extends NodeHandler {
  public NodeAliasMaker(ExplorerSwingView swingView) {
    super(swingView);
  }

  // Verifies all conditions for the operation
  @Override
  protected void conditionCheck(Node node) throws Exception {
    // Forbid creating alias for anything other than a file
    if (node instanceof Alias || !(node.getComponent() instanceof FileComponent)) {
      throw new InvalidSelectedNodeException("Only files may have aliases");
    }
  }

  // Perform operation
  @Override
  protected void operateNode(Node node) throws Exception {
    AliasFactory factory = new AliasFactory(swingView);
    factory.aliasFor(node);
  }
}
