public interface ComponentInterface {
  String getName();

  void setName(String name);

  @Override
  String toString();

  @Override
  boolean equals(Object other);
}
