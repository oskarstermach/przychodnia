package pl.oskarstermach.przychodnia.service;


import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import pl.oskarstermach.przychodnia.models.Medicine;
import pl.oskarstermach.przychodnia.models.Receipt;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MedicineService extends AbstractService {

    public MedicineService(HazelcastInstance instance) {
        super(instance);
    }

    public void selectOption(){
        System.out.println("Select value");
        System.out.println(showMenu());
        String choice = in.nextLine();
        switch(choice){
            case "1":
                findTopUsedMedicines();
                break;
            case "2":
                findDoctorWithLargestAmountOfReceipts();
                break;
            case "3":
                findMostFrequentPatient();
            case "4":
                findMostPopularDiagnose();
                break;
            default:
                System.out.println("Wrong value");
        }
    }

    private String showMenu(){
        return "[1] Top used medicines\n[2] Doctors with most amount of patients\n[3] Most frequent patients\n[4] Most popular diseases\n";
    }

    public void findTopUsedMedicines() {
        IMap<String, Receipt> receipts = instance.getMap("receipts");

        final Map<String, Integer> collect = receipts.values().stream()
                .map(Receipt::getMedicineList)
                .flatMap(List::stream)
                .sorted(Comparator.comparingInt(Medicine::getAmount))
                .collect(Collectors.toMap(
                        Medicine::getName,
                        Medicine::getAmount,
                        Integer::sum));

            collect.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(10)
                    .forEach(System.out::println);
    }


    public void findDoctorWithLargestAmountOfReceipts(){
        IMap<String, Receipt> receipts = instance.getMap("receipts");

        final Map<String, Long> collect = receipts.values().stream()
                .collect(Collectors.groupingBy(k -> k.getDoctor().getPerson().toString(), Collectors.counting()));

        collect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    public void findMostFrequentPatient(){
        IMap<String, Receipt> receipts = instance.getMap("receipts");

        final Map<String, Long> collect = receipts.values().stream()
                .collect(Collectors.groupingBy(k -> k.getPatient().getPerson().toString(), Collectors.counting()));

        collect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(System.out::println);
    }


    public void findMostPopularDiagnose(){
        IMap<String, Receipt> receipts = instance.getMap("receipts");

        final Map<String, Long> collect = receipts.values().stream()
                .collect(Collectors.groupingBy(k -> k.getPatient().getDisease(), Collectors.counting()));

        collect.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(System.out::println);
    }


}
