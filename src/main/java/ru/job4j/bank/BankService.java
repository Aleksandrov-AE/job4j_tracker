package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы.
 * В системе можно производить следующие действия.
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя из системы.
 * 3. Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
 * 4. Переводить деньги с одного банковского счета на другой счет.
 * У одного пользователя в банковской системе может быть несколько счетов
 * @author ANATOLIT ALEXANDROV
 *  * @version 1.0
 */
public class BankService {
    /**
     * Поле users содержит всех пользователей системы с привязанными к ним счетами
     * Хранение осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**Метод принимает на вход нового пользователя добавляет его в банковскую систему.
     *В методе есть проверка, что такого пользователя еще нет в системе. Если он есть,
     * то новый пользователь не добавляется. По умолчанию  при добавлении пользователя
     * к нему добавляется пустой список банковских счетов в виде new ArrayList<Account>().
     * @param user пользователь который добавляется в систему
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход номер паспорта и банковский счет,который нужно добавить пользователю.
     * Находит пользователя по этим параметрам в банковсой системе и если у пользователя нет такого счета
     * добавляет ему этот банковский счет
     * @param passport номер паспорта пользователя которому нужно добавить банковский счет
     * @param account номер банковского счета
     */
    public void addAccount(String passport, Account account) {
        User key = findByPassport(passport);
        if (key != null && !users.get(key).contains(account)) {
            users.get(key).add(account);
        }
    }

    /**Метод находит пользователя в банкоской системе по номеру паспорта
     *
     * @param passport номер паспорта пользователя, которого нужно найти
     * @return возвращает пользователя если он найден или null если нет
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод принимает на вход номер паспорта и реквизиты банковского счета
     * и ищет по ним  банковский счет пользователя банковской системы
     * @param passport номер паспорта по которуму нужно найти банковский счет
     * @param requisite реквизиты по которым нужно найти банковский счет
     * @return возвращает обьект банковский счет или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User key = findByPassport(passport);
        if (key != null) {
            for (Account accounts : users.get(key)) {
                if (accounts.getRequisite().equals(requisite)) {
                    return accounts;
                }
            }
        }
        return null;
    }

    /**
     * Метод позволяет перечислить деньги с одного счёта на другой счёт
     * @param srsPassport номер паспорта пользователя который переводит деньги
     * @param srcRequisite Реквизиты счета пользователя который переводит деньги
     * @param destPassport номер паспорта пользователя который получает деньги
     * @param destRequisite номер паспорта пользователя который получает деньги
     * @param amount сумма перевода
     * @return true если перевод осуществлен и false если счёт не найден
     * или не хватает денег на счёте srcAccount (с которого переводят)
     */
    public boolean transferMoney(String srsPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account scr = findByRequisite(srsPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (scr != null && dest != null && scr.getBalance() >= amount) {
            scr.setBalance(scr.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод позволяет получить все банковские счета пользователя в банковской системе
     * @param user пользователь счета которого нужно получить
     * @return возвращает все счета пользователя в виде List и null если такого пользователя нет в банковской системе
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}