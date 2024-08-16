package DataAcessComponent.DTO;

public class DMAnimalDTO {
    private Integer idAnimal;
    private String nombre;
    private String nombreCientifico;
    private Integer idCatalogoSexo;
    private Integer idCatalogoClasificacion;
    private Integer idCatalogoGenoAlimento;
    private String Estado;
    private String FechaCreacion;
    private String FechaModifica;

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public Integer getIdCatalogoSexo() {
        return idCatalogoSexo;
    }

    public void setIdCatalogoSexo(Integer idCatalogoSexo) {
        this.idCatalogoSexo = idCatalogoSexo;
    }

    public Integer getIdCatalogoClasificacion() {
        return idCatalogoClasificacion;
    }

    public void setIdCatalogoClasificacion(Integer idCatalogoClasificacion) {
        this.idCatalogoClasificacion = idCatalogoClasificacion;
    }

    public Integer getIdCatalogoGenoAlimento() {
        return idCatalogoGenoAlimento;
    }

    public void setIdCatalogoGenoAlimento(Integer idCatalogoGenoAlimento) {
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
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

    public DMAnimalDTO(Integer idAnimal, String nombre, String nombreCientifico, Integer idCatalogoSexo,
            Integer idCatalogoClasificacion, Integer idCatalogoGenoAlimento, String estado, String fechaCreacion,
            String fechaModifica) {
        this.idAnimal = idAnimal;
        this.nombre = nombre;
        this.nombreCientifico = nombreCientifico;
        this.idCatalogoSexo = idCatalogoSexo;
        this.idCatalogoClasificacion = idCatalogoClasificacion;
        this.idCatalogoGenoAlimento = idCatalogoGenoAlimento;
        Estado = estado;
        FechaCreacion = fechaCreacion;
        FechaModifica = fechaModifica;
    }

    public DMAnimalDTO() {
    }

    @Override
    public String toString() {
        return "DMAnimalDTO ["
                + "\n idAnimal       " + getIdAnimal()
                + "\n nombre         " + getNombre()
                + "\n nombreCientifico " + getNombreCientifico()
                + "\n idCatalogoSexo  " + getIdCatalogoSexo()
                + "\n idCatalogoClasificacion " + getIdCatalogoClasificacion()
                + "\n idCatalogoGenoAlimento " + getIdCatalogoGenoAlimento()
                + "\n Estado         " + getEstado()
                + "\n FechaCreacion  " + getFechaCreacion()
                + "\n FechaModifica  " + getFechaModifica()
                + "]\n";
    }

}
