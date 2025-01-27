package String.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class SentenceSimilarity_1813 {
    public static void main(String[] args) {
//        System.out.println(areSentenceSimilar("My name is Haley","My Haley"));
        System.out.println(areSentenceSimilar2("My name is Haley","My Haley"));
    }

    private static boolean areSentenceSimilar(String s1, String s2) {

        if(s1.length()<s2.length()){
            s1 = s1+ s2;
            s2 = s1.substring(0,s1.length()-s2.length());
            s1 = s1.substring(s2.length());}
        String[] s1arr = s1.split(" ");
        String[] s2arr = s2.split(" ");
        int i = 0, j = s1arr.length-1;
        int k = 0, l = s2arr.length-1;
        while(k < s2arr.length && i < s1arr.length && s1arr[i].equals(s2arr[k])) {
            i++;
            k++;
        }
        while(l >= k && s1arr[j].equals(s2arr[l])){
            j--;
            l--;
        }

        return l<k;
    }
    private static boolean areSentenceSimilar2(String s1, String s2) {
        if(s1.length()<s2.length()){
            s1 = s1+ s2;
            s2 = s1.substring(0,s1.length()-s2.length());
            s1 = s1.substring(s2.length());
        }
        ArrayDeque<String> s1Deque = new ArrayDeque<>();
        ArrayDeque<String> s2Deque = new ArrayDeque<>();
        String[] s1arr = s1.split(" ");
        String[] s2arr = s2.split(" ");
        for (int i = s1arr.length-1 ; i >= 0 ; i--) {
            s1Deque.push(s1arr[i]);
        }
        for (int i = s2arr.length-1 ; i >= 0 ; i--) {
            s2Deque.push(s2arr[i]);
        }

        System.out.println("s1Deque = " + s1Deque);
        System.out.println("s2Deque = " + s2Deque);
        while(!s1Deque.isEmpty() && !s2Deque.isEmpty() && s1Deque.getFirst().equals(s2Deque.getFirst())) {
            s1Deque.removeFirst();
            s2Deque.removeFirst();
        }

        while(!s1Deque.isEmpty() && !s2Deque.isEmpty() && s1Deque.getLast().equals(s2Deque.getLast())) {
            s1Deque.removeLast();
            s2Deque.removeLast();
        }

        return s2Deque.isEmpty();
    }
}
