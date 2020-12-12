package com.gm.shuai_ping;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gm.shuai_ping.mapper")
public class ShuaiPingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShuaiPingApplication.class, args);
    }

}
