package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.service.ExtinctionRiskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ExtinctionRiskServiceTest {

    @Autowired
    private ExtinctionRiskService service;

    @Test
    public void testSomething() {
        //service.processExtinctionRiskCalculation();
    }

}
