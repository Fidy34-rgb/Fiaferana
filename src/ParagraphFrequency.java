public class ParagraphFrequency implements Comparable<ParagraphFrequency> {
    Integer wordCount;
    String paraWord;

    //Constructor for WordFrequency
    public ParagraphFrequency(Integer wordCount, String paraWord){
        this.wordCount = wordCount;
        this.paraWord = paraWord;
    }

    // Set and get methods
    public String getWord() {return paraWord;}

    public void setWord(String newWord){
        this.paraWord = newWord;
    }

    public Integer getCount() {return wordCount;}  

    public void setCount(Integer newCount){
        this.wordCount = newCount;
    }

    //Comparable interface implementation
    @Override
    public String toString(){
        return "[Word: " + paraWord + ", Count: " + wordCount + "]";
    }

    @Override
    public int compareTo(ParagraphFrequency paraWords){
        Integer countOrder = 2;
        if(this.wordCount > paraWords.wordCount){
            countOrder = 1;
        }
        if(this.wordCount < paraWords.wordCount){
            countOrder = -1;
        }
        if(this.wordCount == paraWords.wordCount){
            countOrder = 0;
        }
        return countOrder;
    }
}
