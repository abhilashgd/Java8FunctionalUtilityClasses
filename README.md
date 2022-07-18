# Java Basics
                Functional programming with Declarative Approach

                Includes
                --> Combinator Pattern
                --> functional Interfaces : Consumer, Function, Predicate, Supplier
                --> Optional Interface
                --> Streams implementing above

                Reference: https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html 


#1. Why java is not 100% object oriented

        Because of primitive data types namely - boolean, char, int, float, double, long, short
        To make them OO we have wrapper classes which actually wrap the primitive data type into an object of that class

#2. Why pointers are not used in java?

        1) they are unsafe
        2) Increases the complexity of the program and since java is known for its simplicity of code, adding the concept of pointers will be contradicting.
        3) since JVM is responsible for implicit memory allocation, thus in order to avoid direct access to memory by the user, pointers are discouraged in java

#3. What is JIT compiler in java 

        javac.exe converts code to byte codes JRE has interpreter + JIT compiler

        Interpreter goes line by line to convert byte code into machine code. It consumes lot of time so JIT compiler was introduced.


#4. Why string is immutable in Java
        String pool requires string to be immutable otherwise shared reference can be changed from anywhere

        Security because string is shared on different area like file system, networking connection, database connection, having immutable string allows you to be secure and safe because no one can change reference of string once it gets created.


#5. What is marker interface?
        A marker interface can be defined as the interface having no data member and member functions. In simpler terms, an empty interface is called the marker interface

        Ex: Serializable, cloneable


#6. Can you override a private or static method in java?
        Method overriding is a good topic to ask trick questions in java
        1) you cannot override a private or static method in java
        2) you cannot override a private method in sub class because its not accessible there, what you do is create another private method with the same name in the child class.
        3) for static methods, if you create a similar method with same return type and same method arguments in child class then it will hide the superclass method, this is known as method hiding.

#7. Does finally always execute in java?
        Yes except System.exit() function is called or system crash happens


#8. What methods does the object class have?
        Java.lang.object
        Protected Object clone() - creates and returns a copy of this object
        Public boolean equals(Object obj) - indicates whether some other object is equal to this one
        Protected void finalize() throws Throwable - called by garbage collector before doing GC
        Public getClass() - returns the runtime class of an object
        Public hashCode() - returns a hash code value of the object
        Public toString() - returns a string representation of the object

        notify()
        notifyAll()
        wait()
        wait(long timeout)


#9. How can you make a class immutable
        1. Declare the class as final so it can't be extended
        2. Make all fields private so that direct access is not allowed
        3. Don't provide setter methods for variables
        4. Make all mutable fields final so that its value can be assigned only once
        5 Initialise all the fields via a constructor performing a deep copy
        6 perform coning of objects in the getter methods to return a copy rather than returning the actual object reference.


#10. What is singleton class in java and how can we make a class singleton?
        Singleton class is a class whose only one instance can be created, at a given time, in one JVM


        Make constructor private
        Private static instance variable of the class
        Create a static block which will return same class object


#10. Explain collection hierarchy

        Collection Interface - is the root of collection framework and most of the collections in java are inherited from this interface except Map Interface

        List Queue and Set		Map

        List
        - contains the ordered elements
        - May include duplicates
        - supports the index-based search, random access but elements can be easily inserted irrespective of the position


        Set -
        Doesnt define an order for the elements hence index based search is not supported
        Doesnt contain duplicates


        Queue
        - Follows FIFO
        - Elements are added at the rear end and removes from the front end

        Map
        - represents a key value pair
        - Map interface doesnt implement the collection
        - It can contain only a unique key
        - can have duplicate values


        LIST INTERFACE-

        ArrayList 
        - dynamic resizing - 50% of original size
        - Non synchronised

        LinkedList

        - implements List and Deque interfaces
        - maintains insertion order
        - non synchronised
        - does not support accessing elements randomly
        - can use list iterator to iterate linked list elements

        Vector
        - is synchronised
        - maintains insertion order
        - Its thread safe
        - vector increases its size by doubling the array size
        - its legacy class

        Stack
        - last in first out
        - elements are added as well as removed from the rear end

        SET INTERFACE

        HashSet
        - it implicitly implements hasbtable
        -contains only unique elements
        - Only one null element can be added
        - Its unordered as set

        LinkedHashSet
        - ordered version of hashes
        - maintains doubly linked list across all elements
        - preserves insertion order

        SortedSet
        -  must implement comparable interface

        TreeSet

        - uses self balancing tree like Red-Black tree for storage


        QUEUE INTERFACE

        Priority Queue
        - queue with priority associated with each element
        - highest priority element is served before a low priority element irrespective of their insertion order


        DeQue
        - refers to double ended queue
        - elements can be added or removed from both ends

        ArrayDeque
        - it is resizable array implementation of duque


        MAP INTERFACE

        HashMap
        - non synchronised
        - allows one null key but multiple null values


        HashTable
        - synchronised
        Doesnt allow any null key or value

        SortedMap 
          TreeMap

