# Vector
# Construct vectors and perform vector computations in the Java programming language #

# Commands
Once the program has started, you are prompted to enter the following commands:
• bye – Terminates the program.
• help – Displays the syntax of each command.
• set – Creates a new vector with the given key.
• show – Displays the vector with the given key.
• compute – Displays the result of a computation.

# set command
The set command has the following syntax: set <key> = <operation> <args...>
• key – A string with no spaces that will be used to identify the vector.
• operation – The operation used to generate the vector.
• args – One or more optional arguments that can be passed to the operation.
  
# Valid operations are:
• random <seed>
Generates a new vector where each element is a random integer between 0 and 100 inclusive
using the seed value. Generated using the java.util.Random random number generator.
• uniform <value>
Generates a new vector where each element is set to the given value.
• sequence <start> <step>
Generates a new vector where each element is a value of a sequence of integers starting at
start and every next value is incremented by step which can be both positive and negative.
For example, a sequence starting at 2 that has a step 2 would be:
2 4 6 8 10 12 ...
• pq <start>
Generates a new vector that consists of a sequence of pq numbers. First number in the vector
should be start when pq or the next pq number that comes after.
• prime <start>
Generates a new vector that consists of a sequence of prime numbers. First number in the vector
should be start when prime or the next prime number that comes after.
• abundant <start>
Generates a new vector that consists of a sequence of abundant numbers. First number in the
vector should be start when abundant or the next abundant number that comes after.
• composite <start>
Generates a new vector that consists of a sequence of composite numbers. First number in the
vector should be start when composite or the next composite number that comes after.
  • cloned <key>
Generates a new vector with the same elements of the given vector.
• sorted <key>
Generates a new vector with elements of the given vector in ascending order.
• shifted <key> <amount>
Generates a new vector with elements of the given vector shifted right n places.
• reversed <key>
Generates a new vector with elements of the given vector in reverse order.
• scalar#add <key> <value>
Generates a new vector that is the result of adding the scalar to each element in the vector.
• scalar#mul <key> <value>
Generates a new vector that is the result of multiplying the scalar to each element in the vector.
• vector#add <key1> <key2>
Generates a new vector that is the result of adding the respective elements of both vectors.
• vector#mul <key1> <key2>
Generates a new vector that is the result of multiplying the respective elements of both vectors.
  
The show command has the following syntax: show <key> <index>
• key – The key of the vector to display.
• index – Optional index. When specified, display the element at this index.
  
# compute command
The compute command has the following syntax: compute <operation> <key> <arg>
• operation – The operation to perform on the vector.
• key – The key of the vector to perform the given operation on.
• arg – An optional argument that may be required for the given operation.

# Valid operations are:
• sum <key>
Display the sum of all vector elements.
• mode <key>
Display the most occurring value in the vector, or -1 if the most ocurring number is not unique.
• median <key>
Display the upper median which is the value that lies in the middle of the vector when sorted.
When there are an even number of elements in the vector, then display the upper median.
• minimum <key>
Display the minimum value in the vector.
• maximum <key>
Display the maximum value in the vector.
• frequency <key> <value>
Display the number of occurrences of the value in the vector.
