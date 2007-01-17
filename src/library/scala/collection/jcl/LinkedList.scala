package scala.collection.jcl;

/** Creates a buffer backed by a Java linked list. Includes additional peek/poll/removeFirst/removeLast APIs
  * that are useful in implementing queues and stacks.
  * @author Sean McDirmid
  */
class LinkedList[A](override val underlying : java.util.LinkedList) extends ConcreteWrapper[A] with BufferWrapper[A]  {
  def this() = this(new java.util.LinkedList);
  override def elements = super[BufferWrapper].elements;
  override def add(idx : Int, a : A) =
    if (idx == 0) underlying.addFirst(a);
    else super.add(idx, a);
  def peek = underlying.peek.asInstanceOf[A];
  def poll = underlying.poll.asInstanceOf[A];
  def removeFirst = underlying.removeFirst.asInstanceOf[A];
  def removeLast  = underlying.removeLast.asInstanceOf[A];
}
