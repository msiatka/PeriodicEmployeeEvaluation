package hr.ocenaokresowa.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class QuestionnaireService {

//    Questionnaires questionnaires;

    public boolean isAdmin(UserDetails userDetails){
        Set<GrantedAuthority> authorities = (Set<GrantedAuthority>) userDetails.getAuthorities();
        if(authorities.toString().contains("ROLE_ADMIN")){
            return true;
        }
        return false;
    }
}
