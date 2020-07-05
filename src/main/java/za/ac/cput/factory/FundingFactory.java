package za.ac.cput.factory;

import za.ac.cput.entity.Funding;
import java.util.ArrayList;

public class FundingFactory {

    public static Funding createFunding ( ArrayList <Funding> bursaryList){

        return new Funding.Builder()
                .setBursaryList(bursaryList)
                .build();
    }
}


