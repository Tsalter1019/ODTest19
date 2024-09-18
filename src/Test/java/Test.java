package Test.java;

public class Test{
    static class Letter {
        char letter;
        int num;

        public Letter(char letter, int num) {
            this.letter = letter;
            this.num = num;
        }

        @Override
        public String toString() {
            return this.letter + "" + this.num;
        }
    }

    public static void main(String[] args) {
        Letter s = new Letter('a',2);
        System.out.println(s);

    }
}