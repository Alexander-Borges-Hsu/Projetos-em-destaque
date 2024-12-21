package pratica;

import javax.swing.JOptionPane;
public class Pratica {
    public static void main(String[] args){
        
    TaskSystem sendTask = new TaskSystem();
    int nextId = 1;
    String option;
    int optionNum = 0;
    
    while(optionNum != 5){
    option = JOptionPane.showInputDialog("1. Adicionar Tarefa \n" + "2. Remover Tarefa \n" + "3. "
            + "Mudar situacao da tarefa \n" + "4. Listar todas as tarefas \n" + "5. Sair");

    
    if (option == null) {
        JOptionPane.showMessageDialog(null, "Encerrando o programa.");
        break; 
    }
    
    try{
        optionNum = Integer.parseInt(option);
        
        switch(optionNum){
            case 1:        
                String title;
                String description;
                String completed;
                int completedN;
                boolean completedB = false;
        
                title = JOptionPane.showInputDialog("De o título para a tarefa.");
                description = JOptionPane.showInputDialog("De uma descrição para a tarefa.");
                completed = JOptionPane.showInputDialog("A tarefa está completa? 1 para Sim. 2 para Não.");
                completedN = Integer.parseInt(completed);
                
                switch(completedN){
                    case 1: 
                        completedB = true;
                    break;
                    case 2:
                        completedB = false;
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                }
                
                Task newTask = new Task(nextId, title, description, completedB);
                if (completedN == 1){
                    sendTask.addTask(newTask);
                }else if(completedN == 2){
                    sendTask.addTask(newTask);
                }
                //Enviar o objeto ao ArrayList
                
                
                nextId++;
            break;
            case 2:
                String idToDel;
                int idToDelN;
                idToDel = JOptionPane.showInputDialog("Passe o Id da tarefa que deseja excluir.");
                idToDelN = Integer.parseInt(idToDel);
                sendTask.delTask(idToDelN);
            break;
            case 3:
                String optionC3;
                int optionC3N;
                optionC3 = JOptionPane.showInputDialog("1. Marcar tarefa como concluida \n" +
                        "2. Marcar tarefa como incompleta");
                
                optionC3N = Integer.parseInt(optionC3);
                
                switch(optionC3N){
                    case 1:
                        String idToComplete;
                        int idToCompleteN;
                        idToComplete = JOptionPane.showInputDialog("Passe o Id da tarefa que deseja atualizar para completa.");
                        idToCompleteN = Integer.parseInt(idToComplete);
                        sendTask.completedTask(idToCompleteN);
                    break;
                    case 2:
                        String idToUncompleted;
                        int idToUncompletedN;
                        idToUncompleted = JOptionPane.showInputDialog("Passe o Id da tarefa que deseja ataualizar para incompleta.");
                        idToUncompletedN = Integer.parseInt(idToUncompleted);
                        sendTask.unCompletedTask(idToUncompletedN);
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                    break;    
                }
            break;    
            case 4:
                sendTask.print();
            break;
            case 5:
                JOptionPane.showMessageDialog(null, "Encerrando o programa.");
            break;    
            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
            break;
        }
        }catch (NumberFormatException e) {
                // Captura entradas que não são números
                JOptionPane.showMessageDialog(null, "Entrada inválida. Digite um número inteiro.");
    }
    }
    }
}
