public interface Prototype<ReturnType> {
  // Returns a deep copy of the object
  ReturnType copy() throws Exception;
}
