package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        for (Account accounts : users.get(findByPassport(passport))) {
            if (accounts.equals(account)) {
                return;
            }
        }
        users.get(findByPassport(passport)).add(account);
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        if (findByPassport(passport) != null) {
            for (Account accounts : users.get(findByPassport(passport))) {
                if (accounts.getRequisite().equals(requisite)) {
                    return accounts;
                }
            }
        }
        System.out.println("There is no user with this passport");
        return null;
    }

        public boolean transferMoney(String srsPassport, String srcRequisite,
                String destPassport, String destRequisite, double amount) {
            boolean rsl = false;
            Account scr = findByRequisite(srsPassport, srcRequisite);
            Account dest = findByRequisite(destPassport, destRequisite);
            if (scr != null && dest != null && scr.getBalance() >= amount) {
                scr.setBalance(scr.getBalance() - amount);
                dest.setBalance(dest.getBalance() + amount);
                return true;
            }
                return rsl;
        }

        public List<Account> getAccounts(User user) {
            return users.get(user);
        }
}