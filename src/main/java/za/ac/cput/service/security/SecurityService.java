package za.ac.cput.service.security;

import za.ac.cput.entity.security.Security;
import za.ac.cput.service.IService;

import java.util.Set;

public interface SecurityService extends IService <Security,String> {
    

    Set<Security> getAll ();

Set<Security> getAllStartingWithA();
}
