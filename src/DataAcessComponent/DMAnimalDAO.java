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
            pstmt.setInt(4, entity.getIdCatalogoSexo());
            pstmt.setInt(5, entity.getIdCatalogoClasificacion());
            pstmt.setInt(6, entity.getIdCatalogoGenoAlimento());
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
        String query = "SELECT idAnimal, nombre, nombreCientifico, idCatalogoSexo, idCatalogoClasificacion, idCatalogoGenoAlimento, Estado, FechaCreacion, FechaModifica FROM DMAnimal WHERE Estado = 'A'";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DMAnimalDTO animal = new DMAnimalDTO(
                        rs.getInt(1), // idAnimal
                        rs.getString(2), // nombre
                        rs.getString(3), // nombreCientifico
                        rs.getInt(4), // idCatalogoSexo
                        rs.getInt(5), // idCatalogoClasificacion
                        rs.getInt(6), // idCatalogoGenoAlimento
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
            pstmt.setInt(3, entity.getIdCatalogoSexo());
            pstmt.setInt(4, entity.getIdCatalogoClasificacion());
            pstmt.setInt(5, entity.getIdCatalogoGenoAlimento());
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
                        rs.getInt(4), // idCatalogoSexo
                        rs.getInt(5), // idCatalogoClasificacion
                        rs.getInt(6), // idCatalogoGenoAlimento
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