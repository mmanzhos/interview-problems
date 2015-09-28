/*
http://www.careercup.com/question?id=5722316476514304

you are on a biz trip and travelling from one city to another.
you have a stack of unsorted flight boarding passes.
only departure city and destination city are on the boarding pass.
how do you find the first departure city and your final destination city, write the solution in javascript.


My thoughts:
1) Okay is may be hard to make it quickly initially, but...
2) It may be a graph problem.
3) The best solution would be sort them by time :)
4) I don't actually know, let's try with example:
LA -> SF -> NY -> Washington -> Seattle -> LA
MISTAKE! We should return to LA, because this task became impossible to solve
LA -> SF -> NY -> Washington -> Seattle
1) Find the only node without outcoming connection
2) Find the only node without incoming connection

Found in the topic
1) Create array of cities with values 0
2) Pick ticket, for departure city descrease its value, for destination - increase
3) So in the end, our first city will have value of -1, for the final city value of +1
4) Brilliant!

*/



public class Main {
    

    // I tried to code a few lines about graph approach, but I got stucked in its representation, 
    // because, at least I need to build a Graph from stack, somehow count unique cities, argh....
    public void hashmapApproach(Stack<BoardingPass> stack) {

        HashMap<City, Integer> map = new HashMap<City, Integer>();
        for (BoardingPass bp : stack) {
            City from = bp.getDeparture();
            City to = bp.getDestination();
            if (map.containsKey(from)) {
                map.put(from, map.get(from)-1);
            } else {
                map.put(from , 0);
            }
            if (map.containsKey(to)) {
                map.put(to, map.get(to)+1);
            } else {
                map.put(to , 0);
            }
        }
        City first = null;
        City last = null;
        for (Map.Entry<City, Integer> entry : map.entrySet()) {
            if (entry.getValue() == -1)
                first = entry.getKey();
            if (entry.getValue() == 1)
                last = entry.getKey();
        }

        System.out.println("Departure city: " + first.getName());
        System.out.println("Destination city: " + last.getName());
    }


}