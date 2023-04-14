import java.util.*;

public class LabTutor {
    //collection of labs students went through which I solved to make teaching easier
    //Class is taught in C++ but I'm more efficient in Java



    //Function to print a name diamond
    /*example: One
     * O
     * On
     * One
     *  ne
     *   e
     */
    public static void nameDiamond(String target){//1
        for(int i=0;i<=target.length();i++){//first half of diamond
            System.out.println(target.substring(0,i));
        }
        for(int i=1;i<target.length();i++){//second half of diamond
            for(int j=1;j<=i;j++){
                System.out.print(" ");
            }
            System.out.println(target.substring(i,target.length()));
        }

    }
//Function to determine which numbers are within a provided range within a list
    public static List<Integer> countInRange(List<Integer> list, int min, int max){ //2
        List<Integer> count = new ArrayList<Integer>();
        for(int element:list){//simply checks each element and if it is within the range
            if((element>= min) && (element<= max)){
                count.add(element);
            }
        }
        return count;
        } 
//Function to remove all targeted string from a list of strings
    public static List<String> removeAll(List<String> list, String target){ //3
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).toLowerCase().equals(target.toLowerCase())){
                list.remove(i);
                i--;
            }
        }
        return list;
    }    
    public static HashMap<String, Integer> TallyVotes(String str){ //4
        HashMap<String, Integer> votes = new HashMap<String, Integer>();
        for(int i = 0;i<str.length();i++){
            String curr = String.valueOf(str.charAt(i));
            if(votes.containsKey(curr)){
                votes.put(curr, votes.get(curr)+1);
            }
            else{
                votes.put(curr, 1);
            }
        
    }
    return votes;
}
    //simple function to 
    public static double RecPow(double num, Integer pow){
        if(pow==1){
            return num;
        } else if(pow < 0) {
            return (1 / (num * RecPow(num,-pow)));
        } else {
            if(pow%2==0){
                double calc = RecPow(num, pow/2);
                return (calc * calc);
            } else {
                double calc = RecPow(num, pow/2);
                return (calc * calc) * num;
            }
        }     
        }

    public static ListNode MergeSortedList(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        } if (l1.val < l2.val){
            l1.next = MergeSortedList(l1.next, l2);
            return l1;
        } else {
            l2.next = MergeSortedList(l1, l2.next);
            return l2;
        }
    } 
    public static void main(String[] args){
        System.out.print("Enter a number: ");
        boolean exit = false;
        
        while (exit == false) { 
            Scanner input = new Scanner(System.in);
            System.out.print("Choose one of the following options: \n" + "Name Diamond (1) \n" + "Count In Range (2) \n" + "Remove All (3) \n" + "Tally Votes (4) \n" +  "Recursive Power (5) \n" + "Exit (10) \n");
            int choice = input.nextInt();
            if(choice == 1){
                System.out.print("Enter a word: ");
                String target = input.next();
                nameDiamond(target);
            } else if(choice == 2){
                System.out.print("Enter a number >= 0: ");
                int min = input.nextInt();
                System.out.print("Enter a number <= 1000: ");
                int max = input.nextInt();
                List<Integer> list = new ArrayList<Integer>();
                for(int i = 0;i <= 1000;i++){
                    list.add(i);
                }
                System.out.println(countInRange(list, min, max));
            } else if(choice == 3){
                System.out.print("Enter a word: ");
                String word = input.next();
                System.out.print("Choose a character to remove: ");
                String target = input.next();
                List<String> wordList = new ArrayList<String>();
                for(int i = 0;i<word.length();i++){
                    wordList.add(String.valueOf(word.charAt(i)));
                }
                wordList = removeAll(wordList, target);
                String print = new String();
                for(String element:wordList){
                    print += element;
                } 
                System.out.println(print);
            } else if(choice == 4){
                System.out.print("Enter a list of votes (string of characters): ");
                String word = input.next();
                HashMap<String, Integer> votes = TallyVotes(word);
                for(String key : votes.keySet()){
                    System.out.println(key + " " + votes.get(key));
                }
            } else if(choice == 5){
                System.out.print("Enter a number: ");
                int num = input.nextInt();
                System.out.print("Enter an exponent: ");
                int pow = input.nextInt();
                System.out.println(RecPow(num, pow));
            } else if(choice == 6){
                continue;
            } else if(choice == 7){
                continue;
            } else if(choice == 8){
                continue;
            } else if(choice == 9){
                continue;
            } else if(choice == 10){
                exit = true;
                input.close();
            }
            
        }
        //nameDiamond("Diamond");

        /*List<Integer> list = new ArrayList<Integer>();
        for(int i = 1;i <= 10;i++){
            list.add(i);
        }
        System.out.println(countInRange(list,2,7));
        */

    /*     List<String> list = new ArrayList<String>();
    
        System.out.println(RemoveAll(list, "a"));
    */
      
    /*HashMap<String, Integer> votes = TallyVotes("AAAABBBBCCCCDDDD");
        for(String key : votes.keySet()){
            System.out.println(key + " " + votes.get(key));
        }
    */
        
     //   System.out.println(RecPow(2,-4));
}
}
