import montefiore.ulg.ac.be.graphics.*;

public class NodeHandler {
  private ExplorerSwingView swingView;
  private JComponentFactory factory;

  public NodeHandler(ExplorerSwingView swingView, JComponentFactory factory) {
    this.swingView = swingView;
    this.factory = factory;
  }

  // Create new component and add it as child to provided node
  public void emplaceNode(Object selectedNode) {
    // Forbid creating children for a file
    if (selectedNode instanceof JFile) {
      System.out.print("Bad boye!");
      return;
    }

    // Create new component
    JComponent createdComponent = factory.assemble();

    // If canceled, stop
    if (createdComponent == null) {
      return;
    }

    // Insert component in tree
    try {
      swingView.addNodeToSelectedNode(createdComponent);
    } catch (NoSelectedNodeException error) {
      System.out.print("Select a file, bad boye!");
      return;
    }

    // Refresh tree
    swingView.refreshTree();
  }
  
}
