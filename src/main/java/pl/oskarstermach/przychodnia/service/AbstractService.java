package pl.oskarstermach.przychodnia.service;

import com.whalin.MemCached.MemCachedClient;

import java.util.Scanner;

public abstract class AbstractService {
    public Scanner in;
    public MemCachedClient memCachedClient;

    public AbstractService(Scanner in, MemCachedClient memCachedClient) {
        this.in = in;
        this.memCachedClient = memCachedClient;
    }
}
