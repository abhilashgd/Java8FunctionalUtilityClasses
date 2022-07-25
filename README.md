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

#25 Dynamic polymorphism?

            Possible only with methods 
            Not Possible with instance variables

            Parent reference = new childObject();            
            
            
 #26 Catagories of Design patterns

          - Creational patterns 
          - Behavioural patterns
          - structural patterns
          - J2EE patterns

          Why do we need design pattern?

          As design patterns are well documented and understood by software architects, designers and developers, then their application within a specific solution will likewise be well understood

          Patterns give a software developer an array of tried and tested solutions to common problems, thus reducing the technical risk to the project by not having to employ a new and untested design, thus saving time and effort during the implementation stage of the software development life cycle

          They are language neutral and so can be applied to any language that supports object orientation

          By using well understood and documented solutions, the final product will have a much higher degree of comprehension. If the solution is easier to comprehend, then by extension, it will also be easier to maintain

#27 What is factory pattern?

           In factory pattern, we dont expose creation logic to the client and refer the created object using a standard interface
           It is also known as virtual constructor
            
            Steps: 
            1. Create main class which calls factory class
            2. factory class returns required class interface 
           
            Factory pattern

            //INTERFACE SUPPORTING FACTORY
            Interface Profession

            //IMPLEMENTING CLASSES	
            Class Doctor implements Profession {}
            Class Engineer implements Profession {}
            Class Teacher implements Profession {}

            //FACTORY CLASS 
            Class ProfessionFactory{

            Public profession getProfession( Staying typeOfProfession){
            if(typeOfProfession = "doctor") return new Doctor();
            else if(typeOfProfession = "Engineer") return new engineer();
            else if(typeOfProfession = "Teacher") return new Teacher();

            }

            }
            //MAIN CLASS
            FactoryPastternMainClass {
            psvm(string[] args){
            ProfessionFactory professionFactory = new ProfessionFactory();
            Profession doc = professionFactory.getProfession("Doctor");
            doc.print();
            }

            }
            

#Java 8 Features

#1 Why Java 8 ? Main agenda behind java 8

        Significant reason for introducing java 8 was to introduce conciseness in the code.

        Java brings in functional programming in which is enabled b lambda expressions ( a powerful tool to create concise code base)

        If you have ever observed, with python, Scala, we can do the same thing in every less loc. by mid 20s java lost a large market due to these languages. To prevent further loss, java upgraded itself from only OOPs language to some concepts of FP to create concise code base

#2 What are new features which got introduced in java 8

        - Lambda expression
        - Stream API
        - Default methods in the interface
        - Static methods
        - Functional interface
        - Optional
        - Method references
        - Date API
        - Nashorn, JavaScript Engine


#3 Main advantages of using java 8

        - compact code ( Less boiler plate code)
        - more readable and reusable code
        - more testable code
        - parallel operations

