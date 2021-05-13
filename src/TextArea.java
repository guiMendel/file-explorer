import montefiore.ulg.ac.be.graphics.*;

// Handles the text area UI component
public class TextArea implements Observer<Node> {
  TextAreaManager textArea;
  
  public TextArea(ExplorerSwingView swingView) {
    this.textArea = swingView.getTextAreaManager();
  }
  
  // Observer implementation
  @Override
  public void update(Node node) {
    // Get selected node's component
    Component component = node.getComponent();

    // If it's a file, we show it's content
    if (component instanceof FileComponent) {
      displayFile((FileComponent) component);
    }
  }

  private void displayFile(FileComponent file) {
    // Update text area
    textArea.clearAllText();
    textArea.appendText(file.getText());
  }
}
