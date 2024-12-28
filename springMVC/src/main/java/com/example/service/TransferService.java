package com.example.service;

import com.example.model.Account;
import com.example.repositories.AccountRepositorySpringData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {

    private final AccountRepositorySpringData accountRepositorySpringData;

    public TransferService(AccountRepositorySpringData accountRepositorySpringData) {
        this.accountRepositorySpringData = accountRepositorySpringData;
    }

    @Transactional
    public void transferMoney (long idSender, long idReceiver, BigDecimal amount) throws AccountNotFoundException {
        // 원본 계좌 및 대상 계좌의 상세 정보를 가져와 두 계좌의 금액을 확인한다.
        Account sender = accountRepositorySpringData.findById(idSender)
                .orElseThrow(() -> new AccountNotFoundException());

        Account receiver = accountRepositorySpringData.findById(idReceiver)
                .orElseThrow(() -> new AccountNotFoundException());

        // 첫 번째 계좌에서 이체할 금액을 뺀 금액을 설정하고 출금한다.
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // 계좌의 현재 금액에 이체 금액을 더한 금액으로 새 값을 설정하여 대상 계좌에 입금한다.
        accountRepositorySpringData.changeAmount(idSender, senderNewAmount);
        accountRepositorySpringData.changeAmount(idReceiver, receiverNewAmount);
    }

    public Iterable<Account> getAllAccounts() {
        return accountRepositorySpringData.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepositorySpringData.findAccountsByName(name);
    }
}
