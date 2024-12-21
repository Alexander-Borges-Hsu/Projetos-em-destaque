package pratica;


public class Task {

    private int id;
    private String title;
    private String description;
    private boolean completed;
    
    public Task(int id, String title, String description, boolean completed){
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }
    
    @Override
    public String toString() {
        return "TAREFA: ID: " + id +
               ", Titulo: " + title +
               ", Descricao: " + description +
               ", Concluido: " + (completed ? "Sim" : "Nao");
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    
}

