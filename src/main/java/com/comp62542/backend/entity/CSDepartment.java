public class CSDepartment implements Department{
    private String name;
    
    public CSDepartment(String name) {
        this.name = name;
    }
    
    public void getDepName(){
        System.out.println(this.name);
    }
}
