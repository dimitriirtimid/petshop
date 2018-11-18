package smokefree.graphql;

import lombok.SneakyThrows;
import lombok.Value;

import java.util.concurrent.CompletableFuture;

@Value
public class PetResponse {
    String petId;
    String type;
    String name;

//    @SneakyThrows
//    public static PetResponse fromFuture(CompletableFuture<String> result) {
//        final String guid = result.get();
//        return new PetResponse(guid);
//    }
}
