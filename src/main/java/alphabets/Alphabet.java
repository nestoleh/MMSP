package alphabets;

/**
 * Created by Oleg on 15.11.2015.
 */
public enum Alphabet {
    SMALL_ENGLISH {
        private String smallAlphabet = "abcdefghi";
        private String   bigAlphabet = "ABCDEFGHI";

        public int size() {
            return smallAlphabet.length();
        }

        public String getSmallAlphabet(){
            return smallAlphabet;
        }

        public String getBigAlphabet(){
            return bigAlphabet;
        }
    };

    public abstract int size();
    public abstract String getSmallAlphabet();
    public abstract String getBigAlphabet();

}
