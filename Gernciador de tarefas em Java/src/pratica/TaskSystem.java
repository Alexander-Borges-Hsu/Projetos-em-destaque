package pratica;

import java.util.ArrayList;

public class TaskSystem {
    
    ArrayList<Task> allTasks = new ArrayList<Task>();
    public TaskSystem(){}
    
    public void addTask(Task task){   
        allTasks.add(task);
    }
    
   
    public void delTask(int id){
        boolean found = false;
        for (Task task : allTasks) {
            if (task.getId() == id) {
                allTasks.remove(task);
                System.out.println("Tarefa com ID " + id + " removida com sucesso!");
                found = true;
                break;
            }
            }
        
        if(!found){
            System.out.println("Tarefa com ID " + id + " nao encontrada.");
        }
    }
        
    public void completedTask(int id){
        boolean found = false;
        for (Task task : allTasks) {
            if (task.getId() == id) {
                
                task.setCompleted(true);
                
                System.out.println("Tarefa com ID " + id + " atualizada para completada!");
                found = true;
                break;
            }
            }
        
        if(!found){
            System.out.println("Tarefa com ID " + id + " nao encontrada.");
        }
    }
    
    public void unCompletedTask(int id){
        boolean found = false;
        for (Task task : allTasks) {
            if (task.getId() == id) {
                
                task.setCompleted(false);
                
                System.out.println("Tarefa com ID " + id + " atualizada para incompleta!");
                found = true;
                break;
            }
            }
        
        if(!found){
            System.out.println("Tarefa com ID " + id + " nao encontrada.");
        }
    }
    
    public void print(){
        for(Task task : allTasks){
            System.out.println(task);
        }
    }
    
 
}
