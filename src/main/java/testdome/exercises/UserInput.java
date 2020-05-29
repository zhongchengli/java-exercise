package testdome.exercises;

public class UserInput {

    public static class TextInput {
        private String value;

        public String getValue(){
            return value;
        }

        public void add(char c){
            if(value == null){
                this.value = String.valueOf(c);
                return;
            }
            StringBuilder sb = new StringBuilder(value);
            sb.append(c);
            this.value = sb.toString();
        }
    }

    public static class NumericInput extends TextInput{

        @Override
        public void add(char c){
            if(Character.isDigit(c)){
                super.add(c);
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
