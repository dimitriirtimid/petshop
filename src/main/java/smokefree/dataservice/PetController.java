package smokefree.dataservice;


        import io.micronaut.http.annotation.Controller;
        import io.micronaut.http.annotation.Get;
        import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/book")
public class PetController {

    PetService bookService;

    public PetController(PetService petService) {
        this.bookService = petService;
    }

    @Get("/{title}")
    public String index(String title) {
        log.info("Petcontroller /title: " + title);
      return bookService.save(title);
//        return "hallo: " + title;
    }

}