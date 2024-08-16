package BusinessLogic;

import java.util.List;

import DataAcessComponent.DMAnimalDAO;
import DataAcessComponent.DTO.DMAnimalDTO;

public class DMAnimalBL {
    private DMAnimalDTO DMAnimal;
    private DMAnimalDAO dmAnimalDAO = new DMAnimalDAO();

    public DMAnimalBL(){}

    public  List<DMAnimalDTO> getAll() throws Exception{
        List<DMAnimalDTO> lst = dmAnimalDAO.readAll();
        // for (DMAnimalDTO DMAnimalDTO : lst) 
        //     DMAnimalDTO.setNombre(DMAnimalDTO.getNombre().toUpperCase());
        return lst;
    }
    public DMAnimalDTO getBy(int idDMAnimal) throws Exception{
        DMAnimal = dmAnimalDAO.readBy(idDMAnimal);
        return DMAnimal;
    }
    public boolean add(DMAnimalDTO DMAnimalDTO) throws Exception{   
        return dmAnimalDAO.create(DMAnimalDTO);
    }
    public boolean update(DMAnimalDTO DMAnimalDTO) throws Exception{
        return dmAnimalDAO.update(DMAnimalDTO);
    }
    public boolean delete(int idDMAnimal) throws Exception{
        return dmAnimalDAO.delete(idDMAnimal);
    }
    public Integer getRowCount() throws Exception{
        return dmAnimalDAO.getRowCount();
    }
}

