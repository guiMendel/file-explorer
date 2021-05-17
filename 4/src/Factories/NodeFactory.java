import montefiore.ulg.ac.be.graphics.*;

public abstract class NodeFactory {
  protected ExplorerSwingView swingView;

  public NodeFactory(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  protected abstract Node getNode(FolderNode parentFolder) throws NodeCreationException;

  public Node assemble(FolderNode parentFolder) throws NodeCreationException, NoSelectedNodeException {
    // Get subclass specific node
    Node node = getNode(parentFolder);

    // Report newly created node
    NodeInsertionChannel channel = NodeInsertionChannel.getChannel();
    try {
      channel.nodeCreatedEvent(node);
    }
    catch (NoSelectedNodeException error) {
      // Destroy all references to node so it gets collected
      node.setParentFolder(null);

      // Rethrow
      throw error;
    }

    return node;
  }
}
