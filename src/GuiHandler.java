import montefiore.ulg.ac.be.graphics.*;

public class GuiHandler implements ExplorerEventsHandler {
  private ExplorerSwingView swingView;
  private TextAreaManager textArea;

  GuiHandler(String[] args) throws NullHandlerException {
    this.swingView = new ExplorerSwingView(this);
    this.textArea = this.swingView.getTextAreaManager();

    try {
      this.swingView.setRootNode(new FolderComponent("I'm root"));
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
    copyNode(selectedNode);
  }

  @Override
  public void createFileEvent(Object selectedNode) {
    createNewNode(selectedNode, new FileFactory(swingView));
  }

  @Override
  public void createFolderEvent(Object selectedNode) {
    createNewNode(selectedNode, new FolderFactory(swingView));
  }

  @Override
  public void doubleClickEvent(Object selectedNode) {
    if (selectedNode instanceof FileComponent) {
      // Downcast
      FileComponent file = (FileComponent) selectedNode;

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
  private void createNewNode(Object selectedNode, ComponentFactory factory) {
    try {
      NodeMaker nodeMaker = new NodeMaker(swingView, factory);
      nodeMaker.handle(selectedNode);
    } catch (NoSelectedNodeException | InvalidSelectedNodeException error) {
      swingView.showPopupError("Please, select a folder");
    } catch (Exception error) {
      swingView.showPopupError("An unexpected error occured");
    }
  }

  // Copy a node
  private void copyNode(Object selectedNode) {
    try {
      NodeReplicator nodeReplicator = new NodeReplicator(swingView);
      nodeReplicator.handle(selectedNode);
    } catch (NoSelectedNodeException error) {
      swingView.showPopupError("Please, select a file or a folder");
    } catch (NoParentNodeException error) {
      swingView.showPopupError("Cannot copy a component without a parent");
    } catch (InvalidSelectedNodeException error) {
      swingView.showPopupError(error.getMessage());
    } catch (Exception error) {
      swingView.showPopupError("An unexpected error occured");
    }
  }
}
