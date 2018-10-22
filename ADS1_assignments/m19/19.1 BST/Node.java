/**
 * Class for node.
 *
 * @param      <Value>  The value
 */
class Node<Value> {
	/**
	 * Book Object.
	 */
	private Book book;
	/**
	 * Value Type val.
	 */
	private Value val;
	Node left;
	Node right;
	int size;
	Node (final Book bookobj, final int count) {
		book = bookobj;
		left = null;
		right = null;
		size = count;
	}
	/**
	 * Sets the value.
	 *
	 * @param      val1  The value 1
	 */
	public void setValue(final Value val1) {
		val = val1;
	}
	/**
	 * Gets the value.
	 *
	 * @return     The value.
	 */
	public Value getValue() {
		return val;
	}
	/**
	 * Gets the book.
	 *
	 * @return     The book.
	 */
	public Book getBook() {
		return book;
	}
}
