package za.ac.cput.factory;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.entity.tertiaryInstitution.Faculty;
import za.ac.cput.factory.tertiaryInstitution.FacultyFactory;



public class FacultyFactoryTest {

    Faculty faculty = FacultyFactory.createFaculty("1", "Informatics and Design");

    @Test
    public void createFaculty() {
        Assert.assertEquals("1", faculty.getFacultyCode());
        Assert.assertEquals("Informatics and Design", faculty.getFacultyName());
   }
}