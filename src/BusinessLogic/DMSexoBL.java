package BusinessLogic;

import java.util.List;

import DataAcessComponent.DMSexoDAO;
import DataAcessComponent.DTO.DMSexoDTO;

public class DMSexoBL {
    private DMSexoDTO DMSexo;
    private DMSexoDAO dmSexoDAO = new DMSexoDAO();

    public DMSexoBL(){}

    public List<DMSexoDTO> getAll() throws Exception{
        List<DMSexoDTO> lst = dmSexoDAO.readAll();
        return lst;
    }

    public DMSexoDTO getBy(int idDMSexo) throws Exception{
        DMSexo = dmSexoDAO.readBy(idDMSexo);
        return DMSexo;
    }

    public boolean add(DMSexoDTO DMSexoDTO) throws Exception{   
        return dmSexoDAO.create(DMSexoDTO);
    }

    public boolean update(DMSexoDTO DMSexoDTO) throws Exception{
        return dmSexoDAO.update(DMSexoDTO);
    }

    public boolean delete(int idDMSexo) throws Exception{
        return dmSexoDAO.delete(idDMSexo);
    }

}