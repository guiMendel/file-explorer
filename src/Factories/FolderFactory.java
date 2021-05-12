import montefiore.ulg.ac.be.graphics.*;

public class FolderFactory extends NodeFactory {
  public FolderFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  public static Node makeFolderNode(String name, FolderNode parentFolder) throws InvalidNodeNameException {
    return new FolderNode(new FolderComponent(name), parentFolder);
  }

  @Override
  public Node assemble(FolderNode parentFolder) throws InvalidNodeNameException {
    // Get user input
    String input = swingView.folderMenuDialog();

    // If canceled, stop
    if (input == null)
      return null;

    // Wrap folder in FolderNode
    return makeFolderNode(input, parentFolder);
  }
}
