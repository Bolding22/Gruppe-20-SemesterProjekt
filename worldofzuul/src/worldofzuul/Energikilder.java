package worldofzuul;

/**
 *
 * @author wbold
 */
public class Energikilder {
   private boolean solar;
   private boolean traditionalBiomass;
   
   public Energikilder(){
       solar = false;
       traditionalBiomass = false;
      
   }

    public boolean isSolar() {
        return solar;
    }

    public boolean isTraditionalBiomass() {
        return traditionalBiomass;
    }

    public void setSolar(boolean solar) {
        this.solar = solar;
    }

    public void setTraditionalBiomass(boolean traditionalBiomass) {
        this.traditionalBiomass = traditionalBiomass;
    }
   
}
