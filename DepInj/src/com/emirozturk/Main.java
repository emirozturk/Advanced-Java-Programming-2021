package com.emirozturk;
interface Tool{

}
class Tool1 implements Tool{
    public Tool1(String dbPath){

    }
}
class Tool2 implements Tool{
    public Tool2(){

    }
}
class Tool3 implements Tool{
    public Tool3(){

    }
}
class ToolSecici{
    Tool tool;
    public ToolSecici(Tool tool){
        this.tool = tool;
    }
}
public class Main {
    public static void main(String[] args) {
        Tool1 yeniTool = new Tool1("asdasd");
        Tool2 yeniikinciTool = new Tool2();
        ToolSecici secici = new ToolSecici(yeniTool);
        ToolSecici secici2 = new ToolSecici(yeniikinciTool);
    }
}
