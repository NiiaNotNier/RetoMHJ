package MHJ.MHJLaboratorio1;

import java.util.ArrayList;

import net.bytebuddy.asm.Advice.Return;

public class Mylist {
    public ArrayList<Movies> myListMovies;

    public Mylist() {
        this.myListMovies = new ArrayList<Movies>();

    }

    public ArrayList<Movies> getMovieList() {
        return myListMovies;
    }

    public boolean contains(Movies movie) {
        for (Movies m : myListMovies) {
            if (m.getId() == movie.getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean add(Movies movie) {
        if (!contains(movie)) {
            this.myListMovies.add(movie);
            return true;
        }
        return false;
    }

    public boolean remove(Movies movie) {
        if (contains(movie)) {
            this.myListMovies.remove(movie);
            return true;
        }
        return false;
    }

}
