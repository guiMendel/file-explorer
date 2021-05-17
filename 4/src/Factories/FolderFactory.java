import montefiore.ulg.ac.be.graphics.*;

public class FolderFactory extends NodeFactory {
  public FolderFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  public static Node makeFolderNode(String name, FolderNode parentFolder) throws InvalidNodeNameException {
    return new FolderNode(new FolderComponent(name), parentFolder);
  }

  @Override
  public Node getNode(FolderNode parentFolder) throws NodeCreationException {
    // Get user input
    String input = swingView.folderMenuDialog();

    // Handle canceling
    if (input == null)
      throw new UserCanceledException();

    // Wrap folder in FolderNode
    return makeFolderNode(input, parentFolder);
  }
}
