package za.ac.cput.service.financialAid.impl;

import org.junit.*;
import org.junit.runners.MethodSorters;
import za.ac.cput.entity.financialAid.Funding;
import za.ac.cput.factory.financialAid.FundingFactory;
import za.ac.cput.service.financialAid.FundingService;

import java.util.*;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FundingServiceImplTest {

    private static FundingService service = FundingServiceImpl.getService();
    private static Funding funding = FundingFactory.createFunding("Metropolitan", "matric");

    @Test
    public void d_getAll() {
        Set<Funding> funding_s = service.getAll();
        assertEquals(1, funding_s.size());
        System.out.println("All funding: " + funding_s);
    }

    @Test
    public void e_getAllStartingWith(){
        Set<Funding> funding_s = service.getAllStartingWith("m");
        Assert.assertEquals(1, funding_s.size());
        System.out.println("Gets everything that starts with 'M':" + funding_s);
    }

    @Test
    public void a_create() {
        Funding created = service.create(funding);
        Assert.assertEquals(funding.getFundingName(), created.getFundingName());
        Assert.assertEquals(funding.getFundingRequirements(), created.getFundingRequirements());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Funding read = service.read(funding.getFundingId());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {

        Funding updated = new Funding.Builder().copy(funding).setFundingRequirements("national diploma").build();
        updated = service.update(updated);
        System.out.println("Updated: " + updated);
    }

    @Test
    public void f_delete() {

        boolean deleted = service.delete(funding.getFundingId());
        Assert.assertTrue(deleted);
    }
}