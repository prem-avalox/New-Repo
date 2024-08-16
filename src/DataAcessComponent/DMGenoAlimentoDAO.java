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

import DataAcessComponent.DTO.DMGenoAlimentoDTO;

public class DMGenoAlimentoDAO extends SQLiteDataHelper implements iDAO<DMGenoAlimentoDTO> {

    @Override
    public boolean create(DMGenoAlimentoDTO entity) throws Exception {
        String query = "INSERT INTO Catalogo (IdTipo, nombreCatalogo) VALUES (?,?)";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, 3); // IdTipo
            pstmt.setString(2, entity.getNombreCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    @Override
    public List<DMGenoAlimentoDTO> readAll() throws Exception {
        List<DMGenoAlimentoDTO> lst = new ArrayList<>();
        String query = "SELECT ROW_NUMBER() OVER (ORDER BY IdCatalogo) RowNum, IdCatalogo, IdTipo, nombreCatalogo, Estado, FechaCreacion, FechaModifica FROM Catalogo WHERE Estado = 'A' AND IdTipo = 3";
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DMGenoAlimentoDTO ga = new DMGenoAlimentoDTO(
                        rs.getInt(1), // RowNum
                        rs.getInt(2), // IdCatalogo
                        rs.getInt(3), // IdTipo
                        rs.getString(4), // nombreCatalogo
                        rs.getString(5), // Estado
                        rs.getString(6), // FechaCreacion
                        rs.getString(7) // FechaModifica
                );
                lst.add(ga);
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return lst;
    }

    @Override
    public boolean update(DMGenoAlimentoDTO entity) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String query = "UPDATE Catalogo SET nombreCatalogo = ?, FechaModifica = ? WHERE IdCatalogo = ?";
        try {
            Connection conn = openConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, entity.getNombreCatalogo());
            pstmt.setString(2, dtf.format(now).toString());
            pstmt.setInt(3, entity.getIdCatalogo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new SQLException();
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "UPDATE Catalogo SET Estado = ? WHERE IdCatalogo = ?";
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
    public DMGenoAlimentoDTO readBy(Integer id) throws Exception {
        DMGenoAlimentoDTO ga = new DMGenoAlimentoDTO();
        String query = "SELECT RowNum, IdCatalogo, IdTipo, nombreCatalogo, Estado, FechaCreacion, FechaModifica FROM (SELECT ROW_NUMBER() OVER (ORDER BY IdCatalogo) AS RowNum, IdCatalogo, IdTipo, nombreCatalogo, Estado, FechaCreacion, FechaModifica FROM Catalogo WHERE Estado = 'A' AND IdTipo = 3) sub WHERE RowNum = "
                + id.toString();
        try {
            Connection conn = openConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                ga = new DMGenoAlimentoDTO(
                        rs.getInt(1), // RowNum
                        rs.getInt(2), // IdCatalogo
                        rs.getInt(3), // IdTipo
                        rs.getString(4), // nombreCatalogo
                        rs.getString(5), // Estado
                        rs.getString(6), // FechaCreacion
                        rs.getString(7) // FechaModifica
                );
            }
        } catch (SQLException e) {
            throw new SQLException();
        }
        return ga;
    }
}