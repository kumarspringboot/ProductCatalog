package com.alt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

//@SpringBootTest
class ProductCatalogApplicationTests {

//    @Test
//    void contextLoads() {
//    }
    public static void main(String[] args){
        System.out.println("<UNK>");
        String sentence = "Programming Fun";
        sentence = sentence.toLowerCase().replace(" ","");
        System.out.println(sentence.toCharArray());

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: sentence.toCharArray()){
        if(map.containsKey(c)){
            map.put(c,map.get(c)+1);
        }else{
            map.put(c,1);
        }
        for(char c1 : map.keySet()){
            System.out.println(c1+" : "+map.get(c1));
        }
        }


//        String sentence = "The cat chased the dog and the dog ran away";
//        sentence = sentence.toLowerCase();
//        String[] words =  sentence.split(" ");
//        HashMap<String, Integer> freqMap = new HashMap<>();
//
//        for(String word: words){
//            if(freqMap.containsKey(word)){
//                freqMap.put(word,freqMap.get(word)+1);
//            }else{
//                freqMap.put(word,1);
//            }
//        }
//
//        for(String word: freqMap.keySet()){
//            System.out.println(word + "->"+freqMap.get(word));
//        }









//        Map<String, Integer> fruitCount= new HashMap<>();
//        fruitCount.put("Apple", 3);
//        fruitCount.put("Banana", 5);
//        fruitCount.put("Orange", 2);
//
//        fruitCount.remove("Apple");
//        fruitCount.put("Mango", 3);
//        System.out.println(fruitCount);
//
//        for(String fruit: fruitCount.keySet()){
//            System.out.println(fruit);
//        }
//
//        for(Integer Quantity : fruitCount.values()){
//            System.out.println(Quantity);
//        }
//
//        for(Map.Entry<String, Integer> entry: fruitCount.entrySet()){
//        System.out.print(entry.getKey()+"->"+"");
//        System.out.println(entry.getValue());
//        }

    }



}
