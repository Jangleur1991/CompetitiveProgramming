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



