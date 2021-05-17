import montefiore.ulg.ac.be.graphics.*;

public class FileFactory extends NodeFactory {
  public FileFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  public static Node makeFileNode(String name, String text, FolderNode parentFolder) throws InvalidNodeNameException {
    return new Node(new FileComponent(name, text), parentFolder);
  }

  @Override
  public Node getNode(FolderNode parentFolder) throws NodeCreationException {
    // Get user input
    String[] input = swingView.fileMenuDialog();

    // Handle canceling
    if (input == null)
      throw new UserCanceledException();

    // Wrap file in Node
    return makeFileNode(input[0], input[1], parentFolder);
  }
}
