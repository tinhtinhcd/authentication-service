package mp.group3.auth.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BaseModel {

    private Long id ;
    private LocalDateTime createDate;

}
