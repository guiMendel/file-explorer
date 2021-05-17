public interface Observer<MessageType> {
  void update(MessageType message);
}
