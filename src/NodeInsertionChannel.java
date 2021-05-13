import montefiore.ulg.ac.be.graphics.*;

// A singleton class dedicated to receiving information of any new nodes
// and then executing the appropriated routine
public class NodeInsertionChannel {
  // Singleton instance
  private static NodeInsertionChannel instance;

  // Swing view on which to operate
  private ExplorerSwingView swingView;

  // Counter that goes up for each node inserted in the same folder
  private int folderNodeInsertionLevel;

  // Make singleton
  private NodeInsertionChannel() {
    super();
    folderNodeInsertionLevel = 0;
  }

  public static NodeInsertionChannel getChannel() {
    if (instance == null) {
      instance = new NodeInsertionChannel();
    }
    return instance;
  }

  public void setSwingView(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  //////////////// INSERTION INTERFACE

  // Handles any user created node events
  public void nodeCreatedEvent(Node node) throws NoSelectedNodeException {
    swingView.addNodeToSelectedNode(node);
  }

  // Handles any copied node events
  public void nodeCopiedEvent(Node node) throws NoParentNodeException, NoSelectedNodeException {
    // If this node was copied by the user
    if (folderNodeInsertionLevel == 0) {
      swingView.addNodeToParentNode(node);
    }
  }
}
