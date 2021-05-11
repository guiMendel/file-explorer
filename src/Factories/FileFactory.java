import montefiore.ulg.ac.be.graphics.*;

public class FileFactory extends ComponentFactory {
  public FileFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  @Override
  public Component assemble() {
    // Get user input
    String[] input = swingView.fileMenuDialog();

    // Make file
    return input != null ? new FileComponent(input[0], input[1]) : null;
  }
}
