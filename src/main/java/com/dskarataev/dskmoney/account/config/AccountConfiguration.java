package com.dskarataev.dskmoney.account.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.dskarataev.dskmoney.account.repository")
public class AccountConfiguration {
}
