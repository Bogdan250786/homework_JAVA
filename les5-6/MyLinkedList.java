package com.paramud.homeworkLinkedList;

public class MyLinkedList<E> {
  private Node<E> first;
  private Node<E> last;
  int size;

  public void add(E value) {
    if (value == null) return;
    Node<E> newNode = new Node<E>(value);
    if (first == null) {
      first = newNode;
      last = newNode;
      size++;
    } else {
      last.next = newNode;
      last = newNode;
      size++;
    }
  }

  public void add(int index, E value) throws MyIndexException {
    if (index < 0 || index > size) throw new MyIndexException("Index " + index + " is out of bounds", index);
    if (value == null) return;
    Node<E> current = first;
    Node<E> newNode = new Node<E>(value);
    if (first == null) {
      first = newNode;
      last = newNode;
      size++;
    } else {
      for (int i = 1; i < index; i++) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
      size++;
    }
  }

  public boolean contains(E value) {
    if (value == null || first == null) return false;
    Node<E> current = first;
    if (first.value == value) return true;
    while (current.next != null) {
      current = current.next;
      if (current.value == value) return true;
    }
    return false;
  }

  public E get(int index) throws MyIndexException {
    if (index < 0 || index >= size) throw new MyIndexException("Index " + index + " is out of bounds", index);
    Node<E> current = first;
    for (int i = 1; i <= index; i++) {
      current = current.next;
    }
    return current.value;
  }
  public Node<E> getNode(int index) throws MyIndexException {
    if (index < 0 || index >= size) throw new MyIndexException("Index " + index + " is out of bounds", index);
    Node<E> current = first;
    for (int i = 1; i <= index; i++) {
      current = current.next;
    }
    return current;
  }

  public E remove(int index) throws MyIndexException {
    if (index < 0 || index >= size) throw new MyIndexException("Index " + index + " is out of bounds", index);
    Node<E> newNode = null;
    if (index == 0) {
      newNode = first;
      first = newNode.next;
      size--;
      return newNode.value;
    }
    if (index == size - 1) {
      newNode = last;
      Node<E> prevnewNode = getNode(size-2);
      prevnewNode.next = null;
      size--;
      return newNode.value;
    }
    Node<E> current = first.next;
    Node<E> previous = first;
    for (int i = 0; i < index - 1; i++) {
      current = current.next;
      previous = previous.next;
    }
    previous.next = current.next;
    size--;
    return current.value;
  }

  public boolean remove(E value) {
    if (size < 1) return false;
    if (first.value == value) {
      first = first.next;
      size--;
      return true;
    }
    Node<E> current = first.next;
    Node<E> previous = first;
    while (current != null) {
      if (current.value == value) {
        previous.next = current.next;
        size--;
        return true;
      } else {
        previous = current;
        current = current.next;
      }
    }
    return false;
  }

  public int size() {
    return size;
  }

  @Override
  public String toString() {
    Node<E> current = first;
    String result = "" + first;
    while (current.next != null) {
      current = current.next;
      result += ", " + current;
    }
    return result;
  }
}

