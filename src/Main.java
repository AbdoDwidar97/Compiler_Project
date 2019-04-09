import Component.tinyCompiler;
import Settings.Feature;

public class Main
{
    public static void main(String [] args)
    {
        String stream =  Feature.Read_Code("/home/dwidar/IdeaProjects/CompilerProject/src/Settings/iCode.txt");

        tinyCompiler tiny_Compiler = new tinyCompiler(stream);

        tiny_Compiler.Print_Tokenized();
        //tiny_Compiler.Print_Tokens();

    }
}
