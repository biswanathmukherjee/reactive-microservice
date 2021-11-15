/**
 *
 */
package com.ibm.learn.reactive.microservice.repositories;

import com.ibm.learn.reactive.microservice.models.CricketerDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * @author 072817744
 */
@AllArgsConstructor
@Component
public class CricketerDAO {

//    public static List<Cricketer> getCricketersTraditional() {
//
//        List<Cricketer> cricketers = new ArrayList<Cricketer>();
//
//        cricketers.add(new Cricketer("Virat", "Kohli", "Batsman", 50.2f, 4, Arrays.asList("India", "Delhi", "NorthZone", "RCB")));
//        cricketers.add(new Cricketer("Rohit", "Sharma", "Batsman", 40.5f, 0, Arrays.asList("India", "Mumbai", "WestZone", "MI")));
//        cricketers.add(new Cricketer("Ravindra", "Jadeja", "Allrounder ", 25.4f, 60, Arrays.asList("India", "Sourashtra", "WestZone", "CSK")));
//        cricketers.add(new Cricketer("Rishav", "Pant", "Wicketkeeper", 35.6f, 0, Arrays.asList("India", "Delhi", "NorthZone", "DC")));
//        cricketers.add(new Cricketer("Jasprit", "Bumrah", "Bowler", 10.2f, 200, Arrays.asList("India", "Gujarat", "WestZone", "MI")));
//        cricketers.add(new Cricketer("Ravichandran", "Ashwin", "Bowler", 15.1f, 250, Arrays.asList("India", "TamilNadu", "SouthZone", "CSK")));
//
//        return cricketers;
//    }
//
    public static List<CricketerDTO> getCricketersStream() {
        return Stream.of(
                new CricketerDTO(1, "Virat", "Kohli", "Batsman", 50.2f, 4, Arrays.asList("India", "Delhi", "NorthZone", "RCB")),
                new CricketerDTO(2, "Rohit", "Sharma", "Batsman", 40.5f, 1, Arrays.asList("India", "Mumbai", "WestZone", "MI")),
                new CricketerDTO(3, "Ravindra", "Jadeja", "Allrounder ", 25.4f, 60, Arrays.asList("India", "Sourashtra", "WestZone", "CSK")),
                new CricketerDTO(4, "Rishav", "Pant", "Wicketkeeper", 35.6f, 0, Arrays.asList("India", "Delhi", "NorthZone", "DC")),
                new CricketerDTO(5, "Jasprit", "Bumrah", "Bowler", 10.2f, 200, Arrays.asList("India", "Gujarat", "WestZone", "MI")),
                new CricketerDTO(6, "Ravichandran", "Ashwin", "Bowler", 15.1f, 250, Arrays.asList("India", "TamilNadu", "SouthZone", "CSK"))
        ).collect(Collectors.toList());
    }
//
//
//    public static Map<String, Float> getItemPrices() {
//        Map<String, Float> priceMap = new HashMap<String, Float>();
//
//        priceMap.put("bat", (float) 10000);
//        priceMap.put("ball", (float) 2000);
//        priceMap.put("wicket", (float) 5000);
//        priceMap.put("gloves", (float) 1000);
//        priceMap.put("pad", (float) 2500);
//
//        return priceMap;
//    }
//
//    public static Map<Cricketer, Integer> getScoresSortedWithAnonymousClass() {
//        Map<Cricketer, Integer> scoreCard = new TreeMap<Cricketer, Integer>(new Comparator<Cricketer>() {
//
//            @Override
//            public int compare(Cricketer o1, Cricketer o2) {
//                return (int) (o2.getBattingAverage() - o1.getBattingAverage());
//            }
//        });
//
//        scoreCard.put(new Cricketer("Virat", "Kohli", "Batsman", 50.2f, 4, Arrays.asList("India", "Delhi", "NorthZone", "RCB")), 100);
//        scoreCard.put(new Cricketer("Rohit", "Sharma", "Batsman", 40.5f, 0, Arrays.asList("India", "Mumbai", "WestZone", "MI")), 85);
//        scoreCard.put(new Cricketer("Ravindra", "Jadeja", "Allrounder ", 25.4f, 60, Arrays.asList("India", "Sourashtra", "WestZone", "CSK")), 54);
//        scoreCard.put(new Cricketer("Rishav", "Pant", "Wicketkeeper", 35.6f, 0, Arrays.asList("India", "Delhi", "NorthZone", "DC")), 10);
//        scoreCard.put(new Cricketer("Ravichandran", "Ashwin", "Bowler", 15.1f, 250, Arrays.asList("India", "TamilNadu", "SouthZone", "CSK")), 5);
//
//        return scoreCard;
//
//    }
//
//    public static Map<Cricketer, Integer> getScoresSortedUsingLambda() {
//        Map<Cricketer, Integer> scoreCard = new TreeMap<Cricketer, Integer>((o1, o2) -> (int) (o2.getBattingAverage() - o1.getBattingAverage()));
//
//        scoreCard.put(new Cricketer("Virat", "Kohli", "Batsman", 50.2f, 4, Arrays.asList("India", "Delhi", "NorthZone", "RCB")), 100);
//        scoreCard.put(new Cricketer("Rohit", "Sharma", "Batsman", 40.5f, 0, Arrays.asList("India", "Mumbai", "WestZone", "MI")), 85);
//        scoreCard.put(new Cricketer("Ravindra", "Jadeja", "Allrounder ", 25.4f, 60, Arrays.asList("India", "Sourashtra", "WestZone", "CSK")), 54);
//        scoreCard.put(new Cricketer("Rishav", "Pant", "Wicketkeeper", 35.6f, 0, Arrays.asList("India", "Delhi", "NorthZone", "DC")), 10);
//        scoreCard.put(new Cricketer("Ravichandran", "Ashwin", "Bowler", 15.1f, 250, Arrays.asList("India", "TamilNadu", "SouthZone", "CSK")), 5);
//
//        return scoreCard;
//
//    }
//
//
//    public static Map<Cricketer, Integer> getScores() {
//        Map<Cricketer, Integer> scoreCard = new HashMap<Cricketer, Integer>();
//
//        scoreCard.put(new Cricketer("Virat", "Kohli", "Batsman", 50.2f, 4, Arrays.asList("India", "Delhi", "NorthZone", "RCB")), 100);
//        scoreCard.put(new Cricketer("Rohit", "Sharma", "Batsman", 40.5f, 0, Arrays.asList("India", "Mumbai", "WestZone", "MI")), 85);
//        scoreCard.put(new Cricketer("Ravindra", "Jadeja", "Allrounder ", 25.4f, 60, Arrays.asList("India", "Sourashtra", "WestZone", "CSK")), 54);
//        scoreCard.put(new Cricketer("Rishav", "Pant", "Wicketkeeper", 35.6f, 0, Arrays.asList("India", "Delhi", "NorthZone", "DC")), 10);
//        scoreCard.put(new Cricketer("Ravichandran", "Ashwin", "Bowler", 15.1f, 250, Arrays.asList("India", "TamilNadu", "SouthZone", "CSK")), 5);
//
//        return scoreCard;
//
//    }


