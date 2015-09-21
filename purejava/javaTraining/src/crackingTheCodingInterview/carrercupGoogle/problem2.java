/*
http://www.careercup.com/question?id=5693954190213120
<p>Number list compressing.
<br>Given an sorted array. Input: sorted number list
<br> 1, 2, 3,10, 25, 26, 30, 31, 32, 33
<br>
<br> Output: find consecutive segments
<br> print: 1-3, 10, 25-26, 30-33</p>


My thoughts:

start with 1st number
chech if next number is equal to 1st number + 1
if equals then go to the next number
else break sequence, end with "-n"


Pseudo-code:
if array length < 2 return array [0]

bool endedSeq = true
string result
add 1st number to result
for i = 1 to array length
  if endedSeq == true then
    if i != 0 then
      result add ", "
    result add (array[i-1])
  if array [i] <= array [i-1] + 1 AND i != array.length -1 then // "<=" for handling duplicates case
    continue
  else
    result add ("-" + array[i-1]) 
    endedSeq = true

THERE IS A BUG!
1) duplicate of 1st number
2) no last number
3) if number is alone it will generate for example 15-15

Fixes:
1) set endedSeq to false initially, remove useless check "if i != 0"
2) make loop go untill i <= len and edit upper bound check "AND i != array.length -1" to "AND i != array.length"
3) add additional variable sequenceLength, increment it near the "continue", 
   if "endedSeq" check set it to 1, in the last condition check "result add ("-" + array[i-1])", add condition "sequenceLength > 1"

Final pseudo-code:
if array length < 2 return array [0]
bool endedSeq = false
int suequenceLength = 0
string result
add 1st number to result
for i = 1 to array length inclusivly
  if endedSeq == true then
    result add ", "
    result add (array[i-1])
    endedSeq = false
    sequenceLenth = 1;
  if array [i] <= array [i-1] + 1 AND i != array.length then // "<=" for handling duplicates case
    sequenceLenth++
  else
    if (sequenceLength > 1) then
      result add ("-" + array[i-1]) 
    endedSeq = true



examples:


*/





public class Main {
    

    // doesn't work
    public String consecutiveSegments(int[] array) {
        if (array == null) return null;
        int len = array.length;
        if (len < 2) return "" + array[0];

        StringBuilder result = new StringBuilder();
        result.add("" + array[0]);

        boolean endedSeq = true;

        for (int i = 1; i < len; i++) {
            if (endedSeq) {
                if (i != 0) {
                    result.add(", ");
                }
                result.add("" + array[i-1]);
                endedSeq = false;
            }
            if (array[i] <= array[i-1] + 1 && i != len -1) {
                continue;
            } else {
                result.add("-" + array[i-1]);
                endedSeq = true;
            }
        }

    }



    // works perfect!
    public String consecutiveSegments(int[] array) {
        if (array == null) return null;
        int len = array.length;
        if (len < 2) return "" + array[0];

        StringBuilder result = new StringBuilder();
        result.append("" + array[0]);

        boolean endedSeq = false;
        int seqLength = 0;
        
        for (int i = 1; i <= len; i++) {
            if (endedSeq) {
                result.append(", ");
                result.append("" + array[i-1]);
                endedSeq = false;
                seqLength = 1;
            }
            
            if (i != len && array[i-1] + 1 >= array[i]) {
                seqLength++;
            } else {
                endedSeq = true;
                if (seqLength > 1)
                    result.append("-" + array[i-1]);
            }
        }
        return result.toString();

    }
}