#  LeetCode challenges

## Datastructures

### Arrays

#### Time complexity:

Insert at the end: O(1)  
Access: O(1)  
Search: O(n)  
Remove: O(n)  

### LinkedList

#### Time complexity:

Insert: O(1)  
Access: O(n)  
Search: O(n)  
Remove: O(1)  

What are they used for in the real world?

- Next Page in Web Browser 
- Next image in a phone gallery.

Links:  
<a href="https://visualgo.net/en/list" alt="Visualisation LinkedList">Visualisation LinkedList</a>

### Stack

#### Time complexity:
Push: O(1)  
Pop: O(1)  
Top: O(1)  
Access (other): O(n)  

A stack follows the rule of LIFO (Last In First Out)
The last element added in the stack is the first element you remove from it.
Therefore, a stack is useful when you need the reverse
Order of given elements. A very popular example is
<em>Valid Parentheses Problem</em>.

What are they used for in the real world?
- Call history/log in mobile phones
- JVM
- Recursive function calls

Links:  
- <a href="https://csacademy.com/lesson/stack_introduction/" alt="What is a stack?">What is a stack?</a>
- <a href="https://csacademy.com/lesson/stack_application_soldiers_row/" alt="Stack Application: Soldiers Row">Stack Application: Soldiers Row</a>

## Space Complexity

Since the term <em>space complexity</em> is often misunderstood, I am trying to understand what it
actually means.

In many cases, the term <em>space complexity</em> refers to the <em>auxiliary space</em> required by an algorithm.

In fact, however, the <em>space complexity</em> of an algorithm
is the total space taken by the algorithm with respect
to the input size. This includes the <em>auxiliary space</em>
AND the space taken by the input.

Merge sort, Insertion sort and Heap sort 
all have a <em>space complexity</em> of O(n).
But Merge sort has an <em>auxiliary space</em>
of O(n),  while the others have only
O(1). In many cases, the <em>auxiliary space</em>
is a much better criterion than <em>space complexity</em>.


The creation of an array of length <em>n</em> requires
O(n) space. But also the recursive call stack space
counts! This means how many stack calls are on the stack at the same time!

Ex:

```
private static int add(int n) {      
    return (n == 0 || n == 1)  
            ? n  
             : n + add (n-1);
}

add(4);
```
If we use the debugger we can see, 
that the method uses up to four
stack calls at the same time:

![img.png](img.png)

Therefore, the auxiliary space here is
O(n). 

It is important to mention that the <em>n</em> calls
exist simultaneously on the call stack!

There are functions/methods that use recursion where
the input size is <em>n</em>, but there is at most
one call on the call stack. Therefore the
auxiliary space is only O(1)!


## Techniques

#### Storage of two values in one variable:

Let's say we want to store two values <em>a</em>
and <em>b</em> in one variable <em>c</em>.

- Why would we want to do that?

Sometimes we want to reduce the space complexity. 
Suppose we have an array of length <em>n</em> and we want to manipulate the entries. 
One possibility would be to change the entries directly, but this is not always possible. 
Sometimes the new manipulated value depends on other old (not yet manipulated) values in the array. 
An example of this is the BuildArrayFromPermutation task:

<em>Given a zero-based permutation nums (0-indexed), build an array ans of the same
length where ans[i] = nums[nums[i]] for each 0 <= i < nums.length and return it.  

A zero-based permutation nums is an array of distinct integers from 0 to nums.length - 1 (inclusive).</em>

Here it is not so easy to manipulate the input array nums directly.  

Ex:   
<em>Let nums = [2,0,1]. 

Then:    
1.Step: nums[0] = nums[nums[0]] = nums[2] = 1  
2.Step: nums[1] = nums[nums[1]] = nums[0] = 1
...

So instead we could use a second array ans
of length n with ans[i] = nums[nums[i]],
which results in an auxillary space complexity
of O(n). But that's not what we want!
</em>

- How to do that?  

We can simply use modulo! So we define <em>c = a+n*b</em>
where <em>a, b < n</em>. With that we get <em> a == c%n</em>
and <em>b == c/n</em> where we assume
<em>a/n == 0</em> (which is true for integer calculations).  

This is one way to solve th BuildArrayFromPermutation task
with an auxillary space complexity of O(1).

#### Two Pointers:

- When to use it?

You are trying to solve an array-related problem where the goal is to find two numbers
that satisfy a certain condition.

- What is the general idea?

The idea is to iterate two different parts of an array simultaneously
to get an answer faster.

- How does the implementation look like?

There are at least two ways of implementing the two-pointer technique:

1. One pointer at each end: One pointer starts from the beginning
and another one fom the end. They proceed towards each other.

    Ex: existsPairWithGivenSumForSortedArray, reverseArray


2. Both pointers start at the same position, but with move with different speed:
 
    Ex: MiddleOfLinkedList