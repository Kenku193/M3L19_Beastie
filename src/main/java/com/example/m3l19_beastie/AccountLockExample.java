package com.example.m3l19_beastie;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountLockExample {

    private final Lock lock = new ReentrantLock(true);

    private final Condition balanceCondition = lock.newCondition();

    private long balance;

    public AccountLockExample(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        try {lock.lock();
            return balance;
        }
        finally {
            lock.unlock();
        }
    }
    public void deposit(long amount){
        try {
            lock.lock();
            balance += amount;
        }
        finally {
            lock.unlock();
        }
    }
}
