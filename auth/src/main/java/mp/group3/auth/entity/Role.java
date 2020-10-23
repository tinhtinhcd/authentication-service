package mp.group3.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseModel{

    private String name;
    private String description;
    private int lv;
    private List<Privilege> privileges;
}
