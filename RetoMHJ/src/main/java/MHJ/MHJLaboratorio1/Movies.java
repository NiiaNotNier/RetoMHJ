package MHJ.MHJLaboratorio1;

public class Movies {
    public int id;
    public String title;
    public int year;
    public String description;
    public String tipoPelicula;

    public Movies(int id, String title, int year, String description, String tipoPelicula) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.description = description;
        this.tipoPelicula = tipoPelicula;
    }

    public Movies() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTipoPelicula() {
        return tipoPelicula;
    }

    public void setTipoPelicula(String tipoPelicula) {
        this.tipoPelicula = tipoPelicula;
    }
}
