package MHJ.MHJLaboratorio1;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

public class MyListMoviesController {
    public static ArrayList<Movies> myListOfMovies = new ArrayList(Arrays.asList());

    @GetMapping("/myList")
    public ArrayList<Movies> getAll() {
        return myListOfMovies;
    }

    @PostMapping("/myList/")
    public Movies add(@RequestBody Movies newMovie) {
        myListOfMovies.add(newMovie);
        return newMovie;
    }

    @DeleteMapping("/myList/{id}")
    public Movies DeleteMovieFromList(@PathVariable("id") int id) {
        myListOfMovies.remove(id);
        return null;
    }

    public static Movies DeleteMovieFromList(@RequestBody Movies deleMovie,
            @RequestParam(name = "id", required = true) int id) {
        Movies m = FindMovieByID(id);
        myListOfMovies.remove(m);
        return m;
    }

    public static Movies FindMovieByID(int id) {
        for (Movies m : myListOfMovies) {
            if (m.getId() == id) {
                return m;
            }
        }
        throw new ElementNotFoundException();
    }
}
