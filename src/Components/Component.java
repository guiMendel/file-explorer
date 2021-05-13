abstract public class Component implements ComponentInterface, Prototype<Component> {
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
  public String toString() {
    return getName();
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
  @Override
  abstract public Component copy();
}
