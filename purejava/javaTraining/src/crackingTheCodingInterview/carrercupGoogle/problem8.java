/*
http://www.careercup.com/question?id=5719426231959552

You are given a flat room 1x1 metres, a position of victim in it (v_x, v_y) and a position of a killer (k_x, k_y) both inside this room (in range [0, 1]). 
Then the killer shoots once at some direction. The bullet reflects of the walls as if it was a light ray - if it falls under angle X degrees, it will reflect at angle X degrees, if it gets into the corner it just reflects back. If the bullet hits guardian (see below) it stops and killer fails. 
Write a function that will be given coordinates of victim and a killer and will return a list of coordinates of guardians such that it's impossible for a killer to kill victim. 
That is, whichever direction the killer will shoot, the bullet will never reach victim, or will be stopped by a guardian. 

Here is an example for the case when we assume the walls don't reflect bullet (for simplicity): 
killer: (0, 0), victim: (1, 1). The solution to this simplified problem is to place 1 guardian between killer and victim e.g. on (0.1, 0.1). 

Your task is to do this with accounting bullet reflection. E.g. in the previous case the killer can shoot at (1/3, 1), the bullet will reflect to (2/3, 0) and finally get to the victim at (1, 1).


My thoughts:
1) Okay, let's draw an example. (Unfotunately, I can't insert it here)
2) Path without reflection is pretty straight forward.
3) But then I realized that there may be inifinite number of pathes with reflection.
4) With drawing 2 of them (the simplest  0,0 -> 1,1/3  and  0,0 -> 1/3,1 ) we can figure out that they intersect mostly in center. That is important assumption.
5) Now it depends on how much space can guardian defend, because in the simple case (K:0,0 and V:1,1), one guardian in the center (0.5, 0.5) may defend from all shots. So maybe we should prove that for each possible killing shot there is an intersection point in the middle of bullet trajectory.
6) And now we may provide harder example. Killer 0,0  Victim 0.5,0.5   now we obiously need more guardians, however I bet there is a possibility to find a kind of squares (4) around the victim and put 1 guardian in the center of each square.
7) Level 9999+, killer 0.25,0.25  victim 0.75,0.75, the amount of possible killing shots increased (from inifinity to infinity? :) ), actually not, but we need more guardians to hold all positions, I still believe that their number shoud be around 4.

8) There are still a lot of ambiguity, so I can't provide a solution. 

*/



public class Main {
    
}