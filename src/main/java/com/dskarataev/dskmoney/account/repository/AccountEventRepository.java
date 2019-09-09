package com.dskarataev.dskmoney.account.repository;

import com.dskarataev.dskmoney.account.event.AccountEvent;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountEventRepository {
    void send(AccountEvent event);
}
