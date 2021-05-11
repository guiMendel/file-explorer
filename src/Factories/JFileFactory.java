import montefiore.ulg.ac.be.graphics.*;

public class JFileFactory extends JComponentFactory {
  public JFileFactory(ExplorerSwingView swingView) {
    super(swingView);
  }

  @Override
  public JComponent assemble() {
    // Get user input
    String[] input = swingView.fileMenuDialog();

    // Make file
    return input != null ? new JFile(input[0], input[1]) : null;
  }
}
