import montefiore.ulg.ac.be.graphics.*;

public class FileFactory extends NodeFactory {
  public FileFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  @Override
  public Node assemble(FolderNode parentFolder) {
    // Get user input
    String[] input = swingView.fileMenuDialog();

    // If canceled, stop
    if (input == null) return null;

    // Wrap file in Node
    return new Node(new FileComponent(input[0], input[1]), parentFolder);
  }
}
