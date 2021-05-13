public interface ComponentInterface extends Prototype<ComponentInterface> {
  String getName();

  @Override
  String toString();

  @Override
  boolean equals(Object other);
}
