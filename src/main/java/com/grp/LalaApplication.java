package com.grp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.grp.mybatis")
public class LalaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LalaApplication.class, args);
	}

}
