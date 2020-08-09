package com.gem.furniture;

import com.gem.furniture.mapper.FurUserMapper;
import com.gem.furniture.service.FurUserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FurnitureApplicationTests {
    @Autowired
    public FurUserMapper furUserMapper;


    @Autowired
    private FurUserService userService;


}
