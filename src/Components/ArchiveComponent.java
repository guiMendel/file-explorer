public class ArchiveComponent extends Component {
  private int compressionLevel;
  
  ArchiveComponent(String name, int compressionLevel) {
    super(name);
    this.compressionLevel = compressionLevel;
  }

  @Override
  public Component copy() {
    return new ArchiveComponent(name + " (copy)", compressionLevel);
  }
}
