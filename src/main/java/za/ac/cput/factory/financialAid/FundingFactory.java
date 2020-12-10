package za.ac.cput.factory.financialAid;


import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.util.GenericHelper;
import za.ac.cput.util.StringHelper;

public class FundingFactory {

    public static Funding createFunding(String fundingName,String fundingRequirements) {
        if (StringHelper.isNullorEmpty(fundingName)) return new Funding.Builder().build();
        if (StringHelper.isNullorEmpty(fundingRequirements)) return new Funding.Builder().build();
        String fundingId = GenericHelper.generateRandom();

        Funding funding = new Funding.Builder()
                .setFundingId(fundingId)
                .setFundingName(fundingName)
                .setFundingRequirements(fundingRequirements)
                .build();
        return funding;

    }

}