import montefiore.ulg.ac.be.graphics.*;

public abstract class ComponentFactory {
  protected ExplorerSwingView swingView;
  
  public ComponentFactory(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  public abstract Component assemble();
}
