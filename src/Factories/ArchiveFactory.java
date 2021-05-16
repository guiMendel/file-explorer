import montefiore.ulg.ac.be.graphics.*;

public class ArchiveFactory {
  protected ExplorerSwingView swingView;

  public ArchiveFactory(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  public Node makeArchive(String name, String extension, int compressionLevel, FolderNode parentFolder) throws InvalidNodeNameException {
    return new Node(new ArchiveComponent(name + extension, compressionLevel), parentFolder);
  }

  public Node archive(Node targetNode) throws Exception {
    // Make sure it's a folder
    if (!(targetNode instanceof FolderNode)) {
      throw new InvalidSelectedNodeException("Only folders may become archives");
    }

    // Get user input
    String inputName = swingView.displayArchiveWindow1();
    // Handle canceling
    if (inputName == null)
      throw new UserCanceledException();

    String inputExtension = swingView.displayArchiveWindow2();
    // Handle canceling
    if (inputExtension == null)
      throw new UserCanceledException();

    int inputCompressionLevel = swingView.displayArchiveWindow3();
    // Handle canceling
    if (inputCompressionLevel == -1)
      throw new UserCanceledException();

    // Get archive
    Node node = makeArchive(inputName, inputExtension, inputCompressionLevel, targetNode.getParentFolder());

    // Report newly created archive
    NodeInsertionChannel channel = NodeInsertionChannel.getChannel();
    try {
      channel.archiveCreatedEvent(node);
    } catch (NoSelectedNodeException | NoParentNodeException error) {
      // Destroy all references to node so it gets collected
      node.setParentFolder(null);

      // Rethrow
      throw error;
    }

    return node;
  }
}