    public List<CricketerDTO> getAllCrickets() {
        return IntStream.rangeClosed(1, 10)
                .peek(CricketerDAO::pausePreparingCricketer)
                .peek(i -> System.out.println("Preparing Cricketer " + i))
                .mapToObj(i -> new CricketerDTO(i, "FirstName" + i, "LastName" + i, null, 10f, 10, null))
                .collect(Collectors.toList());
    }

    private static void pausePreparingCricketer(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Flux<CricketerDTO> getAllCricketsStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Preparing Cricketer " + i))
                .map(i -> new CricketerDTO(i, "FirstName" + i, "LastName" + i, null, 10f, 10, null));

    }

    public static Flux<CricketerDTO> getCricketers() {
        return Flux.just(
                new CricketerDTO(1, "Virat", "Kohli", "Batsman", 50.2f, 4, Arrays.asList("India", "Delhi", "NorthZone", "RCB")),
                new CricketerDTO(2, "Rohit", "Sharma", "Batsman", 40.5f, 1, Arrays.asList("India", "Mumbai", "WestZone", "MI")),
                new CricketerDTO(3, "Ravindra", "Jadeja", "Allrounder ", 25.4f, 60, Arrays.asList("India", "Sourashtra", "WestZone", "CSK")),
                new CricketerDTO(4, "Rishav", "Pant", "Wicketkeeper", 35.6f, 0, Arrays.asList("India", "Delhi", "NorthZone", "DC")),
                new CricketerDTO(5, "Jasprit", "Bumrah", "Bowler", 10.2f, 200, Arrays.asList("India", "Gujarat", "WestZone", "MI")),
                new CricketerDTO(6, "Ravichandran", "Ashwin", "Bowler", 15.1f, 250, Arrays.asList("India", "TamilNadu", "SouthZone", "CSK"))
        );
    }
}
