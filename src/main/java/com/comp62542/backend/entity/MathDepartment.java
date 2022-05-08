public class MathDepartment implements Department{
    private String name;
    
    public MathDepartment(String name) {
        this.name = name;
    }
    
    public void getDepName(){
        System.out.println(this.name);
    }
}
