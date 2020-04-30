package pl.oskarstermach.przychodnia.service;


import com.whalin.MemCached.MemCachedClient;

import java.util.Scanner;

public class MedicineService extends AbstractService {

    public MedicineService(Scanner in, MemCachedClient memCachedClient) {
        super(in, memCachedClient);
    }

    public void selectOption(){
        System.out.println("Cant query memcached!");
    }

    private String showMenu(){
        return "[1] Top used medicines\n[2] Doctors with most amount of patients\n[3] Most frequent patients\n[4] Most popular diseases\n";
    }




}
