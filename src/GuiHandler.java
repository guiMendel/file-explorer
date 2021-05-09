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
    // Forbid creating children for a file
    if (selectedNode instanceof JFile) {
      System.out.print("Bad boye!");
      return;
    }

    // Get user input for new file
    String[] response = swingView.fileMenuDialog();

    // If canceled, stop
    if (response == null) {
      return;
    }

    // Create new file
    JFile createdFile = new JFile(response[0], response[1]);

    // Insert file in tree
    try {
      swingView.addNodeToSelectedNode(createdFile);
    } catch (NoSelectedNodeException error) {
      System.out.print("Select a file, bad boye!");
      return;
    }

    // Refresh tree
    swingView.refreshTree();
  }

  @Override
  public void createFolderEvent(Object selectedNode) {
    // TODO Auto-generated method stub
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
}
