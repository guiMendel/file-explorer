abstract public class Component implements ComponentInterface, PrototypeInterface {
  // Name of the component
  protected String name;

  public Component(String name) {
    super();
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }

  // Allow comparing two different components
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof Component))
      return false;

    Component castOther = (Component) other;

    return getName().equals(castOther.getName()) && getClass().equals(castOther.getClass());
  }

  // Prototype implementation
  abstract public Component copy();
}
