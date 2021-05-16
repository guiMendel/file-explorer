import java.util.List;
import java.util.ArrayList;

import montefiore.ulg.ac.be.graphics.*;

public class GuiHandler implements ExplorerEventsHandler {
  private ExplorerSwingView swingView;
  private TextArea textArea;

  // Observers
  List<Observer<Node>> doubleClickObservers;

  GuiHandler(String[] args) throws NullHandlerException {
    this.swingView = new ExplorerSwingView(this);
    this.doubleClickObservers = new ArrayList<Observer<Node>>();

    // Create observers
    this.textArea = new TextArea(this.swingView);
    observeDoubleClick(this.textArea);

    // Set off node insertion channel
    NodeInsertionChannel channel = NodeInsertionChannel.getChannel();
    channel.setSwingView(this.swingView);

    try {
      // Create root node
      FolderNode root = (FolderNode) FolderFactory.makeFolderNode("I'm root", null);
      this.swingView.setRootNode(root);
    } catch (InvalidNodeNameException | RootAlreadySetException error) {
      error.printStackTrace();
    }
  }

  // Subscribes a new observer
  public void observeDoubleClick(Observer<Node> observer) {
    doubleClickObservers.add(observer);
  }

  @Override
  public void createAliasEvent(Object selectedNode) {
    aliasNode(selectedNode);
  }

  @Override
  public void createArchiveEvent(Object selectedNode) {
    archiveNode(selectedNode);
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
    for (Observer<Node> observer : doubleClickObservers) {
      observer.update((Node) selectedNode);
    }
  }

  @Override
  public void eventExit() {
    // TODO Auto-generated method stub
  }

  // Creates a new node (using the provided factory) as a child of the given node
  private void createNewNode(Object selectedNode, NodeFactory factory) {
    try {
      NodeMaker nodeMaker = new NodeMaker(swingView, factory);
      nodeMaker.handle(selectedNode);
    } catch (UserCanceledException exception) {
      return;
    } catch (NoSelectedNodeException | InvalidSelectedNodeException error) {
      swingView.showPopupError("Please, select a folder");
    } catch (InvalidNodeNameException error) {
      swingView.showPopupError("This name is not available");
    } catch (NodeCreationException error) {
      swingView.showPopupError("Invalid action");
    } catch (Exception error) {
      swingView.showPopupError("An unexcpected error occured");
    }
  }

  // Copy a node
  private void copyNode(Object selectedNode) {
    try {
      NodeReplicator nodeReplicator = new NodeReplicator(swingView);
      nodeReplicator.handle(selectedNode);
    } catch (UserCanceledException exception) {
      return;
    } catch (NoSelectedNodeException error) {
      swingView.showPopupError("Please, select a file or a folder");
    } catch (NoParentNodeException error) {
      swingView.showPopupError("Cannot copy a node without a parent");
    } catch (InvalidSelectedNodeException error) {
      swingView.showPopupError(error.getMessage());
    } catch (NodeCreationException error) {
      swingView.showPopupError("Invalid action");
    } catch (Exception error) {
      swingView.showPopupError("An unexcpected error occured");
    }
  }

  // Alias a node
  private void aliasNode(Object selectedNode) {
    try {
      NodeAliasMaker aliasMaker = new NodeAliasMaker(swingView);
      aliasMaker.handle(selectedNode);
    } catch (NoSelectedNodeException error) {
      swingView.showPopupError("Please, select a file");
    } catch (NoParentNodeException error) {
      swingView.showPopupError("Cannot create an alias of a node without a parent");
    } catch (InvalidSelectedNodeException error) {
      swingView.showPopupError(error.getMessage());
    } catch (InvalidNodeNameException error) {
      swingView.showPopupError("This file already has an alias");
    } catch (NodeCreationException error) {
      swingView.showPopupError("Invalid action");
    } catch (Exception error) {
      swingView.showPopupError("An unexcpected error occured");
    }
  }

  // Archive a node
  private void archiveNode(Object selectedNode) {
    try {
      NodeArchiveMaker aliasMaker = new NodeArchiveMaker(swingView);
      aliasMaker.handle(selectedNode);
    } catch (NoSelectedNodeException error) {
      swingView.showPopupError("Please, select a folder");
    } catch (NoParentNodeException error) {
      swingView.showPopupError("Cannot create an archive of a node without a parent");
    } catch (InvalidSelectedNodeException error) {
      swingView.showPopupError(error.getMessage());
    } catch (InvalidNodeNameException error) {
      swingView.showPopupError("This name is unavailable");
    } catch (NodeCreationException error) {
      swingView.showPopupError("Invalid action");
    } catch (Exception error) {
      swingView.showPopupError("An unexcpected error occured");
    }
  }
}
