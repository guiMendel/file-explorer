import montefiore.ulg.ac.be.graphics.*;

public abstract class JComponentFactory {
  protected ExplorerSwingView swingView;
  
  public JComponentFactory(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  public abstract JComponent assemble();
}
