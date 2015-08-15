package com.unep.wcmc.test.rules;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.Conservation;
import com.unep.wcmc.model.ExtinctionRisk;
import com.unep.wcmc.model.ExtinctionRiskCategory;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.service.ExtinctionRiskService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class NotApplicableTest {

    @Autowired
    private ExtinctionRiskService service;

    @Test
    public void testNotApplicable_NA_1() {
        Species species = new Species();
        Conservation conservation = new Conservation();
        ExtinctionRisk extinctionRisk = new ExtinctionRisk();
        extinctionRisk.setNationalEvaluationElegible(false);
        conservation.setExtinctionRisk(extinctionRisk);
        species.setConservation(conservation);

        service.processExtinctionRiskCalculation(species);

        Assert.assertNotNull(species);
        Assert.assertEquals(ExtinctionRiskCategory.NOT_APPLICABLE,
                species.getExtinctionRiskCategory());
    }

}