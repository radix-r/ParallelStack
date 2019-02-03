# Made using java 11
Compile: javac 


Implementation of a lock free stack using exponential back off
Influenced by The example in the book in chapter 11

The linearization point of the push operation  is when compareAndSet is called in try push.
The push takes effect when compareAndSet is called. The push operation can be placed in a
serial history according to when compareAndSet returns true.

The linearization point of the pop operation is when the compareAndSet instruction is called.
The pop takes effect when compareAndSet is called. The pop operation can be placed in a
serial history according to when compareAndSet returns true meaning that the old head has been replaced
with new head.

The lack of locks in this implementation guarantees that at least one method call finishes in a finite number
of steps. I use exponential backoff instead a queuing structure so fairness is not guaranted.

