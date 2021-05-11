import montefiore.ulg.ac.be.graphics.*;

public class GuiHandler implements ExplorerEventsHandler {
  private ExplorerSwingView swingView;
  private TextAreaManager textArea;

  GuiHandler(String[] args) throws NullHandlerException {
    this.swingView = new ExplorerSwingView(this);
    this.textArea = this.swingView.getTextAreaManager();

    try {
      this.swingView.setRootNode(new JFolder("I'm root"));
    } catch (RootAlreadySetException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void createAliasEvent(Object selectedNode) {
    // TODO Auto-generated method stub
  }

  @Override
  public void createArchiveEvent(Object selectedNode) {
    // TODO Auto-generated method stub
  }

  @Override
  public void createCopyEvent(Object selectedNode) {
    // TODO Auto-generated method stub
  }

  @Override
  public void createFileEvent(Object selectedNode) {
    createNewNode(selectedNode, new JFileFactory(swingView));
  }

  @Override
  public void createFolderEvent(Object selectedNode) {
    createNewNode(selectedNode, new JFolderFactory(swingView));
  }

  @Override
  public void doubleClickEvent(Object selectedNode) {
    if (selectedNode instanceof JFile) {
      // Downcast
      JFile file = (JFile) selectedNode;

      // Update text area
      textArea.clearAllText();
      textArea.appendText(file.getText());
    }
  }

  @Override
  public void eventExit() {
    // TODO Auto-generated method stub
  }

  // Creates a new node (using the provided factory) as a child of the given node
  private void createNewNode(Object selectedNode, JComponentFactory factory) {
    NodeHandler nodeHandler = new NodeHandler(swingView, factory);
    nodeHandler.emplaceNode(selectedNode);
  }
}
