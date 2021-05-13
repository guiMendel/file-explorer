import montefiore.ulg.ac.be.graphics.*;

public class AliasFactory {
  protected ExplorerSwingView swingView;

  public AliasFactory(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  public Node aliasFor(Node targetNode) throws Exception {
    // Make sure it's a file and isn't an alias
    if (targetNode instanceof Alias || !(targetNode.getComponent() instanceof FileComponent)) {
      throw new InvalidSelectedNodeException("Only files may have aliases");
    }

    // Get alias
    Node node = new Alias(targetNode, targetNode.getParentFolder());

    // Report newly created alias
    NodeInsertionChannel channel = NodeInsertionChannel.getChannel();
    try {
      channel.aliasCreatedEvent(node);
    }
    catch (NoSelectedNodeException | NoParentNodeException error) {
      // Destroy all references to node so it gets collected
      node.setParentFolder(null);

      // Rethrow
      throw error;
    }

    return node;
  }
}
