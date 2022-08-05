package yte.intern.springapplication.authentication.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import yte.intern.springapplication.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Authority extends BaseEntity implements GrantedAuthority {

    private String authority;

    @ManyToMany(mappedBy = "authorities")
    public List<Users> users = new ArrayList<>();


    public Authority(String authority) {
        this.authority = authority;
    }
}
