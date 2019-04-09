package Settings;

import Component.Token;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Feature
{
    public static ArrayList<Token> get_tokens(){
        ArrayList<Token> tokens = new ArrayList<>();

        BufferedReader br_tokens = null;
        BufferedReader br_token_tiny_c = null;
        BufferedReader br_token_re = null;

        try
        {
            br_tokens = new BufferedReader(new FileReader("/home/dwidar/IdeaProjects/CompilerProject/src/Settings/tokens.txt"));
            br_token_tiny_c = new BufferedReader(new FileReader("/home/dwidar/IdeaProjects/CompilerProject/src/Settings/tokens_Tiny_C.txt"));
            br_token_re = new BufferedReader(new FileReader("/home/dwidar/IdeaProjects/CompilerProject/src/Settings/tokens_re.txt"));

            String tokens_line;
            String tokens_Tiny_C_line2;
            String tokens_re_line3;
            while ((tokens_line = br_tokens.readLine()) != null && (tokens_Tiny_C_line2 = br_token_tiny_c.readLine()) != null && (tokens_re_line3 = br_token_re.readLine()) != null)
            {
                Token newToken = new Token(tokens_line, tokens_Tiny_C_line2, tokens_re_line3);
                tokens.add(newToken);
            }

            return tokens;

        }catch (Exception e)
        {

        }

        return tokens;
    }



    public static String Read_Code(String path){

        String stream = "";
        BufferedReader br_Code = null;

        try
        {
            br_Code = new BufferedReader(new FileReader(path));

            String code_line;
            while ((code_line = br_Code.readLine()) != null)
            {
                stream += code_line;
                stream += '\n';
            }

            return stream;

        }catch (Exception e)
        {

        }

        return stream;
    }
}