#11. Why Map doesnt extend the collection Interface

        Map interface in java follows a key/value pair structure whereas the collection interface is a collection of objects which are stored in a structured manner with the specified access mechanism

        The main reason map doesnt extend the collection interface is that the add(E e) method of the collection interface doesnt support the key value pair like map interface's put (K,V) method.


#12. Difference between failsafe and fail fast iterators

        Fail-fast iterators throws ConcurrentModificationException when one thread is iterating over collection object and other thread structurally modify collection either by adding or removing or modifying objects on underlying collection
        They are called fail fast because they try to immediately throw exception when they encounter failure

        Fail safe iterator doesn't throw any exception if collection is modified structurally while one thread is iterating over it because they work on clone of collection instead of original collection and thats why they are called fail safe iterator.


#13. What do you understand by blockingQueue ?

        The java BlockingQueue interface, java.util.concurrent.blockingQueue, represents a queue which is thread safe to put elements into and take elements out of from. In other words, multiple threads can be inserting and taking elements concurrently from a java blockingQueue without any concurrency issues arising.

        Its capable of blocking the threads that try to insert or take elements from the queue.
        For instance, if a thread tries to take an element and there are none left in the queue the thread can be blocked until there is an element to take.


#14. What is the difference between synchronised collection and concurrent collection

        Both synchronised and concurrent collection classes provide thread safety
        The differences between them comes in performance, Scalability and how they achieve thread-safety


        Synchronised collections like synchronised hashmap are much slower than their concurrent counterparts ex: concurrentHashmap, main reason for this slowness is locking.


        Whole segment is locked by this thread and other threads have to wait in synchronised collection

        While in concurrent collection only segment 1 is locked for read and write while all other segments are open for other threads its called lock stripping



#15. Internal working of hashmap

          Hashmap in java works on hashing principle where has function are used to link key and value in hashmap, objects (Map.Entry -> contains both key and value object) are stored by calling put(key, value) method of hashmap and retrieved by calling get(key) method.


          When we call put method, Hashcode() method of the key object is called which calculates an index of the bucket location where we can store the value object

          To retrieve, you call the get() method and again pass the key object, which lands u up at same index or bucket and u retrieve the value object.

          If two different keys return same hash index then collision occurs. In that case, a linked list is formed at that bucket location and a new entry is sorted at next node

          Now put method will just append the object nodes in the linked list

          But in case of get if we have a linked list at that index then we need an extra check to search correct value, this is done by equals() method. It checks every key of every node and if equals() returns true then map return that corresponding value from the linked list
          

#16 Is java pasty value or pass by reference

        Java is pass by value

#17. Why are comparable and comparator interfaces required in java

          To sort custom objects

          //COMPARABLE
          Implement comparable

          @override 
          Public int compareTo(E e)
          { return this.id -e.id }

          //COMPARATOR

          Public status Comparator<Employee> NameComparator = new Comparator<Employee>(){

          @Override
          Public int compare(Employee 21, Employee e2) {
          Return e1.getName().compareTo(e2.getname());

          }

          }

          Difference between comparable and comparator
          Comparable
          - no additional arguments are required
          Arrays.sort(empArr);
          - comparable is jn java.lang
          - natural way of ordering
          - compareTO needs to be implemented in DTO so source code is changes

          Comparator
          - we need to send comparator as an argument
          - comparator is in java.util.comparator (additional import required)
          - Arrays.sort( empire, comparator)
          - comparator can have multiple way of ordering
          - DTO source code need not be changes


