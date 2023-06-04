package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class WalletService {
    AccountRepisitory accountRepisitory;

    Calculator calculator;

    public  int addSum(int sum, String txId, String account){
        int sumFromAccount = accountRepisitory.getSumByAccount(account);
        System.out.println(String.format("Created transaction for account #s. Id=[%s]}%n",account,txId));
        return calculator.add(sum,sumFromAccount);
    }

}
