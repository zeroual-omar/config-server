package com.sgs.gis.micro.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigServerApplicationTests {

  @Test
  public void contextLoads() {
  }

  @Test
  public void coverTest2() {
    ConfigServerApplication.main(new String[0]);
  }
}
