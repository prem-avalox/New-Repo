package BusinessLogic;

import java.util.List;

import DataAcessComponent.DMGenoAlimentoDAO;
import DataAcessComponent.DTO.DMGenoAlimentoDTO;

public class DMGenoAlimentoBL {
    private DMGenoAlimentoDTO DMGenoAlimento;
    private DMGenoAlimentoDAO dmGenoAlimentoDAO = new DMGenoAlimentoDAO();

    public DMGenoAlimentoBL(){}

    public List<DMGenoAlimentoDTO> getAll() throws Exception{
        List<DMGenoAlimentoDTO> lst = dmGenoAlimentoDAO.readAll();
        return lst;
    }

    public DMGenoAlimentoDTO getBy(int idDMGenoAlimento) throws Exception{
        DMGenoAlimento = dmGenoAlimentoDAO.readBy(idDMGenoAlimento);
        return DMGenoAlimento;
    }

    public boolean add(DMGenoAlimentoDTO DMGenoAlimentoDTO) throws Exception{   
        return dmGenoAlimentoDAO.create(DMGenoAlimentoDTO);
    }

    public boolean update(DMGenoAlimentoDTO DMGenoAlimentoDTO) throws Exception{
        return dmGenoAlimentoDAO.update(DMGenoAlimentoDTO);
    }

    public boolean delete(int idDMGenoAlimento) throws Exception{
        return dmGenoAlimentoDAO.delete(idDMGenoAlimento);
    }

}