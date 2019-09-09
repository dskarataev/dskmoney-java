package com.dskarataev.dskmoney.account.repository;

import com.dskarataev.dskmoney.account.entity.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AccountRepository {
    List<Account> read();
    Account read(int id);

    @Insert("INSERT INTO accounts SET ")
    void create(Account account);
    void update(Account account);
    void delete(Account account);
}
