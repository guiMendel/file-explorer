import montefiore.ulg.ac.be.graphics.*;

public class FileFactory extends NodeFactory {
  public FileFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  public static Node makeFileNode(String name, String text, FolderNode parentFolder) throws InvalidNodeNameException {
    return new Node(new FileComponent(name, text), parentFolder);
  }

  @Override
  public Node assemble(FolderNode parentFolder) throws InvalidNodeNameException {
    // Get user input
    String[] input = swingView.fileMenuDialog();

    // If canceled, stop
    if (input == null)
      return null;

    // Wrap file in Node
    return makeFileNode(input[0], input[1], parentFolder);
  }
}
