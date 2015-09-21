# interview-problems
I will upload here all my coding attempts in solving various interview problems

**Java** (proficient) solutions are in purejava/

**C++** (newbie) solutions are in cppspace/

You can find solutions for problems from: Cracking the Coding Interview book, http://leetcode.com and http://careercup.com/ in *purejava/javaTraining/src/crackingTheCodingInterview*

## My 2 tips for a preparation to an interview

### Learn how to convert words to code flawlessly

* Find a problem you don't know solution for.
* Take a look at solution.
* Describe it with your own words. Describe better. Describe even more. 
* Close the tab with solution and don't open it again until you finish coding.
* Code solution.
* Debug it. Debug it for 0, negative, inf, null. Debug it out loud. Debug it on paper.
* Try to compile.
* Errors? Don't try to randomly correct the algorithm. It should be one-shot. Think thoroughly.
* Now take a look at initial solution and compare with yours. The only thing that you should find, that initial solution may be a little bit prettier with usage of tricks / smart data structures, but no more. Both yours and initial solutions should process test cases identically.
* Yes, it is a goal I want to achieve. To make the whole process perfect.

### Don't try to memorize solutions

Actually, I read it a ton of times, but the way I have been preparing for the last 2 monthes was wrong.
I used to memorize. For every problem on http://leetcode.com/ I have met I was looking for a soution in a discuss topic, opened it in a new tab and tried to understand it, provide test examples and then code it on my own and sometimes looking at the original code to find my mistakes.

**WRONG WAY**.

It is almost right, but there are a few consequences of this method:
* Its speed is very high. I used to "solve" up to 12 problems per day (8-hour day). I even could **repeat** the code on the next day.
* But a week later I remember neighter an approach nor a code.
* I didn't understand the whole sense of used tricks. I understood only how they work with examples.

Why is it bad?

I have made 2 mock interviews with googler and ex. facebooker engineers. On the last one there was a question: "Find k'th largest element in an unsorted list". Sorting and heaps are ok, but it is not the case, there is a solution using modified QuickSort. It shocked me. Yes, I can implement QuickSort, but I didn't understand what it really hides, how it actually works. And it could be understood **only when you describe algorithm by human words**.
Yes, a kind of pseudo-code, but even simpler.

This approach is **that** important, because all questions I was asked are modifications of well know algorithms, so memorizing won't help, only deep knowledge.

So now my strategy of learning is:
* Look at the coded solution of a problem.
* Give it a couple of examples and try to debug it in mind.
* Understand how it works.
* Describe how it works with simple words.
* The above was the last step when you can see the coded solution, now close the tab and don't open it until you completely solve the problem and successfully debug it.
* Describe with more details, use pseudo-code.
* Write **your own** solution built from your words.
* It the only way to pass the interview (or you can just solve 999+ problems, though I haven't such amount of time)

Hope it will help somebody.