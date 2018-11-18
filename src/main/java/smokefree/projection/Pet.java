package smokefree.projection;

import lombok.Value;
import lombok.experimental.Wither;
import smokefree.domain.Status;

@Value
@Wither
public class Pet {
    String id;
    String name;
    String type;
}
