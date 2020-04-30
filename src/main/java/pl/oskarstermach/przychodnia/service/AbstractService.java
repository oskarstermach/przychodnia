package pl.oskarstermach.przychodnia.service;

import com.hazelcast.core.HazelcastInstance;

import java.util.Scanner;

public abstract class AbstractService {
    public Scanner in = new Scanner(System.in);
    public HazelcastInstance instance;

    public AbstractService(HazelcastInstance instance) {
        this.instance = instance;
    }
}