#18 Equals and Hashcode contract

            e1==e1 shallow comparison
            E1.equals(e2) deep comparison

            //Equal implementation to check if IDs are equal

            Public boolean equals(Object o){
              if(o == null || getClass()!= p.getClass())
                return false;
              if(o ==this)
              return true;
              Employee e = (Employee) o;
              return (this.getId() == e.getId());
            }

            Public int hashCode(){
             Return getId();
            }

            IF two objects are equal according to the equals(Object o ) method then the hash code for both the objects must be the same (integer value)

            Its not necessary that if you have same hash code for 2 object means those two object are equal. This is collision. Better has function prevents this.

            Whenever it is invoked on the same object more than once during an execution of a java application, the hashCode method must consistently return the same integer.

#19 can a Child method have less visibility than parent? NO


#20 Dynamic polymorphism can be reduced by making methods static


#21 Association - relationship between two classes

          Aggregation
           - weak -loose coupling
          Public class Driver {
           Private Car car;
          }


          Composition 
          - strong - tight coupling


#22 Covariant return type. 
          Return type of child class overriden method must have a covariant return type ( like String for Object sub class return types)

#23 Exception handling

            What is an exception?
            Exception is an abnormal condition which occurs during the execution of a program and disrupts normal flow of the program. If not handled properly it can cause program to terminate abruptly

            Exceptions are handled using three blocks
            Try - encloses set of statements which can throw exception hence are required to be monitored
            Catch - when exception occur, this block catches that exception and work accordingly to handle it or to throw it as required
            Finally - this block gets executed always regardless of exception occurrence. Hence clean up is done here

            Hierarchy of exception handling

            Throwable
              - Exception
                - checked exception
                  - IO exception
                  - SQL Exception
                  - ClassNot found Exception
                - Unchecked/ Runtime Exception
                  - null pointer exception
                  - number format exception
                  - index out of bounds exception
                    - Array Index out of bounds exception
                    - StringIndex out of bound exception


              - error
                - Out of memory error
                - Virtual Machine error


            Difference between 

            Exception
            - we can recover from exception using try catch block or using throw
            - compiler will have knowledge about checked exceptions here compiler will force you to use try catch blocks
            - exceptions are related to application
            - exceptions include both checked as well as unchecked type
            Exceptions in java are of type java.lang.exception

            Error
            - recovering from error is not possible
            - compiler will not have any knowledge about unchecked exception and error
            - errors are related to environment where application is running
            - all errors in java are unchecked type
            Errors in java are java.lang.error


            Can we write only try block without catch and finally blocks?
            No. Either catch or finally is must
            If no then what error will come?
            Compile time error saying insert finally to complete try statement

            Can we write any other statements between try catch or finally block?
            No. Try must be follower directly by either catch or finally


            Does remaining statements in try block execute after exception occurs?
            No.


            Difference between throw and throws

            Throw 
            - Java throw keyword is used to explicitly throw an exception
            - Checked exception cannot be propagated using throw only
            - throw is used within the method
            - you cannot throw multiple exceptions


            Throws 
            - java throws keyword is used to declare an exception
            - checked exception can be propagated with throws
            - throws is used with the method signature 
            - you can declare multiple exception

            What happens when an exception is thrown by main method?

            When an exception is thrown by main method, Java Runtime terminates the program and prints the exception message and the stack trace in-system console

            Java Runtime Environment handles the exception

            What do you mean by unreachable catch block?

            This error comes when you keep super classes first and sub classes later. Like here we kept exception which is parent of null pointer exception first
            Hence the order of catch blocks must be from most specific to most general
            
#24 What is the difference between final, finally and finalise in java?

            Final - is a keyword used to apply restrictions on class, method and variable. Final class can't be inherited. Final method can't be overridden and final variable can't be changed

            Finally - this keyword is used with the try-catch block to provide statements that will always get executed even if some exception arises. Usually, finally is used to close resources.

            Finalize: is used to perform clean up processing just before the object is garbage collected.

#Java 8 Features


























 

