package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.factory.financialAid.FundingFactory;


public class FundingFactoryTest {

    @Test
    public void createBursaries() {
        Funding funding = FundingFactory.createFunding("NSFAS", "50% Aggregate");

        Assert.assertEquals("NSFAS", funding.getFundingName());
        Assert.assertEquals("50% Aggregate", funding.getFundingRequirements());
    }
}