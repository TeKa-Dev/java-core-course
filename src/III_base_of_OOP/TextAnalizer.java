package III_base_of_OOP;

interface TextAnalyzer { Label processText(String text);}

enum Label { SPAM, NEGATIVE_TEXT, TOO_LONG, OK }

class Main {






public Label checkLabels(TextAnalyzer[] analyzers, String text) {
    for (TextAnalyzer ta: analyzers) {
        if (ta.processText(text) != Label.OK) {
            return ta.processText(text);
        }
    }
    return Label.OK;
}

public abstract static class KeywordAnalyzer implements TextAnalyzer {

    @Override
    public Label processText(String text) {
        for (String keyword: getKeywords()) {
            if(text.contains(keyword)) {
                return getLabel();
            }
        }
        return Label.OK;
    }

    protected abstract String[] getKeywords();

    protected abstract Label getLabel();
}



public static class SpamAnalyzer extends KeywordAnalyzer {

    private final String[] keywords;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return Label.SPAM;
    }
}



public static class NegativeTextAnalyzer extends KeywordAnalyzer {

    @Override
    protected String[] getKeywords() {
        return new String[]{":(", "=(", ":|"};
    }

    @Override
    protected Label getLabel() {
        return Label.NEGATIVE_TEXT;
    }
}




public static class TooLongTextAnalyzer implements TextAnalyzer {

    private final int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {

        return (text.length() > maxLength) ? Label.TOO_LONG : Label.OK;
    }
}





}