package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by GamePC on 9/27/2016.
 */
public class SearchCriteria {

    private final Map<String , MyPredicate<Person>> searchMap = new HashMap<>();

    private SearchCriteria(){
        super();
        initSearchMap();
    }

    private void initSearchMap() {
        MyPredicate<Person> allDrivers = person -> person.getAge() >= 16;
        MyPredicate<Person> allDraftees = person -> person.getAge() >= 18 && person.getAge() <= 25 && person.getGender() == Person.Gender.MALE;
        MyPredicate<Person> allPilots = person -> person.getAge() >= 23 && person.getAge() <= 65;

        searchMap.put("allDrivers", allDrivers);
        searchMap.put("allDraftees", allDraftees);
        searchMap.put("allPilots", allPilots);
    }

    public MyPredicate<Person> getCriteria(String predicateName){
        MyPredicate<Person> target = searchMap.get(predicateName);
        if(target == null){
            System.out.println("Search Criteria not found...");
            System.exit(1);
        }
        return target;
    }

    public static SearchCriteria getInstance(){
        return new SearchCriteria();
    }
}
