public class WordFrequency implements Comparable<WordFrequency>{
    Integer count;
    String word;

    //Constructor for WordFrequency
    public WordFrequency(Integer count, String word){
        this.count = count;
        this.word = word;
    }

    // Set and get methods
    public String getWord() {return word;}

    public void setWord(String newWord){
        this.word = newWord;
    }

    public Integer getCount() {return count;}  

    public void setCount(Integer newCount){
        this.count = newCount;
    }

    //Comparable interface implementation
    @Override
    public String toString(){
        return "[Word: " + word + ", Count: " + count + "]";
    }

    @Override
    public int compareTo(WordFrequency words){
        Integer countOrder = 2;
        if(this.count > words.count){
            countOrder = 1;
        }
        if(this.count < words.count){
            countOrder = -1;
        }
        if(this.count == words.count){
            countOrder = 0;
        }
        return countOrder;
    }
}
