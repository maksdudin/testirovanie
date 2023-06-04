package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class WalletServiceTest {
WalletService walletService;

@Mock
AccountRepisitory accountRepisitory;

@Spy
Calculator calculator;

@BeforeEach
public  void init(){

    walletService = new WalletService(accountRepisitory,calculator);
}
    @Test
    void addSum() {
    String account = "1234";
    when(accountRepisitory.getSumByAccount(account)).thenReturn(1200);
    int result = walletService.addSum(1000,"tx_111","1234");


    assertEquals(2200,result);
    }
}