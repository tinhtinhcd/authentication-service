package mp.group3.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseModel{

    private String username;
    private String password;
    private String status;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Role> roles;
}