#4 what is lambda expression

        Lambda expression is an anonymous function ( without name, return type and access modifier and having one lambda (-> symbol)


        Normal programming
        Public void add(int a, int b){
        System.out.println(a+b);
        }


        Equivalent lambda expression
        (A,b) -> system.out.prntln(a+b);

        BiConsumer<Integer,Integer> biConsumer = (a,b) -> System.out.println(a+b);
        Biconsumer.accept(10,5);



#5 what are functional interfaces?

          - Functional interfaces are those interfaces which can have only one abstract method
          - it can have any number of static methods, default methods. No restrictions on that
          - There are many functional interfaces already present in java such as ex: comparable, runnable

          -Functional interface is used to provide reference to lambda expressions 
          Example : Comparator<String> c = (s1,s2) -> s1.compareTo(s2);
               Functional interface = Lambda expression

          To create our own functional interface
          - create an interface
          - annotate that with @FunctionalInterface
          - Define exactly one abstract method
          - there is no restrictions on number of static and default methods defined in such an interface

          NOTE: java can implicitly identify functional interface but still you can also annotate it with @FucntionalInterface. If in case we add two abstract methods then compiler will throw an error.

#6 what is method referencing in java 8?

          Method reference is replacement of lambda expressions. It is used to refer method of functional interface to an existing method. Mainly it is used for code reusability

          Functional Interfaces abstract method can be mapped to specify existing method using double colon operator (::) this is method reference.

          Hence method reference is an alternative to lambda expressions

          Whenever we have existing implementation of abstract method of our functional interface then we can go for method reference. If no such method like testImplementation() is available then go for lambda expressions



            @FunctionalInterface
            Public interface FunctionalInterfaceDemo {

            Void singleAbstractMethod();

            default void printName()
            sout("print name method")

            default void printName2()
            sout(print name 2);

            }

            Public class MethodReferenceDemo{

            psvm(String args) {
            FunctionalInterfaceDemo fDemo = () -> sout("print something");
            fDemo.singleAbstractMethod();

            Or

            FunctionalInterfaceDemo fDemo = Test::testImplementation;
            fDemo.singleAbstractMethod();

            }
            }

            class Test {

            Public static void testImplementation(){

            sout("This is test implementation");
            }

            }

#7 what are default methods in java 8?

          Default method is a way for adding new methods to the interface without affecting the implementing classes. Hence with this new feature java people defended many compile time errors that may arise due to unimplemented methods of interface

          EX: interface Animal {
          Void legs();
          //default void eyes(){
          sout(two eyes");
          }
          }

          The use of these default methods is "backward compatibility" which means if JDK modifies any Interface (without default method) then the classes which implement this interface will break.


#8 is it necessary to override default methods?

          - Default methods have dummy implementations
          - Implementing classes if ok with dummy implementation then use dummy imply of default methods
          - if not satisfied then they can override and provide their own implementation

#9 is default keyword one of the access modifier?

          - Default is not the access modifier like public or protected or private
          - hence default keyword was only used in classes till 1.8 version for switch case only but never in interface
          - now its used for default methods in interface to provide a default implementation for all implementing classes

#10 how to override default methods?

          - You can override default method by keeping same method (name + arguments)
          - removing default keywords because in class default keyword is used in switch case to denote default case if no previous cases matched. So you can't use default keyword in class
          - adding public as access modifier because in java8, by default all methods are public so in child u can't reduce visibility of override default method
          -giving our own implementation

#11 can you use hashcode() default implementation in interface?
          - You cannot give your default implementation of Dashcode() in interface for all implementing classes to use.
          - we are not allowed to override Object class's method as default methods in interface else will get compile time error

          All implementing classes by default has access to all methods of object class.

#12 Diamond problem with default methods in interface

          - diamond problem of default methods of interface: if 2 implemented interfaces contain same default methods then thats the diamond problem
          - in java, in such situation, the code will not compile.
          Solution to diamond problem - use InterfaceName.super.methodName();

          #13 why static methods were introduced in java 8

          Public interface InterfaceWithStaticDemo {

          Static void staticMeth(){

          sout("this is static method");
          }

          }

          - only reason for introducing static method in interface is that you can call those methods with just interface name. No need to create class and then its object.

          Since interface can never contain:
          Constructors,
          Static blocks
          Nothings costly in terms of memory and performance.

          Hence we don't need to create object and hence if you have everything static then for interface rather than class


          Note: we have this flexibility only after java 8, before that we needed to create class

#13 are static methods available to implementing classes by default?

        - static methods are not available to implementing classes.
        - they are not default methods. They are static.
        - hence, you can call these methods using interface name explicitly from the implementing classes as implementing classes wont have access to these methods directly.
        - This is the disadvantage of static methods of interface that its not available to implementing classes.


#14 what are predicates?
        - Predicates is a predefined functional interface (having only one abstract method)
         - The only abstract method of predicate is test(T t);
         - whenever we want to check some boolean condition then we go for predicates.


          Predicate<String> checklength = s->s.length() >=5;
          sout("The length of string is greater than 5: " + checkLength.test("Code decode"));


          Type parameter and return types of predicates?
          Input to predicate can be anything like
          - predicate<String>
          - Predicate<Integer>
          - Predicate<Employee>

          Hence only 1 type argument is required which is input type in predicate.

          Return type is not required as its always boolean only.

          Advantages of predicates?
          - Code reusability
          - if you have same conditions being used 100 times in a program then you can write once and just use 100 times with checkLength(different string to be tested)
          - Conditional checks are folded by functional interfaces

          What is predicate joining
          - you can combine predicates in serial predicate
          - three ways to join
            - and
            - or
            - negate (Only one single predicate
          Eg: if you want to test 2 conditions
            - to check length of string > 5
            - to check if length is even
            - define two predicates and use .and or .or or.negate etc

#15 what are functions

            - Functions are nothing but functional interface with just one abstract method

            - Given some input, perform some operation on input and then produce/ return result ( not necessary a boolean value)

            - this takes 1 input and returns one output
            - in predicate we used to take one input and return type is always boolean
            - in function return type is not fixed hence we declare both input and return type

            Function <InputType, OutputType> parameter = lambda expression;
            Function<Integer, Integer> squareOf = i -> i*i;
            Integer result = squareOf.apply(10);
            sout("" _ squareOf.apply(10)
#16 what is the difference between predicate and function ?

            Predicate
            - it has the return type as boolean. Its used for conditional checks
            - It is written in the form of predicate<T> which accepts single argument
            - it contains test() method

            Function
            - It has the return type as Object. Its used to perform operations and return result
            - it is written in the form of Function< T, R> which also accepts a single argument but return any type of object denoted by R
            - it contains apply() method


#17 Function chaining

            Function<Integer, Integer> doubleIt = i -> 2*1;
            System.out.println( "Double Function + doubleIt.apply(2));

            Function«Integer, Integer> cubeIt = i -› i*j*i:
            System.out.println("Cube Function" + cubeIt.anplyk2));
            //AND THEN - first double it and then cube
            System.out.println("First Doubling using apply + doubleIt.andThen(cubeIt).apply(2));
            //COMPOSE - first cure it and then double it
            System.out.println("First Cubing using compose + doubleIt.compose(cubeIt).apply(2));

            Multiple functions can be similarly chained

            F1.andthen(f2).andTHen(f3).andThen(f4).apply(Inputs);

#18 what is consumer functional interface?

            Predicate<T> takes 1 input and returns boolean.
            Function<T,R> takes 1 input and 1 return type produced after performing some operation on that input

            Consumer<T> -> It will consume Item. Consumers never return anything (never supply). They just consume.

            Ex: take any object and save its details in database and don't return anything

            Interface Consumer<T>{
            Public void accept(T t)
            }

#19 what is consumer chaining?

            We can combine. Chain multiple consumers together with andThen
            There is only one way to combine consumers
            C1.andThen(c2).apply(Input) - first c1 then c2

            No compose() in consumer
            Multiple consumers can be chained together

            C1.andThen(c2).andThen(c3).andThen(c4).apply(input);


            //CODE EXAMPLE

            package predicate_demo;
            import java.util.function.Consumer;
            public class ConsumerDemo{
            public static void main(String[] args) f

            //normal programming
            //ConsumerDemo consumerDemo = new ConsumerDemo0) ;
            //onsumerDemo.squreInt(5);

            Consumer«Integer> squareMe = i -› System.out.println("Taking an input and performing operation" + i*i);
            Consumer«Integer> doubleMe = i -› System.out.println("Taking an input and performing operation" + 2*i);
            squareMe.accept(5);
            squareMe.andThen(doubleMe).accept(5);
            }
            //normal programming
            public void squreInt (int i) f
            int squred = i*i;
            System.out.println("Squared number is
            1
            T
            "+ squred);
            1

#20 what is supplier function


            Supplier<R> -> it will just supply required objects and will not take any input.
            It always going to supply never consume/ take any input

            EG: always supply me current date

            Interface Supplier<R>{
            Public R get();

            }

            No chaining as no input is given to this. Only gives output.

            EXAMPLE: 
            Supplier<Date> currentDate = () -> new Date();
            Sout("currentDate.get());


#21 use of BiConsumer BiFunction, BiPredicate and why no BiSupplier?


            Predicate<T> -> test() -> return boolean
            Function<T,R> -> apply() -> return anything
            Consumer<T> -> accept() -> return nothing
            Supplier<R> -> get() -> returns anything accepts nothing

            What if we need 2 arguments for operation?

            Then we need Bi XYZ functional Interfaces

            There is no input in supplier so no 1 or 2 input arguments needed. Hence no Bi Supplier


            Example:

            public class BiPredicateBiFunctionDemo{
            public static void main(String[] args) {
            BiPredicate<Integer, Integer> checkSumOfTwo
            = (a, b) -> a+b ›= 5;

            System.out.println("sum of 2 and 5 is greater than 5: " + checkSumofTwo.test(2,5);

            System.out.println("sum of 2 and 1 is greater than 5
             : " + checkSumOfTwo.test(2,1));

            Bifunction<Integer, Integer, Integer> multiplyBoth = (a,b) -> a*b;
            System.out.println("Multiplication of 5 and 10 is " + multiplyBoth.apply(5, 10));
            }


#22 If we want to operate on 3 arguments then triPredicate?

            There are no TriPredicate or TriFucntion etc
            No QuadPredicate No QuadFucntion

            Java 8 has inbuilt Functional Interfaces that can take only 1 or 2 arguments no more.

#23  what are streams?

            If we want to process bulk objects of collection then go for streams concept
            Way to operate on collection in java 8 is stream
            Its a special iterator class that allows processing collections of objects in a functional manner
            EX: fetch all objects from collection of list whose values is greater than 10


#24 what is the difference between streams (java 1.8) and java.io.stream ?

            Java io streams is a sequence of characters or binary data which is used to be written to a file or to read data from a file

            While streams java 1.8 is no where related to files, its related to collection object.

            Java io streams related to file whereas java 8 streams are related to collection object.

            Hence if we need to perform some operations on collection there we should go for streams.


#25 Difference between streams and collection?

            To represent group of collection as single entity then we should use collection concept.
            If we want to perform operation on bulk objects in collection then we should go for streams


#26 steps to create and process stream

          We can get stream object by :
          - Stream s = colectionObject.stream();
          - Once we get stream object we can process the object of collection
          - processing of stream consists of 2 steps/stages
            - configuration of stream
            - processing that configuration
          - Configuration can be done by 
            - map
            - filter
          Example:

          List‹Integer› arList =new ArrayList<Integer>();
          arList.add(15);
          arList.add(25);
          arList.add(5);
          Stream s = arList. stream() ;

           arList.stream().filter(i -› 1%2 == 0). forEach(x-> System.out.println(x));


#27 how to map the stream objects?

            What if we don't want to filter out
            We rather want to create new object against each existing stream object based on some function
            EX: create new object by squaring its value

            Stream s = arList.stream().map(i->i*i);
              s.forEach(x-> System.out.println(x));
              
            Stream s = arList.stream().map(i->i*i);
              s.forEach(x-> System.out.println(x));

#28 Difference between filter and map

            If we want to fetch/filter objects from collection like filter only even numbers from arrayList collection then use filter for configuration of stream

            If we want to perform some operation on each objects of the collection then create another mapped object with different value (after operation is performed) for each object of that collection, then use map

            In filter, because of filtering, number of objects filtered list is less than original list while in map same number of objects are there in both new and original list created

#29 processing of stream
          - collect
          - count
          - sorted
          - min max
          - for each
          - to array
          - of()

#30 JAVA 8 Interface changes

          - static method
          - default method

          Why do we need these?
          Even if we wanna change or add any new method in interface then it requires change in all implementing classes
          To create a default method in java interface, we need to use default keyword with the method signature

          Interface methods are by default public and abstract

          Default methods are no more abstract

          Ex: default void my AbstractMethod(){}
#31 Static methods in interfaces

          - These are similar to default methods, just that its static hence its implementation cannot be changed in child classes

          Thus implementing class need not and cannot change the definition

          Static methods of an interface can't be overridden

          Should always be called with interface name
          Interface.StaticMethodName

          Why do we need static methods?

          Interface static method helps us in providing security by not allowing implementation classes to override them.

          Interface static methods are good for providing utility methods, for example null checking whose definition will never change.

#32 how to solve diamond problem of default methods in interface ?

            Interface.super.defaultMethod()
#33 Java Interface Default method.

            Why do we need default methods?

            If there are many classes implementing an interface, adding a method in ht interface will require changes in all classes. So default methods help us to avoid the changes by giving a default implementation in the interface

            Diamond problem in default method

            Consider the scenario where 2 or more interfaces have same default methods implemented in respective interfaces. Then child classes implementing both interfaces will be confused which default implementation to accept



















































































 

