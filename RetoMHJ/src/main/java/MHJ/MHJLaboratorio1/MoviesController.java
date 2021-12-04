package MHJ.MHJLaboratorio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class MoviesController {
    public static ArrayList<Movies> movies = new ArrayList(Arrays.asList(

            new Movies(1, "High School Musical", 2006, "Musica para jovenes", "Musical"),
            new Movies(2, "Burlesque", 2010, "Musica para adultos", "Musical"),
            new Movies(3, "Superman", 1978, "Thriller superheroes", "Aventuras"),
            new Movies(4, "Solo en Casa", 1990, "Pelicula que te hara llorar de la risa", "Familiar"),
            new Movies(5, "Sé lo que hicisteis el último verano", 1997, "Miedo asegurado", "Miedo"),
            new Movies(6, "Astartes", 2021,
                    "Los Marines Espaciales hacen pew pew a los aliens y win-win, buena calidad", "Accion"),
            new Movies(7, "Los chicos del Maiz", 2009, "Obreros hasta el fin", "Miedo"),
            new Movies(8, "Black Widow", 2021,

                    "Natasha Romanoff, alias Viuda Negra, se enfrenta a los capítulos más oscuros de su historia",
                    "Accion")));

    public static ArrayList<Movies> moviesMyList = new ArrayList(Arrays.asList(
        ));

    @GetMapping("MoviesMyList")
    public List <Movies> GetMoviesMyList(){
        return moviesMyList;
    }
                   
    @GetMapping("Movies")
    public List<Movies> GetMovies() {
        return movies;
    }

    @GetMapping("Movies/{id}")
    public static Movies MovieById(@PathVariable("id") int id) {
        return FindMovieByID(id);
    }

    @GetMapping("Movies/title/{title}")
    public Movies movieByTitle(@PathVariable("title") String title) {
        return FindMovieByTitle(title);
    }

    @GetMapping("Movies/year/{year}")
    public Movies MovieByYear(@PathVariable("year") int year) {
        return FindMovieByYear(year);
    }

    public static Movies FindMovieByID(int id) {
        for (Movies movie : movies) {
            if (movie.getId() == id) {
                return movie;
            }
        }
        throw new ElementNotFoundException();
    }

    private Movies FindMovieByTitle(String title) {
        for (Movies movie : movies) {
            if (movie.getTitle().contains(title)) {
                return movie;
            }
        }
        throw new ElementNotFoundException();
    }

    private Movies FindMovieByYear(int year) {
        for (Movies movie : movies) {
            if (movie.getYear() == year) {
                return movie;
            }

        }
        throw new ElementNotFoundException();
    }

    @PostMapping("/Movies")
    public Movies AddMovie(@RequestBody Movies newMovie) {
        movies.add(newMovie);
        return newMovie;
    }

    @PutMapping("/Movies/{id}")
    public Movies UpdateMovie(@PathVariable("id") int id, @RequestBody Movies updateMovie)throws Exception {
        Movies m = FindMovieByID(id);
        m.setTitle(updateMovie.getTitle());
        return m;
    }

    @DeleteMapping("/Movies/{id}")
    public Movies DeleteMovie(@PathVariable("id") int id) throws Exception {
        Movies m = FindMovieByID(id);
        movies.remove(m);
        return null;
    }

}