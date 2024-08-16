package DataAcessComponent.DTO;

public class DMGenoAlimentoDTO {
    private Integer RowNum ;
    private Integer idCatalogo;
    private Integer idTipo;
    private String nombreCatalogo;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;
    public DMGenoAlimentoDTO() {
    }
    public DMGenoAlimentoDTO(Integer rowNum, Integer idCatalogo, Integer idTipo, String nombreCatalogo, String estado,
            String fechaCreacion, String fechaModifica) {
        RowNum = rowNum;
        this.idCatalogo = idCatalogo;
        this.idTipo = idTipo;
        this.nombreCatalogo = nombreCatalogo;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }
    public Integer getRowNum() {
        return RowNum;
    }
    public void setRowNum(Integer rowNum) {
        RowNum = rowNum;
    }
    public Integer getIdCatalogo() {
        return idCatalogo;
    }
    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
    public Integer getIdTipo() {
        return idTipo;
    }
    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }
    public String getNombreCatalogo() {
        return nombreCatalogo;
    }
    public void setNombreCatalogo(String nombreCatalogo) {
        this.nombreCatalogo = nombreCatalogo;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }
    public String getFechaCreacion() {
        return FechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        FechaCreacion = fechaCreacion;
    }
    public String getFechaModifica() {
        return FechaModifica;
    }
    public void setFechaModifica(String fechaModifica) {
        FechaModifica = fechaModifica;
    }
}
