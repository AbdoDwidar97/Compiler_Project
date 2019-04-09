package Component;

import java.util.ArrayList;

public class tinyCompiler
{
    private Lexical_Analyzer lexical_analyzer;

    public tinyCompiler(){}

    public tinyCompiler(String stream)
    {
        lexical_analyzer = new Lexical_Analyzer(stream);
    }

    public void Print_Tokens()
    {
        ArrayList<Token> lex =  lexical_analyzer.getTokens();
        for (Token itr : lex) System.out.println(itr.getTokenName() + " , " + itr.getTokenTiny() + " , " + itr.getTokenRE());
    }

    public void Print_Tokenized()
    {
        ArrayList<TokenizedToken> tokenized = lexical_analyzer.Tokenize();
        for (TokenizedToken itr : tokenized) System.out.println(itr.getTokenName() + ":" + itr.getToken());
    }
}
