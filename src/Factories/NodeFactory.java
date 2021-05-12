import montefiore.ulg.ac.be.graphics.*;

public abstract class NodeFactory {
  protected ExplorerSwingView swingView;
  
  public NodeFactory(ExplorerSwingView swingView) {
    this.swingView = swingView;
  }

  public abstract Node assemble(FolderNode parentFolder) throws InvalidNodeNameException;
}
