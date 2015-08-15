package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.FileInputStream;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class DecisionTableTest {

    private KieServices kieServices;
    private KieContainer kieContainer;
    private KieSession kieSession;
    private String drl;

    @Before
    public void initialize() throws Exception {
        if (kieSession != null) {
            kieSession.dispose();
        }
        this.kieServices = KieServices.Factory.get();
        this.kieContainer = kieServices.getKieClasspathContainer();

        SpreadsheetCompiler compiler = new SpreadsheetCompiler();
        this.drl = compiler.compile(
                new FileInputStream("src/main/resources/rules/extinction/risk/table/extinction-rules.xls"),
                InputType.XLS);

        this.kieSession = kieContainer.newKieSession("ExtinctionRisk");
    }

    @Test
    public void testSomething() {
        System.out.println(drl);
    }


}