package com.unep.wcmc.test.rules;

import com.google.common.collect.Lists;
import com.unep.wcmc.Application;
import com.unep.wcmc.model.*;
import com.unep.wcmc.repository.ExtinctionRiskConfigurationRepository;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DecisionTableTest {

    private KieServices kieServices;
    private KieContainer kieContainer;
    private KieSession kieSession;

    @Autowired
    private ExtinctionRiskConfigurationRepository repo;

    @Before
    public void initialize() throws Exception {
        if (kieSession != null) {
            kieSession.dispose();
        }
        this.kieServices = KieServices.Factory.get();
        this.kieContainer = kieServices.getKieClasspathContainer();

        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        String drl = compiler.compile(new FileInputStream("src/main/resources/rules.xls"), InputType.XLS);

        this.kieSession = kieContainer.newKieSession("DecisionTableKS");
    }

    @Test
    public void testSomething() {
        System.out.println("test");
    }


}