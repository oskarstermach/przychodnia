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
import java.util.Set;

import static pl.oskarstermach.przychodnia.models.PredicateValueNames.predicateValues;

public class UpdateService extends AbstractService{

    public UpdateService(HazelcastInstance instance) {
        super(instance);
    }

    public void updateSelection() {
        System.out.println("Select option");

        PredicateValueNames.predicateValues.forEach((key, value) -> System.out.println("[" + key + "]" + value));
        int deleteOption = Integer.parseInt(in.nextLine());
        switch (deleteOption) {
            case 1:
                findAndUpdate(predicateValues.get(1),readSearchValue());
                break;
            case 2:
                findAndUpdate(predicateValues.get(2),readSearchValue());
                break;
            case 3:
                findAndUpdate(predicateValues.get(3),readSearchValue());
                break;
            case 4:
                findAndUpdate(predicateValues.get(4),readSearchValue());
                break;
            case 5:
                findAndUpdate(predicateValues.get(5),readSearchValue());
                break;
            case 6:
                findAndUpdate(predicateValues.get(6),readSearchValue());
                break;
            case 7:
                findAndUpdate(predicateValues.get(7),readSearchValue());
                break;
            case 9:
                findAndUpdate(predicateValues.get(9),readSearchValue());
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

    public void findAndUpdate(String fieldName, String value) {
        IMap<String, Receipt> receipts = instance.getMap("receipts");
        Predicate<String, Receipt> namePredicate = Predicates.equal(fieldName, value);
        Set<String> foundValues = receipts.keySet(Predicates.and(namePredicate));

        System.out.println("Updating: ");
        Receipt receipt = Builder.buildReceipt();
        String id = foundValues.stream().findFirst().get();
        receipts.put(id,receipt);

    }
}
