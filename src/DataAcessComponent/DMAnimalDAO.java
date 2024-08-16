package DataAcessComponent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import DataAcessComponent.DTO.DMAnimalDTO;



public class DMAnimalDAO extends SQLiteDataHelper implements iDAO<DMAnimalDTO> {

    @Override
    public boolean create(DMAnimalDTO entity) throws Exception {
        String query = "INSERT INTO DMAnimal (idAnimal, nombre, nombreCientifico, idCatalogoSexo, idCatalogoClasificacion, idCatalogoGenoAlimento, Estado, FechaCreacion, FechaModifica) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, entity.getIdAnimal());
            pstmt.setString(2, entity.getNombre());
            pstmt.setString(3, entity.getNombreCientifico());
            pstmt.setString(4, entity.getIdCatalogoSexo());
            pstmt.setString(5, entity.getIdCatalogoClasificacion());
            pstmt.setString(6, entity.getIdCatalogoGenoAlimento());
            pstmt.setString(7, entity.getEstado());
            pstmt.setString(8, entity.getFechaCreacion());
            pstmt.setString(9, entity.getFechaModifica());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
           throw new SQLException();
        }
    }

    @Override
    public List<DMAnimalDTO> readAll() throws Exception {
        List<DMAnimalDTO> lst = new ArrayList<>();
        String query = "SELECT \n" + //
                        "  a.idAnimal,\n" + //
                        "  a.nombre,\n" + //
                        "  a.nombreCientifico,\n" + //
                        "  s.nombreCatalogo AS sexo,\n" + //
                        "  c.nombreCatalogo AS clasificacion,\n" + //
                        "  g.nombreCatalogo AS genoAlimento,\n" + //
                        "  a.Estado,\n" + //
                        "  a.FechaCreacion,\n" + //
                        "  a.FechaModifica\n" + //
                        "FROM \n" + //
                        "  DMAnimal a\n" + //
                        "  INNER JOIN DMCatalogo s ON a.idCatalogoSexo = s.idCatalogo\n" + //
                        "  INNER JOIN DMCatalogo c ON a.idCatalogoClasificacion = c.idCatalogo\n" + //
                        "  INNER JOIN DMCatalogo g ON a.idCatalogoGenoAlimento = g.idCatalogo\n" + //
                        "WHERE \n" + //
                        "  a.Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DMAnimalDTO animal = new DMAnimalDTO(
                        rs.getInt(1), // idAnimal
                        rs.getString(2), // nombre
                        rs.getString(3), // nombreCientifico
                        rs.getString(4), // idCatalogoSexo
                        rs.getString(5), // idCatalogoClasificacion
                        rs.getString(6), // idCatalogoGenoAlimento
                        rs.getString(7), // Estado
                        rs.getString(8), // FechaCreacion
                        rs.getString(9) // FechaModifica
                );
                lst.add(animal);
            }
        } catch (SQLException e) {
            
        }
        return lst;
    }

    @Override
    public boolean update(DMAnimalDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE DMAnimal SET nombre = ?, nombreCientifico = ?, idCatalogoSexo = ?, idCatalogoClasificacion = ?, idCatalogoGenoAlimento = ?, Estado = ?, FechaModifica = ? WHERE idAnimal = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombre());
            pstmt.setString(2, entity.getNombreCientifico());
            pstmt.setString(3, entity.getIdCatalogoSexo());
            pstmt.setString(4, entity.getIdCatalogoClasificacion());
            pstmt.setString(5, entity.getIdCatalogoGenoAlimento());
            pstmt.setString(6, entity.getEstado());
            pstmt.setString(7, dtf.format(now).toString());
            pstmt.setInt(8, entity.getIdAnimal());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE DMAnimal SET Estado = ? WHERE idAnimal = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "X");
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException(); 
        }
    }

    @Override
    public DMAnimalDTO readBy(Integer id) throws Exception {
        DMAnimalDTO animal = new DMAnimalDTO();
        String query = "SELECT idAnimal, nombre, nombreCientifico, idCatalogoSexo, idCatalogoClasificacion, idCatalogoGenoAlimento, Estado, FechaCreacion, FechaModifica FROM DMAnimal WHERE idAnimal = ? AND Estado = 'A'";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                animal = new DMAnimalDTO(
                        rs.getInt(1), // idAnimal
                        rs.getString(2), // nombre
                        rs.getString(3), // nombreCientifico
                        rs.getString(4), // idCatalogoSexo
                        rs.getString(5), // idCatalogoClasificacion
                        rs.getString(6), // idCatalogoGenoAlimento
                        rs.getString(7), // Estado
                        rs.getString(8), // FechaCreacion
                        rs.getString(9) // FechaModifica
                );
            }
        } catch (SQLException e) {
            
        }
        return animal;
    }

    public Integer getRowCount() throws Exception {
        String query = "SELECT COUNT(*) TotalReg FROM DMAnimal WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return rs.getInt(1); // TotalReg
            }
        } catch (SQLException e) {
            
        }
        return 0;
    }

}