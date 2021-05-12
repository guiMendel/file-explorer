import montefiore.ulg.ac.be.graphics.*;

public class FolderFactory extends NodeFactory {
  public FolderFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  @Override
  public Node assemble(FolderNode parentFolder) {
    // Get user input
    String input = swingView.folderMenuDialog();

    // If canceled, stop
    if (input == null) return null;

    // Wrap folder in FolderNode
    return new FolderNode(new FolderComponent(input), parentFolder);
  }
}
