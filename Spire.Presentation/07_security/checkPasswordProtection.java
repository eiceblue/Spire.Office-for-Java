import com.spire.presentation.*;

public class checkPasswordProtection {
    public static void main(String[] args) throws Exception {
        String input="data/template_Ppt_4.pptx";

        //Create a PPT document
        Presentation ppt = new Presentation();

        //Check whether a PPT document is protected with password 
        boolean password =ppt.isPasswordProtected(input);
        System.out.println(password);
    }
}
