This directory contains the java source files for a data structure representing Lists. A list is a data structure for holding an arbitrary sequence of items. Linked lists and array lists are two common ways to implement lists.

You should implement an array list with class name ArrayList
You should implement a singlely linked list with name SingleLinkList
You should implement a doublely linked list with name DoubleLinkList

Files:
IList.java  - An interface for lists based on the list operations from the 11/29 lecture
ISLink.java - An interface that your link cells for SingleLinkList must implement
IDLink.java - An interface that your link cells for DoubleLinkList must implement
Test.java   - A fairly good but incomplete test suite (e.g. insert is not tested well)
TestFailedException.java - An exception thrown when a test failure is detected

ArrayList.java - class that implements IList
DoubleLinkList.java - Double linked list that implements IList
DoubleLinkCell.java - class that implements the IDLink interface that represetns the list nodes
SingleLinkList.java - Sinlge linked list that implements IList
SingleLinkCell.java - class that implements the ISLink interface that represents the list nodes
