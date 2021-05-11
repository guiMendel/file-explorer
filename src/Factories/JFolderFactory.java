import montefiore.ulg.ac.be.graphics.*;

public class JFolderFactory extends JComponentFactory {
  public JFolderFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  @Override
  public JComponent assemble() {
    // Get user input
    String input = swingView.folderMenuDialog();

    // Make folder
    return input != null ? new JFolder(input) : null;
  }
}
