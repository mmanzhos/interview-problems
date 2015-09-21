/*
http://www.careercup.com//question?id=5758790009880576
<p>Given a string which only contains lowercase. You need delete the repeated letters only leave one, 
and try to make the lexicographical order of new string  is smallest.
<br>i.e:
<br>bcabc
<br>You need delete 1 'b' and 1 'c', so you delete the first 'b' and first 'c', the new string will be abc which is smallest.
<br>
<br>ps: If you try to use greedy algorithm to solve this problem, you must sure that you could pass this case:
<br>cbacdcbc. answer is  acdb not adcb
<br>
<br>I can't solve this problem well and the interviewer said that you can scan the string twice. 
First scan is do some preprocess, and the second is to get the answer, but I really can't come up this idea.</p>



My thoughts:
O(nlogn + n) = O(nlogn) solution
1) sort a string
2) remove duplicates
OK, then I saw "cbacdcbc. answer is  acdb not adcb", my approach is wrong.


Next aprroach:
O(n) preprocessing (time and memory)
O(n) building a solution (time and memory)
So idea is in usage of dynamic programming.
Let's consider an example.
"cbacdcbc"
my first approach was in building new string character by character i.e.
1) c
2) cb
3) cba
4) cbac (aha! duplicate. now let's choose the letter to remove)
4.1) cba > bac, so we choose bac
4.2) for easiness of comparison I used a condition "if earliar (leftmost) duplicate next character
is less than current character then remove earlier occurrence else remove the last character".
In example firstC.next = 'b', 'b' < 'c', remove earlier 'c'
5) bac -> bacd
6) bacd -> bacdc -> bacd
7) bacd -> bacdb -> acdb
8) acdb -> acdbc -> acdb
9) acdb is an answer

Well, it doesn't work with "bcabc", because it would return "bac",
but good news! A simple alrorithm improvement solves this problem, just go from end to the begininng!
It is the only right way to do it, because lexigraphically a string becomes heavier in this order (from right to left), if we consider formula like
"bac" = 2*10^2 + 1*10 + 3

So okay, let's test it with vice-versa approach

test case "bcabc", excpected result "abc"
1)       c
2)      bc
3)     abc
4)    cabc -> abc
5)    babc -> abc

So approach is doing fine!
Now there are 2 problems:
1) Comparison of examples.
It might be O(n) very for every comparison, but with approach described in the above list in paragraph 4.2 it is O(1)
2) Looking for and removing duplicaes.
Which is even O(n^2) in worst case. So here we should use preprocessing. What kind?
HashMap<Character, LinkedList<Integer>> - linkedlist of character occurences in the array from right to left.
So we could check every insertion of character to out resulting string in O(1) with preprocessed usage of memory in O(n)


--------------------------------------------------
--------------------------------------------------
--------------------------------------------------

THE ONLY WORKING APPROACH (from topic):

Let's say we have string S: 

I define next[i] = next position (after i) which is equal to S[i], if there is not, -1. 

So if S="bacdbcb", next={4,-1,5,-1,6,-1,-1} 

Now, I iterate through S, from left to right, and at each position, I decide whether to pick the current character or not.
Also, there is an array called visited, which visited[i]=true means character i has been picked. 

Greedy part: 
If we are at position i, (let's say x=S[i]), we need to find the first j>i which next[j]=-1 and visited[j]=false, call it y=S[j].
Also I need to know what is the smallest character from i to j, call it z( and obviously visited[z]=false).
If the smallest character in between, z, is bigger than x, then add x to answer and visited[x] = true, otherwise skip x and continue to i+1. 

Here's the reason: 
We have something like this. 
....x .... z ... y ... 
It means definietly y is the part of answer string (since its next is -1).
So if there is nothing smaller than x between x and y (including y), for sure it's better to choose x to have a smaller lexicographic answer.
(note that all the characters between x and y have another copy after y, since y is the first position which has no next, 
so it's safe to postpone picking them, if needed). On the other hand, if z<x for sure it's better to skip x and choose another x later on. 

Because at each position i, we need to see, in worst case, all next characters, so time complexity is O(N^2). 


Example:
"cacasc"
next[2, 3, 5, -1, -1, -1]

result = ""

1.1) x = 'c', y = S[3] = 'a' (2)
1.2) z = 'a'
1.3) z < x, skip





*/



public class Main {
    
    public void dfsPorstorder(TreeNode root) {

    }

}