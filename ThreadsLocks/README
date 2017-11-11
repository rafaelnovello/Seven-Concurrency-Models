# Author's Note

These examples are all written in Java and compiled with Maven:

    http://maven.apache.org/download.cgi

To build and run, change into the directory of the project and:

    mvn compile
    mvn exec:java

# How to check/confirm a Deadlock?

1 - Get the java main process PID. You could do that with top or htop

2 - Run jstack with that PID like this:

```$ jstack -l 12767```

3 - Check the output like this:

```
Found one Java-level deadlock:
=============================
"Thread-2":
  waiting to lock monitor 0x00007f39a40062c8 (object 0x0000000770713d08, a java.lang.Object),
  which is held by "Thread-1"
"Thread-1":
  waiting to lock monitor 0x00007f39a40053a8 (object 0x0000000770713d18, a java.lang.Object),
  which is held by "Thread-2"

Java stack information for the threads listed above:
===================================================
"Thread-2":
	at com.paulbutcher.Uninterruptible$2.run(Uninterruptible.java:33)
	- waiting to lock <0x0000000770713d08> (a java.lang.Object)
	- locked <0x0000000770713d18> (a java.lang.Object)
"Thread-1":
	at com.paulbutcher.Uninterruptible$1.run(Uninterruptible.java:22)
	- waiting to lock <0x0000000770713d18> (a java.lang.Object)
	- locked <0x0000000770713d08> (a java.lang.Object)

Found 1 deadlock.
```
You got a deadlock!
