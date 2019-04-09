package Component;

public class Token
{
    private String TokenName;
    private String TokenTiny;
    private String TokenRE;


    public Token()
    {

    }
    public Token(String tokenName, String tokenTiny, String tokenRE) {
        TokenName = tokenName;
        TokenTiny = tokenTiny;
        TokenRE = tokenRE;
    }

    public String getTokenName() {
        return TokenName;
    }

    public void setTokenName(String tokenName) {
        TokenName = tokenName;
    }

    public String getTokenTiny() {
        return TokenTiny;
    }

    public void setTokenTiny(String tokenTiny) {
        TokenTiny = tokenTiny;
    }

    public String getTokenRE() {
        return TokenRE;
    }

    public void setTokenRE(String tokenRE) {
        TokenRE = tokenRE;
    }
}
