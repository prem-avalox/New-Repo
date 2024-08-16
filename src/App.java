import DataAcessComponent.DMAnimalDAO;
import DataAcessComponent.DTO.DMAnimalDTO;
import UserInterface.Forms.DMMainForm;

public class App {
    public static void main(String[] args) throws Exception {

       new DMMainForm("EcuFauna");
        
        // // s.setIdSexo(3);
        // // s.setNombre("Hibrido");
        // // s.setFechaModifica("2023-05-18 17:39:46");
        // // SexoDAO oS = new SexoDAO();
        // // // oS.create(s);
        // // oS.update(s);
        // // System.out.println(oS.readBy(3).toString());
        // // System.out.println( s.getNombre() + " " + s.getFechaCrea() );
        
        // DMAnimalDAO as = new DMAnimalDAO();
        // for (DMAnimalDTO s : as.readAll()) {
        // System.out.println(s.toString());
        // }
        // // SexoBL sBl = new SexoBL();
        // // sBl.update(5, "Macho Alpha");
        // // sBl.delete(5);
        // // for (SexoDTO s : sBl.getAll()) {
        // // System.out.println(s.toString());
        // // }

    }
}
