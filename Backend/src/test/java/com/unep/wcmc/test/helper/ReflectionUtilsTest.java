package com.unep.wcmc.test.helper;

import com.unep.wcmc.helper.ReflectionUtils;
import com.unep.wcmc.model.Habitat;
import com.unep.wcmc.model.Species;
import org.junit.Assert;
import org.junit.Test;

public class ReflectionUtilsTest {

    @Test
    public void testFindAttributeName() {
        String name = ReflectionUtils.findAttributeName(Species.class, Habitat.class, "");
        Assert.assertNotNull(name);
        Assert.assertEquals(name, "naturalHistory.habitat");
    }

}
