import model.Person;
import model.MyPredicate;
import model.RoboContactLambda;

import java.util.List;

/**
 * Created by GamePC on 9/27/2016.
 */
public class Main {

    public static void main(String[] args) {
        List<Person> pl = Person.createShortList();
        RoboContactLambda robo = new RoboContactLambda();

        MyPredicate<Person> allDrivers = p -> p.getAge() >= 16;
        MyPredicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender() == Person.Gender.MALE;
        MyPredicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

        System.out.println("\n=== Calling all Drivers ===");
        robo.callDrivers(pl, allDrivers);

        System.out.println("\n=== Emailing all Draftees ===");
        robo.emailContacts(pl, allDraftees);

        System.out.println("\n=== Mail all Pilots ===");
        robo.mailContacts(pl, allPilots);
    }
}
