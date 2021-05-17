import montefiore.ulg.ac.be.graphics.*;

// Class for making new nodes
public class NodeArchiveMaker extends NodeHandler {
  public NodeArchiveMaker(ExplorerSwingView swingView) {
    super(swingView);
  }

  // Verifies all conditions for the operation
  @Override
  protected void conditionCheck(Node node) throws Exception {
    // Forbid creating archive for anything other than a folder
    if (!(node instanceof FolderNode)) {
      throw new InvalidSelectedNodeException("Only folders may become archives");
    }

    // Forbid archiving root folder
    if (swingView.isRootNodeSelected()) {
      throw new InvalidSelectedNodeException("Cannot archive root folder");
    }
  }

  // Perform operation
  @Override
  protected void operateNode(Node node) throws Exception {
    ArchiveFactory factory = new ArchiveFactory(swingView);
    factory.archive(node);
  }
}
