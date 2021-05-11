import montefiore.ulg.ac.be.graphics.*;

public class FolderFactory extends ComponentFactory {
  public FolderFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  @Override
  public Component assemble() {
    // Get user input
    String input = swingView.folderMenuDialog();

    // Make folder
    return input != null ? new FolderComponent(input) : null;
  }
}
