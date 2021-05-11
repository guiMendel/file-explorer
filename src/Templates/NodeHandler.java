import montefiore.ulg.ac.be.graphics.*;

abstract public class NodeHandler {
  protected ExplorerSwingView swingView;

  public NodeHandler(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  // Verifies all conditions for the operation
  abstract protected void conditionCheck(Object selectedNode) throws Exception;

  // Returns the component on which to perform the operation
  abstract protected Component getComponent(Object selectedNode) throws Exception;

  // Returns the component on which to perform the operation
  abstract protected void operateComponent(Component component) throws Exception;

  public void handle(Object selectedNode) throws Exception {
    // Check all conditions
    conditionCheck(selectedNode);

    // Get the handled component
    Component handledComponent = getComponent(selectedNode);

    // If no component, stop
    if (handledComponent == null)
      return;

    // Perform operation
    operateComponent(handledComponent);

    // Refresh tree
    swingView.refreshTree();
  }
}
