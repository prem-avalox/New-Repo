package BusinessLogic;

import java.util.List;

import DataAcessComponent.DMClasificacionDAO;
import DataAcessComponent.DTO.DMClasificacionDTO;

public class DMClasificacionBL {
    private DMClasificacionDTO DMClasificacion;
    private DMClasificacionDAO dmClasificacionDAO = new DMClasificacionDAO();

    public DMClasificacionBL(){}

    public List<DMClasificacionDTO> getAll() throws Exception{
        List<DMClasificacionDTO> lst = dmClasificacionDAO.readAll();
        return lst;
    }

    public DMClasificacionDTO getBy(int idDMClasificacion) throws Exception{
        DMClasificacion = dmClasificacionDAO.readBy(idDMClasificacion);
        return DMClasificacion;
    }

    public boolean add(DMClasificacionDTO DMClasificacionDTO) throws Exception{   
        return dmClasificacionDAO.create(DMClasificacionDTO);
    }

    public boolean update(DMClasificacionDTO DMClasificacionDTO) throws Exception{
        return dmClasificacionDAO.update(DMClasificacionDTO);
    }

    public boolean delete(int idDMClasificacion) throws Exception{
        return dmClasificacionDAO.delete(idDMClasificacion);
    }

  
    
}