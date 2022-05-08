import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SADIC
 */
public class Composite implements Department{
    private List<Department> depList;
    
    public Composite(){
        this.depList = new ArrayList(); 
    }
    
    public void getDepName(){
        for(Department dep:depList){
            dep.getDepName();
        }
    }
    
    public void addDep(Department dep){
        depList.add(dep);
    }
    
    
    public void removeDep(Department dep){
        depList.remove(dep);
    }
}
