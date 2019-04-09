package Component;

import Settings.Feature;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lexical_Analyzer
{
    private ArrayList<Token> tokens;
    private String stream;

    public ArrayList<Token> getTokens()
    {
        return tokens;
    }

    public Lexical_Analyzer()
    {
        tokens = new ArrayList<>();
        tokens = Feature.get_tokens();
    }

    public Lexical_Analyzer(String stream)
    {
        this.stream = stream;
        tokens = new ArrayList<>();
        tokens = Feature.get_tokens();
    }


    public ArrayList<TokenizedToken> Tokenize()
    {
        ArrayList<TokenizedToken> tokenizedStream = new ArrayList<>();

        for (Token itr : this.tokens)
        {
            ArrayList<TokenizedToken> newTokenized = RegexChecker(itr);
            if (newTokenized.size() != 0) tokenizedStream.addAll(newTokenized);
        }

        tokenizedStream = OrderTokens(tokenizedStream);
        return tokenizedStream;
    }


    private ArrayList<TokenizedToken> RegexChecker(Token tkn)
    {
        ArrayList<TokenizedToken> listOfTokenized = new ArrayList<>();

        Pattern checkRegex = Pattern.compile(tkn.getTokenRE());
        Matcher RegexMatcher = checkRegex.matcher(stream);

        while (RegexMatcher.find())
        {
            if (RegexMatcher.group().length() != 0)
            {
                TokenizedToken newOne = new TokenizedToken();
                newOne.setTokenName("<" + tkn.getTokenName() + ">");
                newOne.setToken(RegexMatcher.group().trim());
                newOne.setIndex(RegexMatcher.start());

                StringBuffer sb = new StringBuffer();
                sb.append(stream);
                String bfr = "";
                for (int si = 0; si < (RegexMatcher.end() - RegexMatcher.start()); si++) bfr += ' ';
                sb.replace(RegexMatcher.start(),RegexMatcher.end(),bfr);
                //sb.delete(RegexMatcher.start(),RegexMatcher.end());
                stream = sb.toString();

                listOfTokenized.add(newOne);
            }
        }

        return listOfTokenized;
    }

    private ArrayList<TokenizedToken> OrderTokens(ArrayList<TokenizedToken> tokenized_token)
    {

        int idx = tokenized_token.size() - 1;
        for (int i = idx; i > 0; i--)
        {
            for (int j = idx; j > 0; j--)
            {
                if (tokenized_token.get(j).getIndex() < tokenized_token.get(j - 1).getIndex())
                {
                    TokenizedToken right_token = tokenized_token.get(j); // = j
                    TokenizedToken left_token = tokenized_token.get(j - 1); // j - 1

                    tokenized_token.set(j - 1,right_token);
                    tokenized_token.set(j,left_token);
                }
            }
        }

        return tokenized_token;
    }

}
