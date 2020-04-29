package pl.oskarstermach.przychodnia.service;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;
import pl.oskarstermach.przychodnia.HConfig;
import pl.oskarstermach.przychodnia.models.PredicateValueNames;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.net.UnknownHostException;
import java.util.Collection;
import java.util.Scanner;

import static pl.oskarstermach.przychodnia.models.PredicateValueNames.predicateValues;

public class DeleteService {
    private HazelcastInstance instance;
    private Scanner in = new Scanner(System.in);

    public DeleteService() throws UnknownHostException {
        Config config = HConfig.getConfig();
        this.instance = Hazelcast.newHazelcastInstance(config);
    }

    public void deleteOptionSelector() {
        System.out.println("Select option");

        PredicateValueNames.predicateValues.forEach((key, value) -> System.out.println("[" + key + "]" + value));
        int deleteOption = Integer.parseInt(in.nextLine());
        switch (deleteOption) {
            case 1:
                findAndDelete(predicateValues.get(1),readSearchValue());
                break;
            case 2:
                findAndDelete(predicateValues.get(2),readSearchValue());
                break;
            case 3:
                findAndDelete(predicateValues.get(3),readSearchValue());
                break;
            case 4:
                findAndDelete(predicateValues.get(4),readSearchValue());
                break;
            case 5:
                findAndDelete(predicateValues.get(5),readSearchValue());
                break;
            case 6:
                findAndDelete(predicateValues.get(6),readSearchValue());
                break;
            case 7:
                findAndDelete(predicateValues.get(7),readSearchValue());
                break;
            case 9:
                findAndDelete(predicateValues.get(9),readSearchValue());
                break;
            default:
                System.out.println("Not implemented yet");
                break;
        }
    }

    private String readSearchValue() {
        System.out.println("Insert search value for desired field");
        return in.nextLine();
    }

    public void findAndDelete(String fieldName, String value) {
        IMap<String, Receipt> receipts = instance.getMap("receipts");
        Predicate<String, Receipt> namePredicate = Predicates.equal(fieldName, value);
        Collection<Receipt> foundValues = receipts.values(Predicates.and(namePredicate));
        System.out.println("Deleting: ");
        foundValues.forEach(System.out::println);
        receipts.removeAll(namePredicate);
    }

}
