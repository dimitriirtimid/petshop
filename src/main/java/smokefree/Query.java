package smokefree;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import smokefree.projection.InitiativeProjection;
import smokefree.projection.Pet;
import smokefree.projection.Playground;
import smokefree.projection.Progress;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Singleton
@NoArgsConstructor
public class Query implements GraphQLQueryResolver {
    @Inject
    InitiativeProjection projection;

    public Collection<Playground> playgrounds() {
        return projection.playgrounds();
    }

    public Progress progress() {
        return projection.progress();
    }

//    public int add(AdditionInput input) {
//        return input.getFirst() + input.getSecond();
//    }

    public Collection<Pet> pets() {
        final List<Pet> result = new ArrayList<>();
        result.add(new Pet("pet001", "Bertha", "Goldfish"));
        result.add(new Pet("pet002", "Beertha", "Horse"));
        return result;
    }
}