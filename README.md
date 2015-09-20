# interview-problems
I will upload here all my coding attempts in solving various interview problems
**Java** (proficient) solutions are in purejava/
**C++** (newbie) solutions are in cppspace/
I hope to push here all my solutions for Cracking the Coding Interview book and leetcode.com problems.

## My only tip for a preparation to an interview

### Don't try to memorize solutions
Actually, I read it a ton of times, but the way I have been preparing for the last 2 monthes was wrong.
I used to memorize. For every problem on http://leetcode.com/ I have met I was looking for a soution in a discuss topic, opened it in a new tab and tried to understand it, provide test examples and then code it on my own and sometimes looking at the original code to find my mistakes.
**WRONG WAY**.

It is almost right, but there are a few consequences of this method:
* Its speed is very high. I used to "solve" up to 12 problems per day (8-hour day). I even could **repeat** the code on the next day.
* But a week later I remember neighter an approach nor a code.
* I didn't understand the whole sense of used tricks. I understood only how they work with examples.

Why it is bad?
I have made 2 mock interviews with googler and ex. facebooker enineers. On the last one there was a question: "Find k'th largest element in an unsorted list". Sorting and heaps are ok, but it is not the case, there is a solution using modified QuickSort. It shocked me. Yes, I can implement QuickSort, but I didn't understand what it really hides, how it actually works. And it could be understood **only when you describe algorithm by human words**.
Yes, a kind of pseudo-code, but even simpler.
This approach is **that** important, because all questions I was asked are modifications of well know algorithms, so memorizing won't help, only deep knowledge.

So now my strategy of learning is:
1. Look at the coded solution of a problem.
2. Give it a couple of examples and try to debug it in mind.
3. Understand how it works.
4. Describe how it works with simple words.
5. The above was the last step when you can see the coded solution, now close the tab and don't open it until you completely solve the problem and successfully debug it.
6. Describe with more details, use pseudo-code.
7. Write **your own** solution built from your words.
8. It the only way to pass the interview (or you can just solve 999+ problems, though I haven't such amount of time)