package com.unep.wcmc.test.service;

import com.unep.wcmc.Application;
import com.unep.wcmc.model.ChangeLog;
import com.unep.wcmc.model.DistributionArea;
import com.unep.wcmc.model.Species;
import com.unep.wcmc.repository.SpeciesRepository;
import com.unep.wcmc.service.MetadataService;
import org.javers.core.Javers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class MetadataServiceTest {

    @Autowired
    private Javers javers;

    @Autowired
    private SpeciesRepository speciesRepo;

    @Autowired
    private MetadataService metadataService;

    @Test
    public void testMetadataChanges() {
        Species species = speciesRepo.getFetchLoadedById(1l);
        species.setScientificName("XXXX");
        DistributionArea distributionArea = new DistributionArea();
        distributionArea.setId(-1l);
        distributionArea.setOcurrsBrazil(true);
        distributionArea.setNativeBrazil(true);
        distributionArea.setEndemicFromBrazil(true);
        species.setDistributionArea(distributionArea);

        List<ChangeLog> changes = metadataService.processMetadata(species);
        System.out.println(changes);


        //diff.getChanges().get(0).

        //QueryBuilder.

        //javers.

//        javers.commit("user", existing);
//        javers.commit("user", species);
    }

    @Test
    public void approveMetadata() throws Exception {
        ChangeLog changeLog = new ChangeLog();
        changeLog.setId(1l);
        Species species = metadataService.approveMetadata(changeLog);
        System.out.println(species);
    }

}
