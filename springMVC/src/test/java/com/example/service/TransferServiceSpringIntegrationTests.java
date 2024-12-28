package com.example.service;

import com.example.model.Account;
import com.example.repositories.AccountRepositorySpringData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceSpringIntegrationTests {

    @MockBean
    private AccountRepositorySpringData accountRepositorySpringData;

    @Autowired
    private TransferService transferService;

    @Test
    void transferServiceTransferAmountTest() {
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal(1000));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal(1000));

        when(accountRepositorySpringData.findById(1L)).thenReturn(Optional.of(sender));
        when(accountRepositorySpringData.findById(2L)).thenReturn(Optional.of(receiver));

        transferService.transferMoney(1, 2, new BigDecimal(100));

        verify(accountRepositorySpringData).changeAmount(1, new BigDecimal(900));
        verify(accountRepositorySpringData).changeAmount(2, new BigDecimal(1100));
    }
}
